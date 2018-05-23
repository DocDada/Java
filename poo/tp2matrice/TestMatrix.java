package tp2matrice;

public class TestMatrix {

    public static void main(String[] args) {
        try {
            /*double A[][] = {{4,1,2}, {0,1,1}, {1,-2, 0}};
            double B[][] = {{2,-1,1}, {0,1,0}};
            double C[][] = {{3,-1}, {1,0}, {0,2}};
            DenseMatrix2D a = new DenseMatrix2D(A);
            DenseMatrix2D b = new DenseMatrix2D(B);
            DenseMatrix2D c = new DenseMatrix2D(C);
            //Matrix ab = a.mult2(b);
            //System.out.println(ab);
            
            Matrix ac = a.mult(c);
            System.out.println("AC");
            ac.write();
            Matrix ba = b.mult(a);
            System.out.println("BA");
            ba.write();*/
            /*DenseMatrix2D d = new DenseMatrix2D(1000,1200);
            DenseMatrix2D e = new DenseMatrix2D(1200, 1000);
            long startTime;
            long estimatedTime;
            startTime = System.nanoTime();
            e=d.mult(e);
            estimatedTime = System.nanoTime()-startTime;
            System.out.println(estimatedTime/1000000000.0+"\nFIN");*/
            /*
            Matrix matA, matB;
            int choix = Clavier.lireInt();
            if (choix==1) {
                matA=new DenseMatrix1D(800,800);
                matB=new DenseMatrix1D(800,800);
            }
            else {
                matA=new DenseMatrix2D(800,800);
                matB=new DenseMatrix2D(800,800);
            }
            matA.random();
            matB.random();
            long startTime = System.nanoTime();
            Matrix matC = ((DenseMatrix1D) matA).sum2(matB);
            long estimatedTime = System.nanoTime()-startTime;
            System.out.println("ESTIMATED TIME : "+estimatedTime/1000000000.0);
            */
            System.out.println("E");
            DenseMatrixSymetrique s = new DenseMatrixSymetrique(5);
            //s.write();
            s.set(4, 10);
            System.out.println(" "+s.get(2, 2));
            System.exit(0);
            System.out.println("E");
            DenseMatrixSymetrique e = new DenseMatrixSymetrique(5);
            e.random();
            e.write();
            DenseMatrixSymetrique p = (DenseMatrixSymetrique) e.mult(s);
            System.out.println("E");
            
        }
        catch (ExceptionMatrix e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
