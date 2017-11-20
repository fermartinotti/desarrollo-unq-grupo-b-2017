//package morfiya.domain.builders;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//import morfiya.domain.Categoria;
//import morfiya.domain.Menu;
//
//public class MenuBuilder {
//	private String nombre;
//	private String descripcion; 
//	private Categoria categoria;
//	private double valorDelivery;
//	private LocalDate fechaVigenciaDesde;
//	private LocalDate fechaVigenciaHasta;
//	private ArrayList<String> turnos; // ESTO QUEDA ? 
//	private ArrayList<Date> horariosDeEntrega;
//	private ArrayList<Date> horariosDeEnvio;
//	Turnos entrega envio
//	private double precio;
//	private Integer cantidadMinima;
//	private Integer cantidadMinima2;
//	private double precioCantidadMinima;
//	private double precioCantidadMinima2;
//	private Integer cantidadMaxVtasPorDia;
//	
//	
//	public static MenuBuilder mkBuilder() {
//		return new MenuBuilder();
//	}
//	
//	public MenuBuilder oneReadyToBuyMenu() {
//		this.nombre = "Pizza a la piedra, la mejor pizza";
//		this.descripcion = "Esta es la mejor pizza del pais";
//		this.categoria = Categoria.Pizza;
//		this.valorDelivery = 0;
//		this.precio = 100;
//		this.precioCantidadMinima= 80;
//		this.precioCantidadMinima2= 60;
//		
//		this.cantidadMinima= 5;
//		this.cantidadMinima2= 10;
//	
//		this.cantidadMaxVtasPorDia= 50;
//		
//		return this;
//	}
//	
//	public Menu build() {
//		Menu menu = new Menu(this.nombre, this.descripcion, this.categoria,this.valorDelivery, this.precio, this.precioCantidadMinima,
//				this.precioCantidadMinima2, this.cantidadMinima,this.cantidadMinima2, this.cantidadMaxVtasPorDia);
//	return menu;
//	}
//	
//}
