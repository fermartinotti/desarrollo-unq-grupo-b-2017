package morfiYA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import morfiYA.domain.Cliente;
import morfiYA.exceptions.DatoInvalidoException;

public class TestCliente {
	@Test 
	public void testCargarCredito(){
		Cliente cliente= new Cliente();
		try {
			cliente.cargarCredito(10);;
		} catch (DatoInvalidoException e) {}
		assertEquals(10, cliente.getCreditos(), 0);
	}
}
