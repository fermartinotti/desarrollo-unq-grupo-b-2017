package morfiya.adapters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import morfiya.domain.Categoria;
import morfiya.domain.Entity;
import morfiya.domain.Habilitacion;
import morfiya.exceptions.DatoInvalidoException;
import morfiya.utils.DateFormatter;

public class MenuUpdate extends Entity  {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	private Double valorDelivery;
	private LocalDate fechaVigenciaDesde;
	private LocalDate fechaVigenciaHasta;
	private ArrayList<String> turnos; // ESTO QUEDA ?
	private ArrayList<LocalTime> horariosDeEntrega;
	private ArrayList<LocalTime> horariosDeEnvio;
	// Turnos entrega envio
	private Double precio;
	private Integer cantidadMinima;
	private Integer cantidadMinima2;
	private Double precioCantidadMinima;
	private Double precioCantidadMinima2;
	private Integer cantidadMaxVtasPorDia;
	private Integer cantidadVendidos = 0;// ESO SE VA Y SE CALCULA ON THE FLY.
	private Habilitacion estaParaLaVenta = Habilitacion.HABILITADO;
	private Integer id;

	public MenuUpdate() {
		super();
	}


	public MenuUpdate(String nombre, String descripcion, Categoria categoria, Double valorDelivery, String fechaVigenciaDesde,
			String fechaVigenciaHasta , ArrayList<String> turnos, ArrayList<String> horariosDeEntrega, ArrayList<String> horariosDeEnvio,
			Double precio, Integer cantidadMinima, Integer cantidadMinima2, Double precioCantidadMinima, Double precioCantidadMinima2,
			Integer cantidadMaxVtasPorDia, Integer id) throws DatoInvalidoException {
		
		
		
		if(nombre != null)
			this.setNombre(nombre);
		
		if(descripcion != null)	
			this.setDescripcion(descripcion);
		
		if(categoria != null)	
			this.setCategoria(categoria);
		
		if(valorDelivery != null)
			this.setValorDelivery(valorDelivery);
		
		if(fechaVigenciaDesde != null)
			this.setFechaVigenciaDesde(DateFormatter.formatLocalDate(fechaVigenciaDesde));
		
		if(fechaVigenciaHasta != null)
			this.setFechaVigenciaHasta(DateFormatter.formatLocalDate(fechaVigenciaHasta));
			
		if(turnos != null)
			this.setTurnos(turnos);
			
		if(horariosDeEntrega != null)
			this.setHorariosDeEntrega(DateFormatter.formatLocalTime(horariosDeEntrega));
			
		
		if(horariosDeEnvio != null)
			this.setHorariosDeEnvio(DateFormatter.formatLocalTime(horariosDeEnvio));
			
		
		if(precio != null)
			this.setPrecio(precio);
			
		
		if(cantidadMinima != null)
			this.setCantidadMinima(cantidadMinima);
			
		if(cantidadMinima2 != null)
			this.setCantidadMinima2(cantidadMinima2);
					
		
		if(precioCantidadMinima != null)
			this.setPrecioCantidadMinima(precioCantidadMinima);
							

		if(precioCantidadMinima2 != null)
			this.setPrecioCantidadMinima2(precioCantidadMinima2);
									
		if(cantidadMaxVtasPorDia != null)
			this.setCantidadMaxVtasPorDia(cantidadMaxVtasPorDia);
		
		if(id != null)
			this.setId(id);
	}

	public Double getPrecioCantidadMinima() {
		return precioCantidadMinima;
	}

	public void setPrecioCantidadMinima(Double precioCantidadMinima) throws DatoInvalidoException {
		if (precioCantidadMinima < 0) {
			throw new DatoInvalidoException("El precio de la cantidad minima no puede ser negativo");
		}
		if (precioCantidadMinima > 1000) {
			throw new DatoInvalidoException("El precio maximo de venta de la cantidad minima es de 1000");
		}
		if (precioCantidadMinima > this.precio) {
			throw new DatoInvalidoException("El precio de cantidad minima 1 debe ser menor al precio general");
		}
		this.precioCantidadMinima = precioCantidadMinima;
	}

	public Double getPrecioCantidadMinima2() {
		return precioCantidadMinima2;
	}

