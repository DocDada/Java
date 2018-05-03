package matrice;

public class TestMatrix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DenseMatrix vide = new DenseMatrix();
        double truc[][] = {{1,2},{3,2},{9,1}};
        double truc2[][] = {{4,8},{3,1}};
        DenseMatrix deux = new DenseMatrix(truc);
        DenseMatrix deux2 = new DenseMatrix(truc2);
        DenseMatrix trois = new DenseMatrix(2,3);// 2 lignes, 3 colonnes
        
        DenseMatrix mach[]= {deux, deux2};
        for(DenseMatrix machin:mach) {
            System.out.println("\nCOLONNES : "+machin.getColDimension()+" ; LIGNES : "+machin.getRowDimension()+"\n");
            machin.write();
        }
        try {
            System.out.println("\nMULTIPLICATION");
            deux=deux.mult(deux2);
        }
        catch(ExceptionMatrix e){
            System.out.println(e);
        }
        deux.write();
        //deux=deux.transpose();
        //deux.write();
    }

}
