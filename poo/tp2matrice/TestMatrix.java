package tp2matrice;

public class TestMatrix {

    public static void main(String[] args) {
        try {
            DenseMatrix2D d = new DenseMatrix2D(1000,1200);
            DenseMatrix2D e = new DenseMatrix2D(1200, 1000);
            long startTime;
            long estimatedTime;
            startTime = System.nanoTime();
            e=d.mult(e);
            estimatedTime = System.nanoTime()-startTime;
            System.out.println(estimatedTime/1000000000.0+"\nFIN");
        }
        catch (ExceptionMatrix e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
