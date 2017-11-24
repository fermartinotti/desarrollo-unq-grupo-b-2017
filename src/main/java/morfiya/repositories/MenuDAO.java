package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;

public final class MenuDAO extends HibernateGenericDAO<Menu> {

	private static final long serialVersionUID = 6287473767660304813L;

	@Override
	protected Class<Menu> getDomainClass() {
		return Menu.class;
	}

	// Con paginación
	@SuppressWarnings("unchecked")
	@Override
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

	// Busca por substring (con paginación)
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

	// Busca por substring (con paginación)
	@SuppressWarnings("unchecked")
	public List<Menu> findByCategoria(final String categoria, final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(("FROM Menu WHERE categoria like '%" + categoria.toString() + "%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByNameAndCategory(final Serializable nombre, final String categoria, final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {			
				
				if(nombre== null && categoria !=null)
					//Query query = session.createQuery(("FROM Menu WHERE categoria like '%" + categoria.toString() + "%'"));
					return findByCategoria(categoria, pageSize, pageNumber);
				
				if(nombre!= null && categoria ==null)
					//Query query = session.createQuery(("FROM Menu WHERE nombre like '%" + nombre + "%'"));
					return findByName(nombre, pageSize, pageNumber);
				
				
				Query query = session.createQuery(("FROM Menu WHERE nombre like '%" + nombre + "%' AND categoria like '%" + categoria +"%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});

	}
}
