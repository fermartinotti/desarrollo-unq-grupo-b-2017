package morfiya.domain;

public class Telefono extends Entity{
	
	private static final long serialVersionUID = -785467544755502668L;
	String codigoDeArea;
	String numero;
	
	public String getCodigoDeArea() {
		return codigoDeArea;
	}

	public void setCodigoDeArea(String codigoDeArea) {
		this.codigoDeArea = codigoDeArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Telefono (String codigoDeArea, String numero) {
		super();
		this.codigoDeArea = codigoDeArea;
		this.numero = numero;
	}
	
	public Telefono () {
		super();
	}
}
