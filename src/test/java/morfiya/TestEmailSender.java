package morfiya;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;
import org.springframework.format.datetime.joda.LocalDateParser;

import morfiya.domain.Cliente;
import morfiya.domain.EmailSender;
import morfiya.domain.Menu;
import morfiya.domain.Proveedor;
import morfiya.domain.Sistema;
import morfiya.domain.builders.MenuBuilder;


public class TestEmailSender{

	// ARREGLAR LOGGEO,  O FALLAR TEST.
	
	@Test
	public void testSendEmail() {
		
		EmailSender emailSender = new EmailSender();
		
		Cliente cliente= mock(Cliente.class);
       
       when(cliente.getEmail()).thenReturn("fermartinotti@gmail.com");

		
		try {
			emailSender.sendEmaill(cliente, "descripcion");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        verify(cliente, times(1)).getEmail();
        
       
	}

}
