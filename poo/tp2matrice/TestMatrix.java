package tp2matrice;

public class TestMatrix {

    public static void main(String[] args) {
        try {
            double A[][] = {{4,1,2}, {0,1,1}, {1,-2, 0}};
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
            ba.write();
            /*DenseMatrix2D d = new DenseMatrix2D(1000,1200);
            DenseMatrix2D e = new DenseMatrix2D(1200, 1000);
            long startTime;
            long estimatedTime;
            startTime = System.nanoTime();
            e=d.mult(e);
            estimatedTime = System.nanoTime()-startTime;
            System.out.println(estimatedTime/1000000000.0+"\nFIN");*/
        }
        catch (ExceptionMatrix e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
