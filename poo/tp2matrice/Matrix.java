package tp2matrice;

import java.text.DecimalFormat;

/**
 * Tableau de double. Peut être un tableau à double entrée, ou bien unidimensionnel.<br>
 * En mathématiques, les matrices sont des tableaux de nombres 
 * qui servent à interpréter en termes calculatoires et donc opérationnels 
 * les résultats théoriques de l'algèbre linéaire et même 
 * de l'algèbre bilinéaire. Toutes les disciplines étudiant des 
 * phénomènes linéaires utilisent les matrices. Quant 
 * aux phénomènes non linéaires, on en donne souvent des approximations 
 * linéaires, comme en optique géométrique avec les approximations de <b>Gauss</b>.<br>
 * 
 * Exemple de matrice <b>carré</b> :<br>
 * 
 *     [0, 1, 5]<br>
 * C = [4, 8, 9]<br>
 *     [7, 9, 3]<br>
 * 
 * Exemple de matrice <b>ligne</b> :<br>
 * 
 * L = [0, 1, 5, 6, 8]<br>
 * 
 * Exemple de matrice <b>colonne</b> :<br>
 * 
 *     [9]<br>
 * C = [3]<br>
 *     [4]<br>
 * 
 * Exemple de matrice <b>symétrique</b> :<br>
 * 
 *     [0, 4, 5]<br>
 * S = [4, 8, 9]<br>
 *     [5, 9, 3]<br>
 * 
 * Exemple de matrice <b>identité</b> :<br>
 * 
 *     [1, 0, 0]<br>
 * I = [0, 1, 0]<br>
 *     [0, 0, 1]<br>
 * 
 * 
 * 
 * @author prepain
 * @version 1
 *
 */
public abstract class Matrix {

    /**
     * Nombre de lignes.
     */
    protected int nRow;
    /**
     * Nombre de colonnes.
     */
    protected int nCol;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    /**
     * Construit une matrice avec un nombre de lignes et de colonnes nuls.
     */
    protected Matrix() {
        nRow = 0;
        nCol = 0;
    }

    /**
     * Construit une matrice ayant pour dimensions n lignes et m colonnes.
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
     * @see Matrix#get(int, int)
     */
    public void write() {
        DecimalFormat formatEnDecimales = new DecimalFormat("0.00");
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                System.out.print((col == 0 ? "\n[" : "") + formatEnDecimales.format(this.get(lig, col)) + (col == nCol - 1 ? "]" : ", "));
    }// write()

