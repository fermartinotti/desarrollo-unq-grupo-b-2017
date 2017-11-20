package morfiya.updates;

import morfiya.domain.Direccion;
import morfiya.domain.Entity;
import morfiya.domain.Habilitacion;
import morfiya.domain.Telefono;
import morfiya.exceptions.DatoInvalidoException;

public class ClienteUpdate extends Entity {

	private static final long serialVersionUID = 1L;
	
	private Integer cuit;
	private String nombre;
	private String apellido;
	private String email;
	private Telefono telefono;
	private Direccion direccion;
	private Double creditos = 0.0;
	private Habilitacion puedeComprar = Habilitacion.HABILITADO;

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Double getCreditos() {
		return creditos;
	}

	public Habilitacion getEstado() {
		return puedeComprar;
	}

	public void habilitarCliente() {
		puedeComprar = Habilitacion.HABILITADO;
	}

	public void deshabilitarCliente() {
		puedeComprar = Habilitacion.INHABILITADO;
	}

	public Boolean puedeComprar() {
		return (puedeComprar == Habilitacion.HABILITADO);
	}

	public void cargarCredito(Double cantidad) throws DatoInvalidoException {
		if (cantidad < 0.0) {
			throw new DatoInvalidoException("No se puede cargar saldo negativo");
		}
		creditos += cantidad;
	}

	public void retirarCreditos(Double cantidad) throws DatoInvalidoException {
		if (cantidad < 0.0) {
			throw new DatoInvalidoException("No se puede retirar una cantidad negativa de creditos");
		}
		if (cantidad > creditos) {
			throw new DatoInvalidoException("No tiene saldo suficiente para retirar la cantidad ingresada");
		}
		creditos -= cantidad;
	}

	public ClienteUpdate() {
		super();
	}
  
	public ClienteUpdate(Integer cuit, String nombre, String apellido, String email, Telefono telefono, Direccion direccion, Double creditos) {
		
		if(cuit!=null)
			this.setCuit(cuit);
		
		if(nombre!=null)
			this.setNombre(nombre);
		
		if(apellido!=null)
			this.setApellido(apellido);
		
		if(email !=null)
			this.setEmail(email);
		
		if(telefono!=null)
			this.setTelefono(telefono);
		
		if(direccion!=null)
			this.setDireccion(direccion);
		
		if(creditos!=null)
				this.cargarCredito(creditos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		long temp;
		temp = Double.doubleToLongBits(creditos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puedeComprar == null) ? 0 : puedeComprar.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteUpdate other = (ClienteUpdate) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (Double.doubleToLongBits(creditos) != Double.doubleToLongBits(other.creditos))
			return false;
		if (cuit == null) {
			if (other.cuit != null)
				return false;
		} else if (!cuit.equals(other.cuit))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puedeComprar != other.puedeComprar)
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}
