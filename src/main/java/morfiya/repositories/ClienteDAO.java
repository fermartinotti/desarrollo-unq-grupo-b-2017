package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.hibernate.FlushMode;


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
				
				List<Cliente> ret = (List<Cliente>) session.createCriteria(Cliente.class).list();
//				Cliente cliente1 = new Cliente(11111, "Diego", "Maradona", "d10s@gmaill.com");
//				ret.add(cliente1);
								
				return ret;
			}			
	});
		//Cliente cliente1 = new Cliente(11111, "Diego", "Maradona", "d10s@gmaill.com");
		//list.add(cliente1);
		return list;
	}
	
	@Override
	public Cliente findById(Serializable id){
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Cliente) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}
	
	@Override
	public void save(Cliente cliente) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(cliente);
		getHibernateTemplate().flush();
	}
}
