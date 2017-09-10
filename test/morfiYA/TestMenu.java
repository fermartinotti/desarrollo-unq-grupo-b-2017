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
	

}