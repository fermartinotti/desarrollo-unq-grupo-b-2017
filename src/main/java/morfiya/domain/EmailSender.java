package morfiya.domain;
import org.apache.log4j.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EmailSender {
	
	private final static Logger log = Logger.getLogger(EmailSender.class);
	
	public EmailSender(){ 
	}
	

	public static com.mashape.unirest.http.JsonNode sendEmail(Cliente cliente, String descripcion) throws UnirestException {
	
	HttpResponse<com.mashape.unirest.http.JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org" + "/messages")
	    .basicAuth("api", "key-d367f7b5732a3ae710e6e6e823a4fafc")
	.queryString("from", "postmaster@sandbox1c3b7ddcc6da457d87aa7e485e6feaf9.mailgun.org")
	.queryString("to", cliente.getEmail())
	.queryString("subject", "Gracias por comprar en MorfiYA")
	.queryString("text", descripcion)
	.asJson();
	
	log.debug("Se envia email con exito con descripcion:" + descripcion);
	return request.getBody();
	}

}
