package morfiya.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import morfiya.domain.Cliente;

public class ClienteDAO extends HibernateGenericDAO<Cliente> implements GenericRepository<Cliente>{

	private static final long serialVersionUID = -8437497503411362604L;
	
	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}
	
	@Override
	public List<Cliente> findAll() {
		List<Cliente> list = (List<Cliente>) getHibernateTemplate().execute(new HibernateCallback<List<Cliente>>(){

			@SuppressWarnings("unchecked")
			public List<Cliente> doInHibernate(Session session) throws HibernateException {
				return (List<Cliente>) session.createCriteria(Cliente.class).list();
			}			
	});
		Cliente cliente1 = new Cliente(11111, "Diego", "Maradona", "d10s@gmaill.com");
		list.add(cliente1);
		return list;
	}
	
	public Cliente findByID(Integer id){
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Cliente) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}
	
	
	public Cliente createCliente(Integer cuit, String nombre, String apellido, String email) {
		Cliente cliente = new Cliente(cuit, nombre, apellido, email);
		getHibernateTemplate().save(cliente);
		getHibernateTemplate().flush();
		return cliente;
	}
//
//	public List<Cliente> getAll(){
//		Telefono telefono1 = new Telefono("011", "42503698");
//		LocalizacionMapa localizacionMapa1 = new LocalizacionMapa(1212,34343);
//		Direccion direccion = new Direccion(Localidad.ALMIRANTE_BROWN, " Segurola y la Habana", 4310, localizacionMapa1);
//		Cliente cliente1 = new Cliente(11111, "Diego", "Maradona", "d10s@gmaill.com", telefono1, direccion);
//		Cliente cliente2 = new Cliente(11111, "Sebastian", "Battaglia", "sebas.5@gmaill.com", telefono1, direccion);
//		Cliente cliente3 = new Cliente(11111, "Mauricio", "Cerna", "chicho.5@gmaill.com", telefono1, direccion);
//		Cliente cliente4 = new Cliente(11111, "Jorge", "Bermudez", "patron.2@gmaill.com", telefono1, direccion);
//		Cliente cliente5 = new Cliente(11111, "Oscar", "Cordoba", "oscar.1@gmaill.com", telefono1, direccion);
//		Cliente cliente6 = new Cliente(11111, "Martin", "Palermo", "loco.9@gmaill.com", telefono1, direccion);
//		Cliente cliente7 = new Cliente(11111, "Marcelo", "Delgado", "el.chelo.16@gmaill.com", telefono1, direccion);
//		Cliente cliente8 = new Cliente(11111, "Carlos", "Bianchi", "virrey@gmaill.com", telefono1, direccion);
//		Cliente cliente9 = new Cliente(11111, "Alberto", "Marcico", "beto.10@gmaill.com", telefono1, direccion);
//		Cliente cliente10 = new Cliente(11111, "Blas Armando", "Giunta", "huevo.huevo.huevo@gmaill.com", telefono1, direccion);
//		
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(cliente3);
//		clientes.add(cliente4);
//		clientes.add(cliente5);
//		clientes.add(cliente6);
//		clientes.add(cliente7);
//		clientes.add(cliente8);
//		clientes.add(cliente9);
//		clientes.add(cliente10);
//		
//		return clientes;
//		
//	}
}
