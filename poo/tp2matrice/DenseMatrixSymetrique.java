package tp2matrice;

/**
 * 
 * @author prepain
 *
 */
public class DenseMatrixSymetrique extends Matrix {
    
    private double vals[];
    
    ///////////////////////
    //                   //
    //   CONSTRUCTEURS   //
    //                   //
    ///////////////////////
    
    public DenseMatrixSymetrique() {
        super();
        this.vals = null;
    }

    public DenseMatrixSymetrique(int n) {
        super(n, n);
        this.vals = new double[(n*(n+1))/2];
    }


    //////////////////////
    //                  //
    //     METHODES     //
    //                  //
    //////////////////////

    @Override
    public Matrix mult(Matrix B) throws ExceptionMatrix {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Matrix copy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Matrix transpose() {
        // TODO Auto-generated method stub
        return null;
    }


    //////////////////////
    //                  //
    //    ACCESSEURS    //
    //        ET        //
    //    MODIFIEURS    //
    //                  //
    //////////////////////

    public double get(int i, int j) {
        if(j>=getColDimension()/2)
            return vals[index(j, i)];
        return vals[index(i, j)];
    }

    @Override
    public void set(int i, int j, double aij) {
        if (j>=getColDimension()/2)
            this.vals[index(j, i)] = aij;
        this.vals[index(i, j)] = aij;
    }

    @Override
    public Matrix get(int iStart, int iEnd, int jStart, int jEnd) throws ExceptionMatrix {
        // TODO Auto-generated method stub
        return null;
    }

    public double get(int ij) {
        return this.vals[ij];
    }
    
    public void set(int ij, double aij) {
        this.vals[ij] = aij;
    }


}
