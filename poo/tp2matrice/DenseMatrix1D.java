package tp2matrice;

public class DenseMatrix1D extends Matrix {

    double vals[];

    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////

    public DenseMatrix1D() {
        super();
        this.vals = null;
    }

    public DenseMatrix1D(int row, int col) {
        super(row, col);
        this.vals = new double[this.nRow * this.nCol];
    }

    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    public DenseMatrix1D mult(Matrix B) throws ExceptionMatrix {
        if (nCol != B.getRowDimension())
            throw new ExceptionMatrix("Invalid dimensions");
        DenseMatrix1D matrice = new DenseMatrix1D(this.nRow, B.nCol);
        double aij = 0;
        for (int lig = 0; lig < nRow; lig++)
            for (int col2 = 0; col2 < B.getColDimension(); col2++) {
                for (int col = 0; col < nCol; col++)
                    aij += this.get(lig, col) * B.get(col, col2);
                matrice.set(lig, col2, aij);
                aij = 0;
            }
        return matrice;
    }

    public DenseMatrix1D transpose() {
        // retourne la transposée d'une matrice
        DenseMatrix1D matrice = new DenseMatrix1D(this.nCol, this.nRow);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(col, lig, this.get(lig, col));
        return matrice;
    }

    public DenseMatrix1D copy() {
        // copie la matrice courante dans une nouvelle matrice de même type
        DenseMatrix1D copie = new DenseMatrix1D(this.nRow, this.nCol);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                copie.set(lig, col, this.get(lig, col));
        return copie;
    }

    public int index(int i, int j) {
        return i * this.nCol + j;
    }

    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public double get(int i, int j) {
        return this.vals[index(i, j)];
    }

    public void set(int i, int j, double aij) {
        this.vals[index(i, j)] = aij;
    }

    public DenseMatrix1D get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        // i : row ; j : col
        if (iStart > iEnd || jStart > jEnd || jStart < 0 || iStart < 0 || iEnd >= nRow || jEnd >= nCol)
            throw new ExceptionMatrix("Wrong coordinates");
        DenseMatrix1D matrice = new DenseMatrix1D(iEnd - iStart + 1, jEnd - jStart + 1);
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

}
