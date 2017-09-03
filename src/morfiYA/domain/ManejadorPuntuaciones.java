package morfiYA.domain;

import java.util.ArrayList;
import java.util.List;

public class ManejadorPuntuaciones {
	
	List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();
	
	public void agregarPuntuacion(Puntuacion puntuacion) {
		puntuaciones.add(puntuacion);
	}
	
	public double puntajePromedioProveedor(Proveedor proveedor) {
		return puntuaciones.stream().filter(puntuacion-> puntuacion.estaFinalizado() && puntuacion.getProveedor().equals(proveedor))
				.mapToDouble(puntuacion -> puntuacion.getPuntuacion()).average().getAsDouble();
	}
	
	public boolean hayPuntuacionesPendientesCliente(Cliente cliente) {
		return puntuaciones.stream().filter(puntuacion -> puntuacion.estaPendiente() && puntuacion.getCliente().equals(cliente)).count() > 0;
		
	}
	
	// Es un re bardo
	public List<Proveedores> proveedoresConMasDe20PuntucionesYPromedioMenorA2(){
		return 
	}
}
