package matrice;

import java.text.DecimalFormat;

public class DenseMatrix {

    private int nRow;
    private int nCol;
    private double vals[][];

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public DenseMatrix() {
        nRow = 0;
        nCol = 0;
        vals = null;
    }

    public DenseMatrix(double[][] mat) {
        nRow = mat.length;
        nCol = mat[0].length;
        vals = mat;
    }

    public DenseMatrix(int n, int m) {
        nRow = n;
        nCol = m;
        vals = new double[nRow][nCol];
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public boolean memeDimension(DenseMatrix B) {
        return B.getColDimension() == this.nCol && B.getRowDimension() == this.nRow;
    }

    public boolean matriceCarre() {
        return this.nRow == this.nCol;
    }

    public void write() {
        DecimalFormat formatEnDecimales = new DecimalFormat("0.00");
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                System.out.print((col == 0 ? "\n[" : "") + formatEnDecimales.format(get(lig, col)) + (col == nCol - 1 ? "]" : ", "));
    }

    public DenseMatrix sum(DenseMatrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        DenseMatrix matrice = this;
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.vals[lig][col] += B.get(lig, col);
        return matrice;
    }

    public DenseMatrix minus(DenseMatrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        DenseMatrix matrice = this;
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.vals[lig][col] -= B.get(lig, col);
        return matrice;
    }

    public DenseMatrix mult(double s) {
        DenseMatrix matrice = this;
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.vals[lig][col] *= s;
        return matrice;
    }

    public DenseMatrix mult(DenseMatrix B) throws ExceptionMatrix {
        if (nCol != B.getRowDimension())
            throw new ExceptionMatrix("Invalid dimensions");
        DenseMatrix matrice = new DenseMatrix(this.nRow, this.nCol);
        for (int lig = 0; lig < nRow; lig++)
            for (int col2 = 0; col2 < B.getColDimension(); col2++) {
                double aij = 0;
                for (int col = 0; col < nCol; col++)
                    aij += this.get(lig, col) * B.get(col, col2);
                matrice.vals[lig][col2] = aij;
            }
        return matrice;
    }

    public DenseMatrix transpose() {
        DenseMatrix matrice = new DenseMatrix(this.nCol, this.nRow);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.vals[col][lig] = this.vals[lig][col];
        return matrice;
    }

    public DenseMatrix copy() {
        // copie la matrice courante dans une nouvelle matrice de même type
        DenseMatrix copie = new DenseMatrix(this.nRow, this.nCol);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                copie.vals[lig][col] = this.vals[lig][col];
        return copie;
    }

    public void zeros() {
        // met à zéros tous les coefficients de la matrice
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.vals[lig][col] = 0;
    }

    public void identity() throws ExceptionMatrix {
        if (this.matriceCarre())
            throw new ExceptionMatrix("Identity must be a square matrix");
        // affecte l'identité à la matrice courante
        this.zeros();
        for (int ligCol = 0; ligCol < nRow; ligCol++)
            this.vals[ligCol][ligCol] = 1;
    }

    public void random() {
        // affecte des valeurs générées aléatoirement
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                this.vals[lig][col] = Math.random();
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public int getRowDimension() {
        return nRow;
    }

    public int getColDimension() {
        return nCol;
    }

    public double get(int i, int j) {
        return vals[i][j];
    }

    public void set(int i, int j, double aij) {
        vals[i][j] = aij;
    }

    public DenseMatrix get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        if (iStart > iEnd || jStart > jEnd || jStart < 0 || iStart < 0 || iEnd > nRow || jEnd > nCol)
            throw new ExceptionMatrix("Wrong coordinates");
        DenseMatrix matrice = new DenseMatrix(jEnd - jStart + 1, iEnd - iStart + 1);
        for (int lig = 0; iStart < iEnd; iStart++, lig++)
            for (int col = 0, jStart2 = jStart; jStart2 < jEnd; jStart2++, col++)
                matrice.vals[lig][col] = this.vals[iStart][jStart2];
        return matrice;
    }

    public void set(DenseMatrix B, int iStart, int iEnd, int jStart, int jEnd) {

    }

}// DenseMatrix