	public void setPrecioCantidadMinima2(Double precioCantidadMinima2) throws DatoInvalidoException {
		if (precioCantidadMinima2 < 0) {
			throw new DatoInvalidoException("El precio de la cantidad minima 2 no puede ser negativo");
		}
		if (precioCantidadMinima2 > 1000) {
			throw new DatoInvalidoException("El precio maximo de venta de la cantidad minima 2 es de 1000");
		}
		if (precioCantidadMinima2 > this.precio) {
			throw new DatoInvalidoException("El precio de cantidad minima 2 debe ser menor al precio general");
		}
		if (precioCantidadMinima2 > this.precioCantidadMinima) {
			throw new DatoInvalidoException(
					"El precio de la cantidad minimima 2 debe ser menor al precio de la cantidad minima 1");
		}
		this.precioCantidadMinima2 = precioCantidadMinima2;
	}

	public LocalDate getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(LocalDate fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public LocalDate getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(LocalDate fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) throws DatoInvalidoException {
		if (precio < 0) {
			throw new DatoInvalidoException("El precio no puede ser negativo");
		}
		this.precio = precio;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer cantidadMinima) throws DatoInvalidoException {
		if (cantidadMinima < 10) {
			throw new DatoInvalidoException("La cantidad minima tiene que ser mayor o igual a 10");
		}
		if (cantidadMinima > 70) {
			throw new DatoInvalidoException("La cantidad maxima permitida menor o igual a 70");
		}
		this.cantidadMinima = cantidadMinima;
	}

	public Integer getCantidadMinima2() {
		return cantidadMinima2;
	}

	public void setCantidadMinima2(Integer cantidadMinima2) throws DatoInvalidoException {
		if (cantidadMinima2 < 40) {
			throw new DatoInvalidoException("La cantidad minima 2 tiene que ser mayor a 39");
		}
		if (cantidadMinima2 > 150) {
			throw new DatoInvalidoException("La cantidad maxima 2 permitida es de 150");
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

	public Double getValorDelivery() {
		return valorDelivery;
	}

	public void setValorDelivery(Double precio) throws DatoInvalidoException {
		if (precio < 10) {
			throw new DatoInvalidoException("El precio del delivery debe ser mayor a $10");
		}
		if (precio > 40) {
			throw new DatoInvalidoException("El precio del delivery no puede ser mayor a $40");
		}
		valorDelivery = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws DatoInvalidoException {
		if (nombre.length() < 4) {
			throw new DatoInvalidoException("El nombre del menu es demasiado corto");
		}
		if (nombre.length() > 30) {
			throw new DatoInvalidoException("El nombre del menu es demasiado largo");
		}
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws DatoInvalidoException {
		if (descripcion.length() < 20) {
			throw new DatoInvalidoException("La descripcion del menu es demasiado corta");
		}
		if (descripcion.length() > 40) {
			throw new DatoInvalidoException("La descripcion del menu es demasiado larga");
		}
		this.descripcion = descripcion;
	}

	public ArrayList<LocalTime> getHorariosDeEnvio() {
		return horariosDeEnvio;
	}

	public void setHorariosDeEnvio(ArrayList<LocalTime> horariosDeEnvio) {
		this.horariosDeEnvio = horariosDeEnvio;
	}

	public ArrayList<LocalTime> getHorariosDeEntrega() {
		return horariosDeEntrega;
	}

	public void setHorariosDeEntrega(ArrayList<LocalTime> horariosDeEntrega) {
		this.horariosDeEntrega = horariosDeEntrega;
	}

	public ArrayList<String> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<String> turnos) {
		this.turnos = turnos;
	}

	public Habilitacion getEstado() {
		return estaParaLaVenta;
	}

	public boolean puedeVender() {
		return this.cantidadVendidos <= getCantidadMaxVtasPorDia();
	}

	public Integer getCantidadVendidos() {
		return cantidadVendidos;
	}

	public void setCantidadVendidos(Integer cantidadVendidos) {
		this.cantidadVendidos = cantidadVendidos;
	}

	public void inhabilitarMenu() {
		estaParaLaVenta = Habilitacion.INHABILITADO;

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

