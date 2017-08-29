package morfiYA;

import static org.junit.Assert.*;

import org.junit.Test;

import morfiYA.domain.Menu;
import morfiYA.domain.Servicio;
import morfiYA.exceptions.MenuException;

public class TestMenuException {
	
	@Test
	public void testRetirarCreditosMayoresALosDisponibles(){
		Servicio servicio = new Servicio();
		Menu menu1 = new Menu();
		Menu menu2 = new Menu();
		Menu menu3 = new Menu();
		Menu menu4 = new Menu();
		Menu menu5 = new Menu();
		Menu menu6 = new Menu();
		Menu menu7 = new Menu();
		Menu menu8 = new Menu();
		Menu menu9 = new Menu();
		Menu menu10 = new Menu();
		Menu menu11 = new Menu();
		Menu menu12 = new Menu();
		Menu menu13 = new Menu();
		Menu menu14 = new Menu();
		Menu menu15 = new Menu();
		Menu menu16 = new Menu();
		Menu menu17 = new Menu();
		Menu menu18 = new Menu();
		Menu menu19 = new Menu();
		Menu menu20 = new Menu();
		Menu menu21 = new Menu();
		
		try{
			servicio.agregarMenu(menu1);
			servicio.agregarMenu(menu2);
			servicio.agregarMenu(menu3);
			servicio.agregarMenu(menu4);
			servicio.agregarMenu(menu5);
			servicio.agregarMenu(menu6);
			servicio.agregarMenu(menu7);
			servicio.agregarMenu(menu8);
			servicio.agregarMenu(menu9);
			servicio.agregarMenu(menu10);
			servicio.agregarMenu(menu11);
			servicio.agregarMenu(menu12);
			servicio.agregarMenu(menu13);
			servicio.agregarMenu(menu14);
			servicio.agregarMenu(menu15);
			servicio.agregarMenu(menu16);
			servicio.agregarMenu(menu17);
			servicio.agregarMenu(menu18);
			servicio.agregarMenu(menu19);
			servicio.agregarMenu(menu20);
			servicio.agregarMenu(menu21);
			
			fail("Se esperaba excepcion");
		} catch(MenuException e){}
	}

}
