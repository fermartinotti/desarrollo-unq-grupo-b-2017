package morfiYA.domain;

import java.util.Date;
import java.util.List;

public class Menu {
	
	List<Opinion> opiniones;
	boolean estaVigente; // No se si es necesario
	String nombre;
	String descripcion; 
	Categoria categoria;
	Date fechaVigenciaDesde;
	Date fechaVigenciaHasta;
	Float precio;
	Integer cantidadMinima;
	Integer cantidadMinima2;
	Integer cantidadMaxVtasPorDia; 
	
	public Integer precioCantidadMinima() {
		return 0; // Implementar
	}
	
	public Integer precioCantidadMinima2() {
		return 0; // Implementar
	}
	
	
}
