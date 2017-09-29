package morfiya.domain;

public class Telefono extends Entity{
	
	private static final long serialVersionUID = -785467544755502668L;
	String codigoDeArea;
	String numero;
	
	public Telefono (String codigoDeArea, String numero) {
		super();
		this.codigoDeArea = codigoDeArea;
		this.numero = numero;
	}
}
