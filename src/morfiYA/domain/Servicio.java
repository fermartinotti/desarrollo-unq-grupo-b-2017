package morfiYA.domain;

import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;
import morfiYA.exceptions.MenuException;

public class Servicio {
	
	private String nombre;
	private List<Menu> menues; 
	// LOGO ??  
	private Direccion direccion;
	private String descripcion;
	private String link; // Referencia a la direccion web o al link de su perfil de FB.
	private String email;
	private Telefono telefono;
	private DiasDeAtencion atencionAlPublico;
	private Localidad localidadDeEntregas;
	Integer maximoDeMenusVigentes = 20;
	
	public void agregarMenu(Menu menu) throws MenuException {
		if(menues.size() >= getMaximoDeMenusVigentes()) {
			throw new MenuException("Llego a su limite de menues permitidos");
		}			
		menues.add(menu);		
	}
	
	public Integer getMaximoDeMenusVigentes() {
		return maximoDeMenusVigentes;
	}

	public void setMaximoDeMenuesVigentes(Integer maximoDeMenuesVigentes) {
		this.maximoDeMenusVigentes = maximoDeMenuesVigentes;
	}

	public void eliminarMenu(Menu menu) {
		menues.remove(menu);	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Menu> getMenues() {
		return menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws DatoInvalidoException{
		if (descripcion.length() <30) {
			throw new DatoInvalidoException("Descripcion demasiado corta");
		}
		if (descripcion.length() > 200) {
			throw new DatoInvalidoException("Descripcion demasiado larga");
		}
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public DiasDeAtencion getAtencionAlPublico() {
		return atencionAlPublico;
	}

	public void setAtencionAlPublico(DiasDeAtencion atencionAlPublico) {
		this.atencionAlPublico = atencionAlPublico;
	}

	public Localidad getLocalidadDeEntregas() {
		return localidadDeEntregas;
	}

	public void setLocalidadDeEntregas(Localidad localidadDeEntregas) {
		this.localidadDeEntregas = localidadDeEntregas;
	}
		
}
