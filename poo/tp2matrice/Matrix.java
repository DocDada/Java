package tp2matrice;

import java.text.DecimalFormat;

/**
 * 
 * @author prepain
 *
 */
public abstract class Matrix {

    protected int nRow;
    protected int nCol;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    /**
     * Construit une matrice avec un nombre de lignes et de colonnes nul
     */
    protected Matrix() {
        nRow = 0;
        nCol = 0;
    }

    /**
     * Construit une matrice ayant pour dimensions n lignes et m colonnes
     * @param n nombre de lignes
     * @param m nombre de colonnes
     */
    protected Matrix(int n, int m) {
        nRow = n;
        nCol = m;
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    /**
     * Affiche la matrice dans la console
     */
    public void write() {
        DecimalFormat formatEnDecimales = new DecimalFormat("0.00");
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                System.out.print((col == 0 ? "\n[" : "") + formatEnDecimales.format(get(lig, col)) + (col == nCol - 1 ? "]" : ", "));
    }// write()

    /**
     * Affecte des valeurs g�n�r�es al�atoirement � la matrice
     */
    public void random() {
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, Math.random());
    }// random()

    /**
     * @param B Matrice qui sera ajout� � la matrice courante
     * @return La somme de la matrice B et de la matrice courante
     * @throws ExceptionMatrix les deux matrices doivent �tre de m�mes dimensions
     */
    public Matrix sum(Matrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) + B.get(lig, col));
        return matrice;
    }// sum()

    /**
     * @param B Matrice qui sera soustrait � la matrice courante
     * @return La diff�rence de la matrice courante et de la matrice B
     * @throws ExceptionMatrix les deux matrices doivent �tre de m�mes dimensions
     */
    public Matrix minus(Matrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) - B.get(lig, col));
        return matrice;
    }// minus()

    /**
     * Multiplie la matrice this par un scalaire s (s �tant un r�el)
     * @param s le facteur multiplicateur
     * @return Le r�sultat de la multiplication de la matrice par le scalaire
     */
    public Matrix mult(double s) {
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) * s);
        return matrice;
    }// mult()

    /**
     * 
     * @param B Matrice qui sera multipli� � la matrice courante
     * @return le produit de la matrice courante et de la matrice B
     * @throws ExceptionMatrix La matrice courante doit avoir autant de colonnes que B a de lignes
     */
    public abstract Matrix mult(Matrix B) throws ExceptionMatrix;

    /**
     * Met � z�ros tous les coefficients de la matrice courante
     */
    public void zeros() {
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, 0);
    }// zeros()

    /**
     * Affecte l'identit� � la matrice courante
     * @throws ExceptionMatrix la matrice doit �tre une matrice carr�
     */
    public void identity() throws ExceptionMatrix {
        if (!this.matriceCarre())
            throw new ExceptionMatrix("Identity must be a square matrix");
        this.zeros();
        for (int ligCol = 0; ligCol < nRow; ligCol++)
            this.set(ligCol, ligCol, 1);
    }// identity()

    /**
     * Copie par valeur
     * @return Copie de la matrice courante
     */
    public abstract Matrix copy();

    /**
     * @return La transpos� de la matrice courante
     */
    public abstract Matrix transpose();

    /**
     * Retourne un bool�en selon si la matrice courante et la matrice B ont les m�mes dimensions
     * @param B Matrice B
     * @return true si les matrices ont les m�mes dimensions, false sinon
     */
    public boolean memeDimension(Matrix B) {
        return B.getColDimension() == this.nCol && B.getRowDimension() == this.nRow;
    }// memeDimension()

    /**
     * @return true si la matrice courante est carr�
     */
    public boolean matriceCarre() {
        return this.nRow == this.nCol;
    }// matriceCarre()

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    /**
     * @return Le nombre de lignes de la matrice courante
     */
    public int getRowDimension() {
        return this.nRow;
    }

    /**
     * @return Le nombre de colonnes de la matrice courante
     */
    public int getColDimension() {
        return this.nCol;
    }

    /**
     * Modifie le nombre de lignes de la matrice courante
     * @param nRow Nombre de lignes
     */
    public void setRowDimension(int nRow) {
        this.nRow = nRow;
    }

    /**
     * Modifie le nombre de colonnes de la matrice courante
     * @param nCol Nombre de colonnes
     */
    public void setColDimension(int nCol) {
        this.nCol = nCol;
    }

    /**
     * Affecte la sous matrice B de dimension (iEnd - iStart +1, jEnd - jStart + 1) � la matrice, des lignes iStart � iEnd, et jStart � jEnd 
     * @param B La sous matrice qui sera tronqu�e
     * @param iStart l'indice de la ligne (d�but du tron�on)
     * @param iEnd l'indice de la ligne (fin du tron�on)
     * @param jStart l'indice de la colonne (d�but du tron�on)
     * @param jEnd l'indice de la colonne (fin de tron�on)
     * @exception ExceptionMatrix xEnd ne doit pas �tre inf�rieur � xStart; xStart ne doit pas �tre inf�rieur strictement � z�ro; xEnd et jStart ne doivent pas �tre sup�rieurs aux dimensions de la matrice 
     */
    public void set(Matrix B, int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        // i : row ; j : col
        if (iStart > iEnd || jStart > jEnd || jStart < 0 || iStart < 0 || iEnd > nRow || jEnd > nCol)
            throw new ExceptionMatrix("Wrong coordinates");
        for (; iStart <= iEnd; iStart++)
            for (int jStart2 = jStart; jStart2 <= jEnd; jStart2++)
                this.set(iStart, jStart2, B.get(iStart, jStart2));
    }// set()

    public abstract double get(int i, int j);

    public abstract void set(int i, int j, double aij);

    /** retourne une sous matrice telle que : soient A, B (de dimensions nRow et nCol; nRow et nCol �tant r�els), B = A(iStart : iEnd, jStart : jEnd)
     * @param iStart l'indice de la ligne (d�but du tron�on)
     * @param iEnd l'indice de la ligne (fin du tron�on)
     * @param jStart l'indice de la colonne (d�but du tron�on)
     * @param jEnd l'indice de la colonne (fin de tron�on)
     * @exception ExceptionMatrix xEnd ne doit pas �tre inf�rieur � xStart; xStart ne doit pas �tre inf�rieur strictement � z�ro; xEnd et jStart ne doivent pas �tre sup�rieurs aux dimensions de la matrice 
     * @return la valeur � l'indice (i, j) de la matrice
     */
    public abstract Matrix get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix;
}
