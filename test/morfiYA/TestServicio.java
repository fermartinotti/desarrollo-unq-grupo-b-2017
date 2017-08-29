package morfiYA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import morfiYA.domain.Menu;
import morfiYA.domain.Servicio;
import morfiYA.exceptions.DatoInvalidoException;
import morfiYA.exceptions.MenuException;

public class TestServicio {
	@Test 
	public void testAgregarMenu(){
		Servicio servicio= new Servicio();
		Menu menu = new Menu();;
		try {
			servicio.agregarMenu(menu);
		} catch (MenuException e) {}
		assertEquals(1,servicio.getMenus().size());
	}
	
	@Test 
	public void testEliminarMenu(){
		Servicio servicio= new Servicio();
		Menu menu = new Menu();;
		try {
			servicio.agregarMenu(menu);
			servicio.eliminarMenu(menu);
		} catch (MenuException e) {}
		assertEquals(0,servicio.getMenus().size());
	}
	
	@Test
	public void testSetDescripcion(){
		Servicio servicio = new Servicio();
		try{
			servicio.setDescripcion("123456789123456789123456789123456789");
		} catch(DatoInvalidoException e){}
		assertEquals(36,servicio.getDescripcion().length());
		
	}

}
