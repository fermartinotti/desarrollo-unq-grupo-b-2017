package morfiya.domain.builders;

import java.util.ArrayList;
import java.util.List;

import morfiya.domain.Direccion;
import morfiya.domain.Localidad;
import morfiya.domain.Menu;
import morfiya.domain.Servicio;
import morfiya.domain.Telefono;

public class ServicioBuilder {
	
	String nombre;
	List<Menu> menus = new ArrayList<Menu>();
	Direccion direccion;
	String descripcion;
	String link;
	String email;
	Telefono telefono;
	//DiasDeAtencion atencionAlPublico;
	Localidad localidadDeEntregas;
	
	public static ServicioBuilder mkBuilder() {
		return new ServicioBuilder();
	}
	
	public ServicioBuilder withNombre(String nombre) {
		this.nombre= nombre;
		return this;
	}
	
	public ServicioBuilder withAgregarMenus(Menu menu) {
		this.menus.add(menu);
		return this;
	}
	
	public ServicioBuilder withDireccion(Direccion direccion){
        this.direccion=direccion;
        return this;
    }
	
	public ServicioBuilder withDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public ServicioBuilder withLink(String link) {
		this.link=link;
		return this;
	}
	
	public ServicioBuilder withEmail(String email) {
		this.email= email;
		return this;
	}
	
	public ServicioBuilder withTelefono(String codArea, String numero){
        this.telefono= new Telefono(codArea, numero);
        return this;
    }
	
	public ServicioBuilder withLocalidad(Localidad localidad){
        this.localidadDeEntregas = localidad;
        return this;
    }
	
	public Servicio build(){
		Servicio servicio = new Servicio(this.nombre, this.menus, this.direccion, this.descripcion, this.link,
				this.email, this.telefono, this.localidadDeEntregas);
		
		return servicio;
	}

}
