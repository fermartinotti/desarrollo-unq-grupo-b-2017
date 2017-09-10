package morfiYA;

import static org.junit.Assert.*;
import org.junit.Test;

import morfiYA.domain.Habilitacion;
import morfiYA.domain.Menu;
import morfiYA.exceptions.DatoInvalidoException;

public class TestMenu {

	@Test
	public void testSetCantidadMinima() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima(25);
		} catch (DatoInvalidoException e) {}
		assertEquals(25, (int) menu.getCantidadMinima());
	}

	@Test
	public void testSetCantidadMinima2() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima2(45);
		} catch (DatoInvalidoException e) {}
		assertEquals(45, (int) menu.getCantidadMinima2());
	}
	
	@Test 
	public void testSetValorDelivery(){
		Menu menu = new Menu();
		try {
			menu.setValorDelivery(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(20, menu.getValorDelivery(), 0);
	}
	
	@Test
	public void testSetPrecio() {
		Menu menu = new Menu();
		try {
			menu.setPrecio(15);
		} catch (DatoInvalidoException e) {}
			assertEquals(15, menu.getPrecio(), 0);
	}
	
	@Test
	public void testCantidadMinima() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima(15);
		} catch (DatoInvalidoException e) {}
			assertEquals(15, menu.getCantidadMinima(), 0);
	}
	
	@Test
	public void testCantidadMinima2() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima2(100);
		} catch (DatoInvalidoException e) {}
			assertEquals(100, menu.getCantidadMinima2(), 0);
	}

	@Test 
	public void testSetNombre(){
		Menu menu = new Menu();
		try {
			menu.setNombre("0 descensos");
		} catch (DatoInvalidoException e) {}
		assertEquals(11, menu.getNombre().length());
	}
	
	@Test
	public void testSetDescripcion(){
		Menu menu = new Menu();
		try {
			menu.setDescripcion("123456789123456789111111");
		} catch (DatoInvalidoException e) {}
		assertEquals(24, menu.getDescripcion().length());
	}
	
	@Test 
	public void testInhabilitarMenu() {
		Menu menu = new Menu();
		menu.inhabilitarMenu();
		assertEquals(Habilitacion.INHABILITADO, menu.getEstado());
	}
	
	@Test
	public void testPuedeVender() {
		Menu menu = new Menu();
		menu.setCantidadVendidos(15);
		menu.setCantidadMaxVtasPorDia(20);
		assertEquals(true, menu.puedeVender());
	}
}