package tp2matrice;

public class DenseMatrix2D extends Matrix {

    private double vals[][];

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public DenseMatrix2D() {
        super();
        vals = null;
    }

    public DenseMatrix2D(double[][] mat) {
        super(mat.length, mat[0].length);
        vals = mat;
    }

    public DenseMatrix2D(int row, int col) {
        super(row, col);
        vals = new double[nRow][nCol];
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public DenseMatrix2D mult(Matrix B) throws ExceptionMatrix {
        if (nCol != B.getRowDimension())
            throw new ExceptionMatrix("Invalid dimensions");
        DenseMatrix2D matrice = new DenseMatrix2D(this.nRow, B.nCol);
        double aij = 0;
        for (int lig = 0; lig < nRow; lig++)
            for (int col2 = 0; col2 < B.getColDimension(); col2++) {
                for (int col = 0; col < nCol; col++)
                    aij += this.get(lig, col) * B.get(col, col2);
                matrice.set(lig, col2, aij);
                aij = 0;
            }
        return matrice;
    }// mult()

    public DenseMatrix2D transpose() {
        // retourne la transposée d'une matrice
        DenseMatrix2D matrice = new DenseMatrix2D(this.nCol, this.nRow);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.vals[col][lig] = this.vals[lig][col];
        return matrice;
    }// transpose()

    public DenseMatrix2D copy() {
        // copie la matrice courante dans une nouvelle matrice de même type
        DenseMatrix2D copie = new DenseMatrix2D(this.nRow, this.nCol);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                copie.set(lig, col, this.get(lig, col));
        return copie;
    }// copy()

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public double get(int i, int j) {
        return vals[i][j];
    }

    public void set(int i, int j, double aij) {
        vals[i][j] = aij;
    }

    public DenseMatrix2D get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        // i : row ; j : col
        if (iStart > iEnd || jStart > jEnd || jStart < 0 || iStart < 0 || iEnd >= nRow || jEnd >= nCol)
            throw new ExceptionMatrix("Wrong coordinates");
        DenseMatrix2D matrice = new DenseMatrix2D(iEnd - iStart + 1, jEnd - jStart + 1);
        /*
        for (int i=0; iStart <= iEnd; iStart++, i++)
            for (int jStart2 = jStart, j=0; jStart2 <= jEnd; jStart2++, j++)
                matrice.vals[i][j] = this.vals[jStart2][iStart];
        */
        for (int i = 0; i < matrice.nRow; i++)
            for (int j = 0; j < matrice.nCol; j++)
                matrice.set(i, j, this.get(j + jStart, i + iStart));
        return matrice;
    }// get()

}// DenseMatrix
