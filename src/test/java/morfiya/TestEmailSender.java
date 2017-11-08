package morfiya;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import morfiya.domain.Cliente;
import morfiya.domain.EmailSender;


public class TestEmailSender{

	// ARREGLAR LOGGEO,  O FALLAR TEST.
	
	@Test
	public void testSendEmail() {
		
		EmailSender emailSender = new EmailSender();
		
		Cliente cliente= mock(Cliente.class);
       
       when(cliente.getEmail()).thenReturn("fermartinotti@gmail.com");

		
		try {
			EmailSender.sendEmail(cliente, "descripcion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        verify(cliente, times(1)).getEmail();
        
       
	}

}
