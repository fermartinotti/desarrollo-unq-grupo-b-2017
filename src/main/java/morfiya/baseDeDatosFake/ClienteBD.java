package morfiya.baseDeDatosFake;

import java.util.ArrayList;
import java.util.List;

import morfiya.domain.Cliente;
import morfiya.domain.Direccion;
import morfiya.domain.Localidad;
import morfiya.domain.LocalizacionMapa;
import morfiya.domain.Telefono;

public class ClienteBD {
	Telefono telefono1 = new Telefono("011", "42503698");
	LocalizacionMapa localizacionMapa1 = new LocalizacionMapa(1212,34343);
	Direccion direccion = new Direccion(Localidad.ALMIRANTE_BROWN, " Segurola y la Habana", 4310, localizacionMapa1);
	Cliente cliente1 = new Cliente(11111, "Diego", "Maradona", "d10s@gmaill.com", telefono1, direccion);
	Cliente cliente2 = new Cliente(11111, "Sebastian", "Battaglia", "sebas.5@gmaill.com", telefono1, direccion);
	Cliente cliente3 = new Cliente(11111, "Mauricio", "Cerna", "chicho.5@gmaill.com", telefono1, direccion);
	Cliente cliente4 = new Cliente(11111, "Jorge", "Bermudez", "patron.2@gmaill.com", telefono1, direccion);
	Cliente cliente5 = new Cliente(11111, "Oscar", "Cordoba", "oscar.1@gmaill.com", telefono1, direccion);
	Cliente cliente6 = new Cliente(11111, "Martin", "Palermo", "loco.9@gmaill.com", telefono1, direccion);
	Cliente cliente7 = new Cliente(11111, "Marcelo", "Delgado", "el.chelo.16@gmaill.com", telefono1, direccion);
	Cliente cliente8 = new Cliente(11111, "Carlos", "Bianchi", "virrey@gmaill.com", telefono1, direccion);
	Cliente cliente9 = new Cliente(11111, "Alberto", "Marcico", "beto.10@gmaill.com", telefono1, direccion);
	Cliente cliente10 = new Cliente(11111, "Blas Armando", "Giunta", "huevo.huevo.huevo@gmaill.com", telefono1, direccion);

	
	public List<Cliente> getClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
		clientes.add(cliente7);
		clientes.add(cliente8);
		clientes.add(cliente9);
		clientes.add(cliente10);
		
		return clientes;
	}
}
