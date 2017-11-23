//package morfiya.domain.builders;
//
//import java.time.LocalDate;
//
//import morfiya.domain.Categoria;
//import morfiya.domain.Menu;
//import morfiya.utils.DateFormatter;
//
//public class MenuBuilder {
//	private String nombre;
//	private String descripcion;
//	private Categoria categoria;
//	private Double valorDelivery;
//	private LocalDate fechaVigenciaDesde;
//	private LocalDate fechaVigenciaHasta;
//	private Double precio;
//	private Integer cantidadMinima;
//	private Integer cantidadMinima2;
//	private Double precioCantidadMinima;
//	private Double precioCantidadMinima2;
//	private Integer cantidadMaxVtasPorDia;
//
//	public static MenuBuilder mkBuilder() {
//		return new MenuBuilder();
//	}
//
//	public MenuBuilder withNombre(String nombre) {
//		this.nombre = nombre;
//		return this;
//	}
//
//	public MenuBuilder withDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//		return this;
//	}
//
//	public MenuBuilder withCategoria(Categoria categoria) {
//		this.categoria = categoria;
//		return this;
//	}
//
//	public MenuBuilder withValorDelivery(Double valor) {
//		this.valorDelivery = valor;
//		return this;
//	}
//
//	public MenuBuilder withFechaVigenciaDesdeYHasta(String desde, String hasta) {
//		this.fechaVigenciaDesde = DateFormatter.formatLocalDate(desde);
//		this.fechaVigenciaHasta = DateFormatter.formatLocalDate(hasta);
//		return this;
//	}
//
//	public MenuBuilder withPrecio(Double precio) {
//		this.precio = precio;
//		return this;
//	}
//
//	public MenuBuilder withCantidadMinima1y2(Integer cantidad1, Integer cantidad2) {
//		this.cantidadMinima = cantidad1;
//		this.cantidadMinima2 = cantidad2;
//		return this;
//	}
//
//	public MenuBuilder withPrecioCantidadMinima1y2(Double precio1, Double precio2) {
//		this.precioCantidadMinima = precio1;
//		this.precioCantidadMinima2 = precio2;
//		return this;
//	}
//
//	public MenuBuilder withCantidadMaxVtasPorDia(Integer cantidad) {
//		this.cantidadMaxVtasPorDia = cantidad;
//		return this;
//
//	}
//
//	public Menu build() {
//		Menu menu = new Menu(this.nombre, this.descripcion, this.categoria, this.valorDelivery, this.fechaVigenciaDesde,
//				this.fechaVigenciaHasta, this.precio, this.cantidadMinima, this.cantidadMinima2,
//				this.precioCantidadMinima, this.precioCantidadMinima2,
//				this.cantidadMaxVtasPorDia)
//				
//		return menu;
//	}
//
//}
