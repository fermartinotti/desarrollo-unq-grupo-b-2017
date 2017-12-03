package morfiya.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Cliente;

public final class ClienteDAO extends HibernateGenericDAO<Cliente> {

	private static final long serialVersionUID = -8437497503411362604L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}

	// CON paginacion
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllByPage(final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Cliente>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Cliente");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}
	
	public Cliente findByEmail(String email){
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		criteria.add(Restrictions.eq("email", email));

		return (Cliente) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}

	@Override
	public Cliente save(Cliente cliente) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(cliente);
		getHibernateTemplate().flush();
		return cliente;
	}

	@Override
	public void deleteById(final Serializable id) {
		this.getHibernateTemplate().execute(new HibernateCallback<Cliente>() {

			public Cliente doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Cliente.class);
				criteria.add(Restrictions.eq("id", id));
				Cliente cliente = (Cliente) criteria.uniqueResult();
				session.delete(cliente);
				session.flush();
				return null;
			}
		});

	}

	public List<Menu> findByName(Serializable nombre, Integer pageSize, Integer pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
