package morfiya.domain;
import org.apache.log4j.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EmailSender {
	
	private final static Logger log = Logger.getLogger(EmailSender.class);
	
	public EmailSender(){ 
	}
	
//////////////////////////////
	public static com.mashape.unirest.http.JsonNode sendEmail(Cliente cliente, String descripcion) throws UnirestException {
	
	HttpResponse<com.mashape.unirest.http.JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org" + "/messages")
	    .basicAuth("api", "key-d367f7b5732a3ae710e6e6e823a4fafc")
	.queryString("from", "postmaster@sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org")
	.queryString("to", cliente.getEmail())
	.queryString("subject", "Gracias por comprar en MorfiYA")
	.queryString("text", descripcion)
	.asJson();
	
	log.debug("Se enviar email con exito con descripcion:" + descripcion);
	return request.getBody();
	}
///////////////////////////
	
//	public void sendEmaill(Cliente cliente, String descripcion) throws AddressException, MessagingException, UnknownHostException, IOException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException {
		
		
		
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("fermartinotti@gmail.com"));
//
//        InternetAddress[] addrs = InternetAddress.parse(cliente.getEmail(), false);
//        msg.setRecipients(Message.RecipientType.TO, addrs);
//
//        msg.setSubject("Confirmacion de compra - MorfiYA");
//        msg.setText("Gracias por su compra: " + descripcion);
//        msg.setSentDate(new Date());
//
//        SMTPTransport t =(SMTPTransport) session.getTransport("smtps");
//        t.connect("smtp.mailgun.com", "postmaster@sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org", "37bdb2b7ef9235a2b7b124da3a64a562");
//        t.sendMessage(msg, msg.getAllRecipients());
//
//        // ENVIAR RESPONOSE por API ?? 
//        log.info("Response: " + t.getLastServerResponse());
//        
//        t.close();
//	}
}
