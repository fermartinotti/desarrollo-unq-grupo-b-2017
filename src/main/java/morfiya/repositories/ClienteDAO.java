package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Cliente;

final class ClienteDAO extends HibernateGenericDAO<Cliente> {

	private static final long serialVersionUID = -8437497503411362604L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}

	// Sin paginacion
	@Override
	public List<Cliente> findAll() {
		List<Cliente> list = (List<Cliente>) getHibernateTemplate().execute(new HibernateCallback<List<Cliente>>() {

			@SuppressWarnings("unchecked")
			public List<Cliente> doInHibernate(Session session) throws HibernateException {

				return (List<Cliente>) session.createCriteria(Cliente.class).list();
			}
		});

		return list;
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

	@Override
	public Cliente findById(Serializable id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cliente.class);
		criteria.add(Restrictions.eq("id", id));

		return (Cliente) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
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
}
