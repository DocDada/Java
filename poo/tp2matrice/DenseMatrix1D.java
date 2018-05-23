package tp2matrice;

/**
 * 
 * @author prepain
 *
 */
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

    public Matrix mult(Matrix B) throws ExceptionMatrix {
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

    /**
     * Effectue la somme de la matrice courante et de la matrice passée en paramètre. Méthode plus rapide que sum.
     * @param B Matrice qui sera ajouté à la matrice courante
     * @return La somme de la matrice B et de la matrice courante
     * @throws ExceptionMatrix les deux matrices doivent être de mêmes dimensions
     */
    public Matrix sum2(Matrix B) throws ExceptionMatrix {
        if (!this.memeDimension(B))
            throw new ExceptionMatrix("Invalid dimension");
        DenseMatrix1D matrice = (DenseMatrix1D) this.copy();
        for (int ij = 0; ij < this.vals.length; ij++)
                matrice.vals[ij] = this.vals[ij] + B.get(ij/nCol, ij%nCol);
        return matrice;
    }// sum()

    public Matrix transpose() {
        DenseMatrix1D matrice = new DenseMatrix1D(this.nCol, this.nRow);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                matrice.set(col, lig, this.get(lig, col));
        return matrice;
    }

    public Matrix copy() {
        DenseMatrix1D copie = new DenseMatrix1D(this.nRow, this.nCol);
        for (int lig = 0; lig < nRow; lig++)
            for (int col = 0; col < nCol; col++)
                copie.set(lig, col, this.get(lig, col));
        return copie;
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
    
    public double get(int ij) {
        return this.vals[ij];
    }
    
    public void set(int ij, double aij) {
        this.vals[ij] = aij;
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
