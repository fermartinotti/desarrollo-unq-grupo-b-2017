package morfiya;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.URL;

import org.junit.Test;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.Sistema;
import morfiya.exceptions.DatoInvalidoException;

public class TestSistema {
	
	@Test
	public void testAgregarPedido() {
		Sistema sistema = new Sistema();
		Pedido pedido = new Pedido(null, null, null, null);
		
		sistema.agregarPedido(pedido);
		assertEquals(1, sistema.getPedidos().size());
	}

	@Test
	public void testServicesPkgShouldNotDependOnDommainPkg() {
		final JDepend jDepend = new JDepend();
		
		DependencyConstraint constraint = new DependencyConstraint();
		JavaPackage domain = constraint.addPackage("domain");
		JavaPackage services = constraint.addPackage("services");
		
		domain.dependsUpon(services);
		
		jDepend.analyze();
		assertFalse(jDepend.dependencyMatch(constraint));
	}
		
	
//	@Test
//	public void testComprar() {
//		Sistema sistema = new Sistema();
//		Cliente cliente = new Cliente();
//		Menu menu = new Menu();
//		menu.setCantidadMaxVtasPorDia(500);
//		Proveedor proveedor = new Proveedor();
//		
//		try {
//			menu.setPrecio(20);
//			cliente.cargarCredito(500);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente, "descripcion", proveedor);
//			
//		} catch (DatoInvalidoException e) {}
//			assertEquals(1,sistema.getPedidos().size());
//	}
	
//	@Test
//	public void testPuedeComprar() {
//		Sistema sistema = new Sistema();
//		Cliente cliente = new Cliente();
//		Menu menu = new Menu();
//		menu.setCantidadMaxVtasPorDia(500);
//		LocalDate fechaDeEntrega = LocalDate.of(2017, 10, 02);
//		
//		assertEquals(true, sistema.puedeComprar(menu, cliente, fechaDeEntrega));
//	}
	
//	@Test
//	public void testCantDeVentasNoSuperada() {
//		Sistema sistema = new Sistema();
//		Cliente cliente = new Cliente();
//		Menu menu = new Menu();
//		menu.setCantidadMaxVtasPorDia(1);
//		Proveedor proveedor = new Proveedor();
//		
//		try {
//			menu.setPrecio(20);
//			cliente.cargarCredito(500);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente, "descripcion", proveedor);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente, "descripcion", proveedor);
//			
//		} catch (DatoInvalidoException e) {}
//			assertEquals(false ,sistema.cantDeVentasNoSuperada(menu));
//		
//	}
	
//	@Test
//	public void testEsFechaValida() {
//		Sistema sistema = new Sistema();
//		assertEquals(true, sistema.esFechaValida(LocalDate.of(2017, 10, 02)));
//	}
	
	@Test
	public void testEvaluarDiferenciaDinero() {
		Sistema sistema = new Sistema();
		Menu menu = new Menu();

		try {
			menu.setCantidadMinima(20);
			menu.setCantidadMinima2(50);
			menu.setPrecio(30);
			menu.setPrecioCantidadMinima(10);
			menu.setPrecioCantidadMinima2(5);

			
		} catch (DatoInvalidoException e) {}
		assertEquals(20, sistema.evaluarDiferenciaDinero(menu, 30), 0);
	}
	
/*
	@Test
	public void testConfirmarCompras() {
		Sistema sistema = new Sistema();
		
	}
*/
//	@Test
//	public void testPuntajePromedioPedido() {
//		Sistema sistema = new Sistema();
//		Cliente cliente1 = new Cliente();
//		Cliente cliente2 = new Cliente();
//		Menu menu = new Menu();
//		menu.setCantidadMaxVtasPorDia(500);
//		
//		
//		try {
//			Proveedor proveedor = new Proveedor();
//			menu.setPrecio(20);
//			cliente1.cargarCredito(500);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente1, "descripcion", proveedor);
//			sistema.calificarMenu(cliente1, sistema.getPedidos().get(0), 4);
//			
//			menu.setPrecio(20);
//			cliente2.cargarCredito(500);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente2, "descripcion", proveedor);
//			sistema.calificarMenu(cliente2, sistema.getPedidos().get(0), 4);
//			
//		} catch (DatoInvalidoException e) {}
//			assertEquals(2, sistema.puntajePromedioPedido(sistema.getPedidos()), 0);
//		
//		
//	}
	
//	@Test
//	public void testCalificarMenu() {
//		Sistema sistema = new Sistema();
//		Cliente cliente = new Cliente();
//		Menu menu = new Menu();
//		menu.setCantidadMaxVtasPorDia(500);
//		Proveedor proveedor = new Proveedor();
//		
//		try {
//			menu.setPrecio(20);
//			cliente.cargarCredito(500);
//			sistema.comprar(menu, 1, LocalDate.of(2017, 10, 02), cliente, "descripcion", proveedor);
//			sistema.calificarMenu(cliente, sistema.getPedidos().get(0), 4);
//			
//		} catch (DatoInvalidoException e) {}
//			assertEquals(4, sistema.getPedidos().get(0).getPuntuacion(), 0);
//		
//	}
}
