package morfiya;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import morfiya.domain.Cliente;
import morfiya.domain.Habilitacion;
import morfiya.exceptions.DatoInvalidoException;

public class TestCliente {
	@Test 
	public void testCargarCredito(){
		Cliente cliente= new Cliente();
		try {
			cliente.cargarCredito(10);
		} catch (DatoInvalidoException e) {}
		assertEquals(10, cliente.getCreditos(), 0);
	}
	
	@Test
	public void testRetirarCredito() {
		Cliente cliente= new Cliente();
		
		try {
			cliente.cargarCredito(10);
			cliente.retirarCreditos(5);
		} catch (DatoInvalidoException e) {}
		assertEquals(5, cliente.getCreditos(), 0);

	}
	
	@Test
	public void testHabilitarCliente() {
		Cliente cliente= new Cliente();
		cliente.deshabilitarCliente();
		cliente.habilitarCliente();
		assertEquals(Habilitacion.HABILITADO, cliente.getEstado());
	}
	
	@Test
	public void testDeshabilitarCliente() {
		Cliente cliente= new Cliente();
		cliente.deshabilitarCliente();
		assertEquals(Habilitacion.INHABILITADO, cliente.getEstado());
	}
	
	@Test
	public void testPuedeComprar() {
		Cliente cliente= new Cliente();
		cliente.deshabilitarCliente();
		assertEquals(false, cliente.puedeComprar());
	}
}
