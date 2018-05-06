package matrice;

public class TestMatrix {

    public static void main(String[] args) {

        try {
            DenseMatrix vide = new DenseMatrix();
            double truc[][] = { { 1, 2 }, { 3, 2 }, { 9, 1 } };
            double truc2[][] = { { 4, 8 }, { 3, 1 } };
            DenseMatrix deux = new DenseMatrix(truc);
            DenseMatrix deux2 = new DenseMatrix(truc2);
            DenseMatrix trois = new DenseMatrix(2, 3);// 2 lignes, 3 colonnes

            System.out.println("MATRICE DEUX : ");
            deux.write();
            DenseMatrix copie = new DenseMatrix(deux.getRowDimension(), deux.getColDimension());
            System.out.println("MATRICE COPIE : ");
            copie.write();

            copie = deux.get(0, 2, 0, 1);// lig, col
            System.out.println("MATRICE COPIE APRES GET : ");
            copie.write();
        }
        catch (ExceptionMatrix e) {
            System.out.println(e);
        }

    }

}
