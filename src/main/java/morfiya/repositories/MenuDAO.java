package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import morfiya.domain.Menu;
import morfiya.utils.HibernateUtil;

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
	public Menu findByName(Serializable nombre) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
		criteria.add(Restrictions.eq("nombre", nombre));

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

	public List<Menu> getAllAdminsWithPagination(int page, int recordePerPage) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			Criteria cr = session.createCriteria(Menu.class);
			cr.setFirstResult((page - 1) * recordePerPage);
			cr.setMaxResults(recordePerPage);
			List<Menu> adminAll = cr.list();
			tr.commit();

			if (adminAll.isEmpty()) {
				return null;
			} else {
				return adminAll;
			}
		} catch (RuntimeException ex) {

			if (tr != null) {
				tr.rollback(); // roll back the transaction due to runtime error
			}
			return null;
		}
	}
}
