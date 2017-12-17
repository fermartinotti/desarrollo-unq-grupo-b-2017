package morfiya.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import morfiya.domain.Cliente;
import morfiya.domain.Proveedor;
import morfiya.domain.auth.AuthProfile;
import morfiya.repositories.ClienteDAO;
import morfiya.repositories.ProveedorDAO;

public class AuthService {
			
	private ClienteDAO clienteRepository;
	
	private ProveedorDAO proveedorRepository;

	@Transactional
	public AuthProfile getAuthProfile() {
		AuthProfile authProfile = getProfile();	
		return authProfile;
	}

	@Transactional
	public Proveedor getProveedor() {
		AuthProfile authProfile = getProfile();		
		Proveedor proveedor = proveedorRepository.findByEmail(authProfile.getEmail());
		
		return proveedor;
	}
	
	@Transactional
	public Cliente getCliente() {				
		AuthProfile authProfile = getProfile();				
		Cliente cliente = clienteRepository.findByEmail(authProfile.getEmail());
//		if(cliente == null) {
//			cliente = new Cliente(authProfile.getName(),authProfile.getEmail());
//		}
		return cliente;
	}
	
	@Transactional
	private AuthProfile getProfile() {
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	    HttpServletRequest request = sra.getRequest();
		//Cliente cliente = 
		String header = request.getHeader("Authorization");
		if(header == null) {
			throw new RuntimeException("autorization header expected");
		}
		String url = "https://morfiyagrupob.auth0.com/userinfo";
		
		URL obj = null;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			
			if(responseCode != 200) {
				System.out.println("se produjo un error al intentar obtener el profile auth0");				
			}

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			String responseBody = response.toString();
			System.out.println(responseBody);
			Gson gson = new Gson();
			AuthProfile authProfile = gson.fromJson(responseBody, AuthProfile.class);	
			return authProfile;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public ClienteDAO getClienteRepository() {
		return clienteRepository;
	}

	@Transactional
	public void setClienteRepository(ClienteDAO clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public ProveedorDAO getProveedorRepository() {
		return proveedorRepository;
	}

	@Transactional
	public void setProveedorRepository(ProveedorDAO proveedorRepository) {
		this.proveedorRepository = proveedorRepository;
	}

	
}
