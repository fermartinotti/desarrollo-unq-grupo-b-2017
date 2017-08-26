package morfiYA.domain;

import java.util.Date;
import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;

public class Menu {
	
	String nombre;
	String descripcion; 
	Categoria categoria;
	Float valorDelivery;
	List<Opinion> opiniones;
	boolean estaVigente; // No se si es necesario
	Date fechaVigenciaDesde;
	Date fechaVigenciaHasta;
	Float precio;
	Integer cantidadMinima;
	Integer cantidadMinima2;
	Integer cantidadMaxVtasPorDia;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Float getValorDelivery() {
		return valorDelivery;
	}

	public void setValorDelivery(Float precio)throws DatoInvalidoException {
		if (precio < 10) {
			throw new DatoInvalidoException("El precio debe ser mayor a $10");
		}
		if (precio > 40) {
			throw new DatoInvalidoException("El precio no puede ser mayor a $40");
		}
		valorDelivery = precio;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) throws DatoInvalidoException {
		if (nombre.length() <4) {
			throw new DatoInvalidoException("Nombre demasiado corto");
		}
		if (nombre.length() > 30) {
			throw new DatoInvalidoException("Nombre demasiado largo");
		}
		this.nombre = nombre;
	} 
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) throws DatoInvalidoException{
		if (descripcion.length() < 20) {
			throw new DatoInvalidoException("Descripcion demasiado corta");
		}
		if (descripcion.length() > 40) {
			throw new DatoInvalidoException("Descripcion demasiado larga");
		}
		this.descripcion = descripcion;
	}

	
}
