package morfiYA;

import static org.junit.Assert.fail;

import org.junit.Test;

import morfiYA.domain.Menu;
import morfiYA.exceptions.DatoInvalidoException;

public class TestDatoInvalidoException {
	

	// Lanza una excepcion si seteo el precio de la cantidad minima es menor a 0
	@Test
	public void testPrecioCantidadMinimaMenorACero() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(-1);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor a 1000
	@Test
	public void testPrecioCantidadMinimaMayorAMil() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(2000);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor al precio normal
	@Test
	public void testPrecioCantidadMinimaMayorAPrecioNormal() {

		Menu menu = new Menu();
		menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(950);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es menor a 0
	@Test
	public void testPrecioCantidadMinima2MenorACero() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima2(-1);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor a 1000
	@Test
	public void testPrecioCantidadMinima2MayorAMil() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima2(2000);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio normal
	@Test
	public void testPrecioCantidadMinimaMayor2APrecioNormal() {

		Menu menu = new Menu();
		menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima2(950);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio de la cantidad minima 1
	@Test
	public void testPrecioCantidadMinima2MayorAPrecioCantidadMinima() {

		Menu menu = new Menu();
		menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima(700);
			menu.setPrecioCantidadMinima2(800);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}


	// Lanza una excepcion si seteo la cantidad minima en menor de 7
	@Test
	public void testCantidadMinimaMenorASiete() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima(5);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo la cantidad minima en mas de 70
	@Test
	public void testCantidadMinimaMayorASetenta() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima(75);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}


	// Lanza una excepcion si seteo la cantidad minima en menos de 40
	@Test
	public void testCantidadMinima2MenorACuarenta() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima2(5);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo la cantidad minima en mas de 150
	@Test
	public void testCantidadMinima2MayorACientoCincuenta() {
		Menu menu = new Menu();
		try {
			menu.setCantidadMinima2(200);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	@Test
	public void testValorDelDeliveyMenorADiez(){
		Menu menu = new Menu();
		try{
			menu.setValorDelivery((float) 5);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testValorDelDeliveyMayorACuarenta(){
		Menu menu = new Menu();
		try{
			menu.setValorDelivery(45);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}

	@Test
	public void testNombreMenorACuatro(){
		Menu menu = new Menu();
		try{
			menu.setNombre("d");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testNombreMayorACuarenta(){
		Menu menu = new Menu();
		try{
			menu.setNombre("Esto va a re contra fallar aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	
		
}
