package sistema;

import java.util.Date;

public class Menu {
	
	boolean estaVigente; // No se si es necesario
	String nombre;
	String descripcion; 
	Categoria categoria;
	
	Date fechaVigenciaDesde;
	Date fechaVigenciaHasta;
	// tipoDeEntrega: TipoDeEntrega
	Float tiempoPromedioEntrega;
	Float precio;
	
	Integer cantidadMinima;
	Integer cantidadMinima2;
	Integer cantidadMaxVtasPorDia; 
	
	
	
}
