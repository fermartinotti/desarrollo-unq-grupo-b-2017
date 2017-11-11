package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;

final class MenuDAO extends HibernateGenericDAO<Menu> {

	private static final long serialVersionUID = 6287473767660304813L;

	@Override
	protected Class<Menu> getDomainClass() {
		return Menu.class;
	}

	@Override
	public List<Menu> findAll() {
		List<Menu> list = (List<Menu>) getHibernateTemplate().execute(new HibernateCallback<List<Menu>>() {

			@SuppressWarnings("unchecked")
			public List<Menu> doInHibernate(Session session) throws HibernateException {

				return (List<Menu>) session.createCriteria(Menu.class).list();
			}
		});

		return list;
	}

	@Override
	public Menu findById(Serializable id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
		criteria.add(Restrictions.eq("id", id));

		return (Menu) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}

	// Busca por substring
	@SuppressWarnings("unchecked")
	public List<Menu> findByName(final Serializable nombre, final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(("FROM Menu WHERE nombre like '%" + nombre + "%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	@Override
	public void save(Menu menu) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(menu);
		getHibernateTemplate().flush();
	}

	@Override
	public void deleteById(final Serializable id) {
		this.getHibernateTemplate().execute(new HibernateCallback<Menu>() {

			public Menu doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Menu.class);
				criteria.add(Restrictions.eq("id", id));
				Menu menu = (Menu) criteria.uniqueResult();
				session.delete(menu);
				session.flush();
				return null;
			}
		});

	}

	@SuppressWarnings("unchecked")
	public List<Menu> getAllByPage(final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Menu");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}
}
