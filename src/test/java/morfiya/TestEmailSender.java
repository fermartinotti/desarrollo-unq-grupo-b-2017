package morfiya;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.format.datetime.joda.LocalDateParser;

import morfiya.domain.Cliente;
import morfiya.domain.Menu;
import morfiya.domain.Proveedor;
import morfiya.domain.Sistema;
import morfiya.domain.builders.MenuBuilder;


public class TestEmailSender{

	// REVISAR!!! 
	
//	@Test
//	public void testSendEmail() {
//		Cliente cliente= mock(Cliente.class);
//		Proveedor proveedor= mock(Proveedor.class);
//		Sistema sistema= new Sistema();
//
//        Menu menu = spy((new MenuBuilder())
//                .oneReadyToBuyMenu()
//                .build());
//        
//        when(cliente.getEmail()).thenReturn("fermartinotti@gmail.com");
//        
//        LocalDate entrega= LocalDate.now();
//        entrega.plusDays(6);
//        
//        
//        sistema.comprar(menu, 1, entrega, cliente, "comprando test", proveedor);
//        verify(cliente, times(1)).getEmail();
//	}

}
