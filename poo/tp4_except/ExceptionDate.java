package tp4_except;

public class ExceptionDate extends Exception {
	private static final long serialVersionUID = 1318854149637628009L;
	public ExceptionDate(String parMessage) {
		super(parMessage) ;
	}
	public ExceptionDate() {
		super() ;
	}
}
