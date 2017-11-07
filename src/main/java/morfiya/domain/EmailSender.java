package morfiya.domain;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.sun.mail.smtp.SMTPTransport;




public class EmailSender {
	
	
	Properties props = System.getProperties();
	Session session = Session.getInstance(props, null);
	private final static Logger log = Logger.getLogger(EmailSender.class);
	
	public EmailSender(){
		props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");
        
	}
	
	public void sendEmaill(Cliente cliente, String descripcion) throws AddressException, MessagingException, UnknownHostException, IOException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException {
		
		//////////////////////////////
		
		///////////////////////////
		
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("fermartinotti@gmail.com"));

        InternetAddress[] addrs = InternetAddress.parse(cliente.getEmail(), false);
        msg.setRecipients(Message.RecipientType.TO, addrs);

        msg.setSubject("Confirmacion de compra - MorfiYA");
        msg.setText("Gracias por su compra: " + descripcion);
        msg.setSentDate(new Date());

        SMTPTransport t =(SMTPTransport) session.getTransport("smtps");
        t.connect("smtp.mailgun.com", "postmaster@sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org", "37bdb2b7ef9235a2b7b124da3a64a562");
        t.sendMessage(msg, msg.getAllRecipients());

        // ENVIAR RESPONOSE por API ?? 
        log.info("Response: " + t.getLastServerResponse());
        
        t.close();
	}
}
