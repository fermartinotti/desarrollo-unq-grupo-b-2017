package morfiYA.domain;

import java.util.Date;

import morfiYA.exceptions.DatoInvalidoException;

public class Menu {
	
	private String nombre;
	private String descripcion; 
	private Categoria categoria;
	private Float valorDelivery;
	private Date fechaVigenciaDesde;
	private Date fechaVigenciaHasta;
	//Turnos entrega envio
	private Integer tiempoDeEntrega;
	private Float precio;
	private Integer cantidadMinima;
	private Integer cantidadMinima2;
	private Float precioCantidadMinima;
	private Float precioCantidadMinima2;
	private Integer cantidadMaxVtasPorDia;
	private Integer cantidadVendidos;//Para validar si puedo seguir vendiendo.

	public Float getPrecioCantidadMinima() {
		return precioCantidadMinima;
	}

	public void setPrecioCantidadMinima(Float precioCantidadMinima)throws DatoInvalidoException {
		if (precioCantidadMinima <0) {
			throw new DatoInvalidoException("El precio no puede ser negativo");
		}
		if (precioCantidadMinima >1000) {
			throw new DatoInvalidoException("El precio maximo de venta es de 1000");
		}
		if (precioCantidadMinima > this.precio) {
			throw new DatoInvalidoException("El precio de cantidad minima 1 debe ser menor al precio general");
		}
		this.precioCantidadMinima = precioCantidadMinima;
	}

	public Float getPrecioCantidadMinima2() {
		return precioCantidadMinima2;
	}

	public void setPrecioCantidadMinima2(Float precioCantidadMinima2)throws DatoInvalidoException {
		if (precioCantidadMinima2 <0) {
			throw new DatoInvalidoException("El precio no puede ser negativo");
		}
		if (precioCantidadMinima2 >1000) {
			throw new DatoInvalidoException("El precio maximo de venta es de 1000");
		}
		if(precioCantidadMinima2 > this.precioCantidadMinima) {
			throw new DatoInvalidoException("El precio debe ser menor al precio de la cantidad minima 1");
		}
		this.precioCantidadMinima2 = precioCantidadMinima2;
	}

	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(Date fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(Date fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public Integer getTiempoDeEntrega() {
		return tiempoDeEntrega;
	}

	public void setTiempoDeEntrega(Integer tiempoDeEntrega) {
		this.tiempoDeEntrega = tiempoDeEntrega;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) throws DatoInvalidoException {
		if (cantidadMinima < 10) {
			throw new DatoInvalidoException("La cantidad tiene que ser mayor a 9");
		}
		if(cantidadMinima > 70) {
			throw new DatoInvalidoException("La cantidad maxima permitida es de 70");
		}
		this.cantidadMinima = cantidadMinima;
	}

	public Integer getCantidadMinima2() {
		return cantidadMinima2;
	}

	public void setCantidadMinima2(Integer cantidadMinima2)throws DatoInvalidoException {
		if (cantidadMinima2 < 40) {
			throw new DatoInvalidoException("La cantidad tiene que ser mayor a 39");
		}
		if(cantidadMinima2 > 150) {
			throw new DatoInvalidoException("La cantidad maxima permitida es de 150");
		}
		this.cantidadMinima2 = cantidadMinima2;
	}

	public Integer getCantidadMaxVtasPorDia() {
		return cantidadMaxVtasPorDia;
	}

	public void setCantidadMaxVtasPorDia(Integer cantidadMaxVtasPorDia) {
		this.cantidadMaxVtasPorDia = cantidadMaxVtasPorDia;
	}
	
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
