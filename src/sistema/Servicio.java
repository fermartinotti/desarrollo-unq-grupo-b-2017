package sistema;

import java.util.HashMap;
import java.util.List;

public class Servicio {
	
	String nombre;
	List<Menu> menues; 
	// LOGO ??  
	String localidad; // Quizas estaria bueno crear una clase que contenga la localidad, direccion y la ubicacion en el mapa
	String direccion;
	String descripcion;
	String web; // puede tener ambos (web y facebook) o solamente uno de los 2
	String facebook; 
	String email;
	Telefono telefono;
	HashMap<String, String> diasYHorariosAtencion;
	String localidadEntrega;

	
	public void agregarMenu(Menu menu) {
		// Agregar menu
	}
	
	public void eliminarMenu(Menu menu) {
		// Eliminar menu
	}
	
	public void actualizarMenu(Menu menu) {
		// Actualizar Menu
	}
}
