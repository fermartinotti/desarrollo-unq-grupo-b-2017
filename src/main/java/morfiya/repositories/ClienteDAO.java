package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;

import morfiya.domain.Cliente;
import morfiya.domain.Menu;

public class ClienteDAO extends HibernateGenericDAO<Cliente> implements GenericRepository<Cliente> {

	private static final long serialVersionUID = -8437497503411362604L;

	@Override
	protected Class<Cliente> getDomainClass() {
		return Cliente.class;
	}

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

	@Override
	public Cliente findById(Serializable id) {
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

	@Override
	public void deleteById(Serializable id) {
		this.getHibernateTemplate().execute(new HibernateCallback<Cliente>() {

			@Override
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

	@Override
	public List<Menu> getAllAdminsWithPagination(int page, int recordePerPage) {
		// TODO Auto-generated method stub
		return null;
	}
}
