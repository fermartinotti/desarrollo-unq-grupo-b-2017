package morfiYA;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import morfiYA.domain.Menu;
import morfiYA.exceptions.DatoInvalidoException;

public class TestMenu {
	
	///////// *** TEST PRECIO CANTIDAD MINIMA 1 *** /////////
	
	// Lanza una excepcion si seteo el precio de la cantidad minima es menor o igual a 0
	@Test
	public void testSetPrecioCantidadMinima1() {

		Menu menu = new Menu();
		//menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(-1);
			fail("Se esperaba excepcion");
			} catch (DatoInvalidoException e) {}
	}
	
	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor o igual a 1000
	@Test
	public void testSetPrecioCantidadMinima2() {

		Menu menu = new Menu();
		//menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(2000);
			fail("Se esperaba excepcion");
			} catch (DatoInvalidoException e) {}
	}
	
	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor al precio normal
	@Test
	public void testSetPrecioCantidadMinima3() {

		Menu menu = new Menu();
		menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(950);
			fail("Se esperaba excepcion");
			} catch (DatoInvalidoException e) {}
	}
	
	///////// *** TEST PRECIO CANTIDAD MINIMA 2 *** /////////
	
	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es menor o igual a 0
		@Test
		public void testSetPrecioCantidadMinima2A() {

			Menu menu = new Menu();
			//menu.setPrecio(900);
			try {
				menu.setPrecioCantidadMinima2(-1);
				fail("Se esperaba excepcion");
				} catch (DatoInvalidoException e) {}
		}
		
		// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor o igual a 1000
		@Test
		public void testSetPrecioCantidadMinima2B() {

			Menu menu = new Menu();
			//menu.setPrecio(900);
			try {
				menu.setPrecioCantidadMinima2(2000);
				fail("Se esperaba excepcion");
				} catch (DatoInvalidoException e) {}
		}
		
		// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio normal
		@Test
		public void testSetPrecioCantidadMinima2C() {

			Menu menu = new Menu();
			menu.setPrecio(900);
			try {
				menu.setPrecioCantidadMinima2(950);
				fail("Se esperaba excepcion");
				} catch (DatoInvalidoException e) {}
		}
		
		// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio de la cantidad minima 1
				@Test
				public void testSetPrecioCantidadMinima2D() {

					Menu menu = new Menu();
					menu.setPrecio(900);
					try {
						menu.setPrecioCantidadMinima(700);
						menu.setPrecioCantidadMinima2(800);
						fail("Se esperaba excepcion");
						} catch (DatoInvalidoException e) {}
				}
				
		///////// *** TEST CANTIDAD MINIMA 1 *** /////////
			
				// Lanza una excepcion si seteo la cantidad minima en menos de 7
				@Test
				public void testSetCantidadMinima1() {
					Menu menu = new Menu();
					try {
						menu.setCantidadMinima(5);
						fail("Se esperaba excepcion");
						} catch (DatoInvalidoException e) {}
				}
				
				// Lanza una excepcion si seteo la cantidad minima en mas de 70
				@Test
				public void testSetCantidadMinima2() {
					Menu menu = new Menu();
					try {
						menu.setCantidadMinima(75);
						fail("Se esperaba excepcion");
						} catch (DatoInvalidoException e) {}
				}
				
				@Test
				public void testSetCantidadMinima() {
					Menu menu = new Menu();
					try {
						menu.setCantidadMinima(15);
						assertEquals(15, menu.getCantidadMinima());
						
						} catch (DatoInvalidoException e) {}
				}
				
		///////// *** TEST CANTIDAD MINIMA 2 *** /////////
				
					// Lanza una excepcion si seteo la cantidad minima en menos de 40
					@Test
					public void testSetCantidadMinima2A() {
						Menu menu = new Menu();
						try {
							menu.setCantidadMinima2(5);
							fail("Se esperaba excepcion");
							} catch (DatoInvalidoException e) {}
					}
					
					// Lanza una excepcion si seteo la cantidad minima en mas de 150
					@Test
					public void testSetCantidadMinima2B() {
						Menu menu = new Menu();
						try {
							menu.setCantidadMinima2(200);
							fail("Se esperaba excepcion");
							} catch (DatoInvalidoException e) {}
					}
					
					@Test
					public void testSetCantidadMinima2C() {
						Menu menu = new Menu();
						try {
							menu.setCantidadMinima2(60);
							assertEquals(60, menu.getCantidadMinima2());
							
							} catch (DatoInvalidoException e) {}
					}
	
	
}