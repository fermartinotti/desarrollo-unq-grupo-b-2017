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

import morfiya.domain.Menu;
import morfiya.exceptions.MenuException;

public class MenuDAO extends HibernateGenericDAO<Menu> implements GenericRepository<Menu> {

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
	
	@Override
	public Menu findByName(Serializable id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
		criteria.add(Restrictions.eq("nombre", id));

		return (Menu) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}
	
	@Override
	public void save(Menu menu) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(menu);
		getHibernateTemplate().flush();
	}

	@Override
	public void deleteById(Serializable id) {
		this.getHibernateTemplate().execute(new HibernateCallback<Menu>() {

			@Override
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
	
//	
//	public Menu findMenuByName(String nombre) {
//		Session session = this.getSessionFactory().getCurrentSession();
//		String hql = "FROM Menu Menu WHERE Menu.nombre = :nombre ";
//		Query query = session.createQuery(hql);
//		query.setParameter("nombre", nombre);
//
//		return (Menu) (query.list().isEmpty() ? null : query.list().get(0));
//	}
}
