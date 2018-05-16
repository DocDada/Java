package tp2matrice;

import java.text.DecimalFormat;

public abstract class Matrix {

    protected int nRow;
    protected int nCol;

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    protected Matrix() {
        nRow = 0;
        nCol = 0;
    }

    protected Matrix(int n, int m) {
        nRow = n;
        nCol = m;
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public void write() {
        DecimalFormat formatEnDecimales = new DecimalFormat("0.00");
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                System.out.print((col == 0 ? "\n[" : "") + formatEnDecimales.format(get(lig, col)) + (col == nCol - 1 ? "]" : ", "));
    }// write()

    public void random() {
        // affecte des valeurs générées aléatoirement
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, Math.random());
    }// random()

    public Matrix sum(Matrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) + B.get(lig, col));
        return matrice;
    }// sum()

    public Matrix minus(Matrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) - B.get(lig, col));
        return matrice;
    }// minus()

    public Matrix mult(double s) {
        Matrix matrice = this.copy();
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(lig, col, matrice.get(lig, col) * s);
        return matrice;
    }// mult()

    public abstract Matrix mult(Matrix B) throws ExceptionMatrix;

    public void zeros() {
        // met à zéros tous les coefficients de la matrice
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.set(lig, col, 0);
    }// zeros()

    public void identity() throws ExceptionMatrix {
        if (!this.matriceCarre())
            throw new ExceptionMatrix("Identity must be a square matrix");
        // affecte l'identité à la matrice courante
        this.zeros();
        for (int ligCol = 0; ligCol < nRow; ligCol++)
            this.set(ligCol, ligCol, 1);
    }// identity()

    public abstract Matrix copy();

    public abstract Matrix transpose();

    public boolean memeDimension(Matrix B) {
        return B.getColDimension() == this.nCol && B.getRowDimension() == this.nRow;
    }// memeDimension()

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

    public int getRowDimension() {
        return this.nRow;
    }

    public int getColDimension() {
        return this.nCol;
    }

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

    public abstract Matrix get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix;
}
