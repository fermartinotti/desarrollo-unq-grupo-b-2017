package morfiya.domain;

import java.util.ArrayList;
import java.util.List;

import morfiya.exceptions.DatoInvalidoException;
import morfiya.exceptions.MenuException;

public class Servicio extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Menu> menus = new ArrayList<Menu>();	//falta mapear
	private String logo = "http://marketing.cdn.telefe.com/wp-content/uploads/2017/04/Logo-morfi-la-pe%C3%B1a.jpg?x97692";  
	private Direccion direccion;
	private String descripcion;
	private String link; // Referencia a la direccion web o al link de su perfil de FB.
	private String email;
	private Telefono telefono;
	private DiasDeAtencion atencionAlPublico;
	private Localidad localidadDeEntregas;
	Integer maximoDeMenusVigentes = 20;
	
	public void agregarMenu(Menu menu) throws MenuException {
		if(menus.size() >= getMaximoDeMenusVigentes()) {
			throw new MenuException("Llego a su limite de menues permitidos");
		}			
		menus.add(menu);		
	}
	
	public Integer getMaximoDeMenusVigentes() {
		return maximoDeMenusVigentes;
	}

	public void eliminarMenu(Menu menu) {
		menus.remove(menu);	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenues(List<Menu> menues) {
		this.menus = menues;
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

	public void setMaximoDeMenusVigentes(Integer maximoDeMenusVigentes) {
		this.maximoDeMenusVigentes = maximoDeMenusVigentes;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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