    /**
     * Affecte des valeurs générées aléatoirement à la matrice
     * @see Matrix#set(int, int, double)
     */
    public void random() {
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, Math.random());
    }// random()

    /**
     * Effectue la somme de la matrice B et de la matrice courante
     * @param B Matrice qui sera ajouté à la matrice courante
     * @return la somme de matrice courante et de la matrice B.
     * @throws ExceptionMatrix les deux matrices doivent être de mêmes dimensions
     * @see Matrix#memeDimension(Matrix)
     * @see Matrix#copy()
     * @see Matrix#get(int, int)
     * @see Matrix#set(int, int, double)
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
     * Effectue la différence de la matrice courante et de la matrice B
     * @param B Matrice qui sera soustrait à la matrice courante
     * @return la différence de la matrice courante et de la matrice B
     * @throws ExceptionMatrix les deux matrices doivent être de mêmes dimensions
     * @see Matrix#memeDimension(Matrix)
     * @see Matrix#copy()
     * @see Matrix#get(int, int)
     * @see Matrix#set(int, int, double)
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
     * Multiplie la matrice this par un scalaire s (s étant un réel)
     * @param s le facteur multiplicateur
     * @return le résultat de la multiplication de la matrice par le scalaire
     * @see Matrix#copy()
     * @see Matrix#get(int, int)
     * @see Matrix#set(int, int, double)
     */
    public Matrix mult(double s) {
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) * s);
        return matrice;
    }// mult()

    /**
     * Effectue le produit de la matrice courante et de la matrice B
     * @param B Matrice qui sera multiplié à la matrice courante
     * @return le produit de la matrice courante et de la matrice B
     * @throws ExceptionMatrix La matrice courante doit avoir autant de colonnes que B a de lignes
     */
    public abstract Matrix mult(Matrix B) throws ExceptionMatrix;

    /**
     * Met à zéros tous les coefficients de la matrice courante
     * @see Matrix#set(int, int, double)
     */
    public void zeros() {
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, 0);
    }// zeros()

    /**
     * Affecte l'identité à la matrice courante
     * @throws ExceptionMatrix la matrice doit être une matrice carré
     * @see Matrix#matriceCarre()
     * @see Matrix#zeros()
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
     * Efectue la transposé de la matrice courante
     * @return la transposé de la matrice courante
     */
    public abstract Matrix transpose();

    /**
     * Retourne un booléen selon si la matrice courante et la matrice B ont les mêmes dimensions
     * @param B Matrice B
     * @return true si les matrices ont les mêmes dimensions, false sinon
     * @see Matrix#getColDimension()
     * @see Matrix#getRowDimension()
     */
    public boolean memeDimension(Matrix B) {
        return B.getColDimension() == this.nCol && B.getRowDimension() == this.nRow;
    }// memeDimension()

    /**
     * @return true si la matrice courante est carré
     */
    public boolean matriceCarre() {
        return this.nRow == this.nCol;
    }// matriceCarre()

    /**
     * @param i Indice de la ligne
     * @param j Indice de la colonne
     * @return l'indice pour un tableau à une dimension
     */
    public int index(int i, int j) {
        return i * this.nCol + j;
    }
    
    /**
     * Renvoie un tableau d'index à partir d'un indice d'un tableau unidimensionnel
     * @param ij l'indice d'un tableau unidimensionnel
     * @return un tableau d'indices
     */
    public int[] indexInv(int ij) {
        return new int[] {ij/nCol, ij%nCol};
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    /**
     * Renvoie le nombre de lignes de la matrice courante
     * @return le nombre de lignes de la matrice courante
     */
    public int getRowDimension() {
        return this.nRow;
    }

    /**
     * Renvoie le nombre de colonnes de la matrice courante
     * @return le nombre de colonnes de la matrice courante
     */
    public int getColDimension() {
        return this.nCol;
    }

    /**
     * Modifie le nombre de lignes de la matrice courante
     * @param nRow nombre de lignes
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
     * Affecte la sous matrice B de dimension (iEnd - iStart +1, jEnd - jStart + 1) à la matrice, des lignes iStart à iEnd, et jStart à jEnd 
     * @param B La sous matrice qui sera tronquée
     * @param iStart l'indice de la ligne (début du tronçon)
     * @param iEnd l'indice de la ligne (fin du tronçon)
     * @param jStart l'indice de la colonne (début du tronçon)
     * @param jEnd l'indice de la colonne (fin de tronçon)
     * @exception ExceptionMatrix xEnd ne doit pas être inférieur à xStart; xStart ne doit pas être inférieur strictement à zéro; xEnd et jStart ne doivent pas être supérieurs aux dimensions de la matrice 
     */
    public void set(Matrix B, int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        if (iStart > iEnd || jStart > jEnd || jStart < 0 || iStart < 0 || iEnd > nRow || jEnd > nCol)
            throw new ExceptionMatrix("Wrong coordinates");
        for (; iStart <= iEnd; iStart++)
            for (int jStart2 = jStart; jStart2 <= jEnd; jStart2++)
                this.set(iStart, jStart2, B.get(iStart, jStart2));
    }// set()

    /**
     * Renvoie la valeur se trouvant à l'indice (i, j)
     * @param i indice de la ligne
     * @param j indice de la colonne
     * @return la valeur se trouvant à l'indice (i, j)
     */
    public abstract double get(int i, int j);

    /**
     * Renvoie la valeur se trouvant à l'indice (ij)
     * @param ij l'indice
     * @return la valeur se trouvant à l'indice (ij)
     * @see Matrix#indexInv(int)
     */
    public abstract double get(int ij);
    
    /**
     * Modifie la valeur à l'indice (i, j)
     * @param i indice de la ligne
     * @param j indice de la colonne
     * @param aij la valeur à placer à l'indice (i, j)
     */
    public abstract void set(int i, int j, double aij);

    /**
     * Modifie la valeur à l'indice (ij)
     * @param ij l'indice
     * @param aij la valeur à placer à l'indice (ij)
     * @see Matrix#indexInv(int)
     */
    public abstract void set(int ij, double aij);
    
    /**
     * Retourne une sous matrice telle que : soient A, B (de dimensions nRow et nCol; nRow et nCol étant réels), B = A(iStart : iEnd, jStart : jEnd)
     * @param iStart l'indice de la ligne (début du tronçon)
     * @param iEnd l'indice de la ligne (fin du tronçon)
     * @param jStart l'indice de la colonne (début du tronçon)
     * @param jEnd l'indice de la colonne (fin de tronçon)
     * @exception ExceptionMatrix xEnd ne doit pas être inférieur à xStart; xStart ne doit pas être inférieur strictement à zéro; xEnd et jStart ne doivent pas être supérieurs aux dimensions de la matrice 
     * @return la valeur à l'indice (i, j) de la matrice
     */
    public abstract Matrix get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix;
}
