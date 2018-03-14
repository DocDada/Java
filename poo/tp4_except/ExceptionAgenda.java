package tp4_except;

public class ExceptionAgenda extends Exception{
	private static final long serialVersionUID = 1L;
	public ExceptionAgenda(String parMessage) {
		super(parMessage);
	}
	public ExceptionAgenda() {
		super();
	}
}
