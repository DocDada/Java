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
}// DenseMatrix
