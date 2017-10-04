package morfiya.repositories;

import java.sql.SQLException;
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
		return list;
	}
	
	public Cliente findByID(Integer id){
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Cliente) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}


}
