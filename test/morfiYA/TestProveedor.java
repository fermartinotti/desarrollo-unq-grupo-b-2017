package morfiYA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import morfiYA.domain.Proveedor;
import morfiYA.exceptions.DatoInvalidoException;

public class TestProveedor {
	@Test 
	public void testRetirarCredito(){
		Proveedor proveedor= new Proveedor();
		
		try {
			proveedor.cargarCredito(100);	
			proveedor.retirarCreditos(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(80, proveedor.getCreditos(), 0);
	}
	
	@Test
	public void testCargarCredito() {
		Proveedor proveedor= new Proveedor();
		
		try {
				proveedor.cargarCredito(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(20, proveedor.getCreditos(), 0);
	}
	
	public void testRetirarCreditoNoDisponible(){
		Proveedor proveedor= new Proveedor();
		try {
			proveedor.cargarCreditoNoDisponible(100);	
			proveedor.retirarCreditosNoDisponibles(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(80, proveedor.getCreditos(), 0);
	}
	
	@Test
	public void testCargarCreditoNoDisponible() {
		Proveedor proveedor= new Proveedor();
		
		try {
				proveedor.cargarCreditoNoDisponible(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(20, proveedor.getCreditosNoDisponibles(), 0);
	}
}
