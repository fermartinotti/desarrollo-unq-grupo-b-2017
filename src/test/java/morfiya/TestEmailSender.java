package morfiya;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Test;

import morfiya.domain.Cliente;
import morfiya.domain.EmailSender;


public class TestEmailSender{
	private final static Logger log = Logger.getLogger(TestEmailSender.class);
	
	@Test
	public void testSendEmail() {
				
		Cliente cliente= mock(Cliente.class);
       
       when(cliente.getEmail()).thenReturn("fermartinotti@gmail.com");

		
		try {
			EmailSender.sendEmail(cliente, "descripcion");
		} catch (Exception e) {
			log.error("Error al enviar email. Erorr: " + e.getMessage());
		}
		
        verify(cliente, times(1)).getEmail();
        
       
	}

}
