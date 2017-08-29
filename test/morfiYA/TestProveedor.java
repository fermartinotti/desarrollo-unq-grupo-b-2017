package morfiYA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import morfiYA.domain.Proveedor;
import morfiYA.exceptions.DatoInvalidoException;

public class TestProveedor {
	@Test 
	public void testRetirarCredito(){
		Proveedor proveedor= new Proveedor();
		proveedor.setCreditos(100);
		try {
				proveedor.retirarCreditos(20);
		} catch (DatoInvalidoException e) {}
		assertEquals(80, proveedor.getCreditos(), 0);
	}
}
