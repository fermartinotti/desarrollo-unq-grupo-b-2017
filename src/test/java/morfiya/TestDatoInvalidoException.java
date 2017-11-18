package morfiya;

import static org.junit.Assert.fail;

import java.util.Collections;

import org.junit.Test;

import morfiya.domain.Cliente;
import morfiya.domain.Menu;
import morfiya.domain.Proveedor;
import morfiya.domain.Servicio;
import morfiya.exceptions.DatoInvalidoException;

public class TestDatoInvalidoException {
	

	// Lanza una excepcion si seteo el precio de la cantidad minima es menor a 0
	@Test
	public void testPrecioCantidadMinimaMenorACero() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima((double) -1);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor a 1000
	@Test
	public void testPrecioCantidadMinimaMayorAMil() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima((double) 2000);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima es mayor al precio normal
	@Test
	public void testPrecioCantidadMinimaMayorAPrecioNormal() {

		Menu menu = new Menu();
		
		try {
			menu.setPrecio((double) 900);
			menu.setPrecioCantidadMinima((double) 950);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es menor a 0
	@Test
	public void testPrecioCantidadMinima2MenorACero() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima2((double) -1);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor a 1000
	@Test
	public void testPrecioCantidadMinima2MayorAMil() {

		Menu menu = new Menu();
		// menu.setPrecio(900);
		try {
			menu.setPrecioCantidadMinima2((double) 2000);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio normal
	@Test
	public void testPrecioCantidadMinimaMayor2APrecioNormal() {

		Menu menu = new Menu();
		
		try {
			menu.setPrecio((double) 900);
			menu.setPrecioCantidadMinima2((double) 950);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	// Lanza una excepcion si seteo el precio de la cantidad minima 2 es mayor al precio de la cantidad minima 1
	@Test
	public void testPrecioCantidadMinima2MayorAPrecioCantidadMinima() {

		Menu menu = new Menu();
		
		try {
			menu.setPrecio((double) 900);
			menu.setPrecioCantidadMinima((double) 700);
			menu.setPrecioCantidadMinima2((double) 800);
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
			menu.setCantidadMinima2(151);
			fail("Se esperaba excepcion");
		} catch (DatoInvalidoException e) {}
	}

	@Test
	public void testValorDelDeliveyMenorADiez(){
		Menu menu = new Menu();
		try{
			menu.setValorDelivery((double) 5);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testValorDelDeliveyMayorACuarenta(){
		Menu menu = new Menu();
		try{
			menu.setValorDelivery((double) 45);
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
	public void testNombreMayorATreinta(){
		Menu menu = new Menu();
		try{
			menu.setNombre("Esto va a re contra fallar aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testDescripcionMenorAVeinte(){
		Menu menu = new Menu();
		try{
			menu.setDescripcion("h");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testDescripcionMayorACuarenta(){
		Menu menu = new Menu();
		try{
			menu.setDescripcion("123456789123456789123456789123456789123456789");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testCargarCreditoNegativo(){
		Cliente cliente = new Cliente();
		try{
			cliente.cargarCredito(-1);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testCargaCreditoNegativo() {
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCredito(-10);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testCargaCreditoNegativoNoDisponible() {
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCreditoNoDisponible(-10);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testRetirarCreditosNegativos(){
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCredito(10);
			proveedor.retirarCreditos(-1);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testRetirarCreditosMayoresALosDisponibles(){
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCredito(10);
			proveedor.retirarCreditos(20);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testRetirarCreditosNegativosNoDisponibles(){
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCreditoNoDisponible(10);
			proveedor.retirarCreditosNoDisponibles(-1);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testRetirarCreditosNoDisponiblesMayoresALosDisponibles(){
		Proveedor proveedor = new Proveedor();
		
		try{
			proveedor.cargarCreditoNoDisponible(10);
			proveedor.retirarCreditosNoDisponibles(20);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testDescripcionLongitudMenorATreinta(){
		Servicio servicio = new Servicio();
		try{
			servicio.setDescripcion("d");
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	@Test
	public void testDescripcionLongitudMayorADoscientos(){
		Servicio servicio = new Servicio();
		try{
			String descripcion = String.join("", Collections.nCopies(201, "c"));
			servicio.setDescripcion(descripcion);
			fail("Se esperaba excepcion");
		} catch(DatoInvalidoException e){}
	}
	
	
}
		

