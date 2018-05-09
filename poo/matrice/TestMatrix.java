package matrice;

public class TestMatrix {

    public static void main(String[] args) {

        try {
            /*
             * TESTS :
             *   
             *   [4, 1,-2]
             * A=[0, 1, 1]
             *   [1,-2, 0]
             * 
             * B=[2,-1, 1]
             *   [0, 1, 0]
             *  
             *   [3,-1]
             * C=[1, 0]
             *   [0, 2]
             * 
             * */
            //DenseMatrix vide = new DenseMatrix();
            //double truc[][] = { { 1, 2 }, { 3, 2 }, { 9, 1 } };
            //double truc2[][] = { { 4, 8 }, { 3, 1 } };
            double A[][] = { { 4, 1, -2 }, { 0, 1, 1 }, { 1, -2, 0 } };
            double B[][] = { { 2, -1, 1 }, { 0, 1, 0 } };
            double C[][] = { { 3, -1 }, { 1, 0 }, { 0, 2 } };
            DenseMatrix a = new DenseMatrix(A);
            DenseMatrix b = new DenseMatrix(B);
            DenseMatrix c = new DenseMatrix(C);
            /*DenseMatrix deux = new DenseMatrix(truc);
            DenseMatrix deux2 = new DenseMatrix(truc2);
            DenseMatrix trois = new DenseMatrix(2, 3);// 2 lignes, 3 colonnes
            
            System.out.println("MATRICE DEUX : ");
            deux.write();
            DenseMatrix copie = new DenseMatrix(deux.getRowDimension(), deux.getColDimension());
            System.out.println("MATRICE COPIE : ");
            copie.write();
            
            copie = deux.get(0, 2, 0, 1);// lig, col
            System.out.println("MATRICE COPIE APRES GET : ");
            copie.write();*/
            System.out.println("Transposee de A");
            DenseMatrix at = a.transpose();
            at.write();
            System.out.println("Transposee de B");
            DenseMatrix bt = b.transpose();
            bt.write();
            System.out.println("Transposee de C");
            DenseMatrix ct = c.transpose();
            ct.write();
            System.out.println("B+Ct");
            b.sum(ct).write();
            System.out.println("C+3Bt");
            c.sum(b.transpose().mult(3)).write();
            System.out.println("A*B");
            //a.mult(b).write();
            System.out.println("A*C");
            a.mult(c).write();
            System.out.println("B*A");//
            b.mult(a).write();
            System.out.println("B*C");
            b.mult(c).write();
            System.out.println("C*A");
            //c.mult(a).write();
            System.out.println("C*B");//
            c.mult(b).write();
            System.out.println("A^2");
            a.mult(a).write();
            System.out.println("At*A");
            at.mult(a).write();
            System.out.println("A*At");
            a.mult(at).write();
            System.out.println("A.get(1,2,0,1)");
            at.get(0, 1, 1,2).write();
            System.out.println("FIN");
        }
        catch (ExceptionMatrix e) {
            System.out.println(e);
        }

    }

}
