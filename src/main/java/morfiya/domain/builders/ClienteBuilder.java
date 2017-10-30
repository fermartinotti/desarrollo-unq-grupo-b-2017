package morfiya.domain.builders;

import morfiya.domain.Cliente;
import morfiya.domain.Direccion;
import morfiya.domain.Telefono;

public class ClienteBuilder {
	private Integer cuit;
	private String nombre;
	private String apellido;
	private String email;
	private Telefono telefono;
	private Direccion direccion;
	private double creditos = 0;
	
	private ClienteBuilder() {}
	
	public static ClienteBuilder mkBuilder(){
        return new ClienteBuilder();
    }
	
	public ClienteBuilder withCuit(){
        this.cuit = 37179092;
        return this;
    }

	public ClienteBuilder withNombreYApellido(String nombre, String apellido) {
		this.nombre= nombre;
		this.apellido= apellido;
		return this;
	}
	
	public ClienteBuilder withEmail(String email){
        this.email= email;
        return this;
    }
	
	public ClienteBuilder withTelefono(String codArea, String numero){
        this.telefono= new Telefono(codArea, numero);
        return this;
    }
	
	public ClienteBuilder withCreditosDisponibles(double creditos){
        this.creditos= creditos;
        return this;
    }

	public Cliente build() {
        Cliente cliente = new Cliente(this.cuit, this.nombre, this.apellido, 
        		this.email, this.telefono, this.direccion, this.creditos);
        return cliente;
    }

}
