package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;
import morfiya.domain.Proveedor;

public final class MenuDAO extends HibernateGenericDAO<Menu> {

	private static final long serialVersionUID = 6287473767660304813L;

	@Override
	protected Class<Menu> getDomainClass() {
		return Menu.class;
	}

	// Con paginacion
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

	// Busca por substring (con paginacion)
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
	
	// Busca por nombre exacto
	public Menu findMenuByName(final Serializable nombre) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
			criteria.add(Restrictions.eq("nombre", nombre));

			return (Menu) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}

	// Busca por substring (con paginacion)
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

	// Con paginacion
	@SuppressWarnings("unchecked")
	public List<Menu> findByLocalidad(final String localidad, final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session
						.createQuery("FROM Menu where mid in (SELECT id FROM Servicio WHERE localidadDeEntregas like '%"
								+ localidad + "%')");

				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));

				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByNameAndCategory(final String nombre, final String categoria, final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(
						("FROM Menu WHERE nombre like '%" + nombre + "%' AND categoria like '%" + categoria + "%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByNameAndLocality(final String nombre, final String localidad, final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session
						.createQuery("FROM Menu where mid in (SELECT id FROM Servicio WHERE localidadDeEntregas like '%"
								+ localidad + "%') AND nombre like '%" + nombre + "%'");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});

	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByCategoryAndLocality(final String categoria, final String localidad, final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session
						.createQuery("FROM Menu where mid in (SELECT id FROM Servicio WHERE localidadDeEntregas like '%"
								+ localidad + "%') AND categoria like '%" + categoria + "%'");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
				
			}
		});

	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByNameCategoryAndLocality(final String nombre, final String categoria, String localidad,
			final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(
						(" FROM Menu where mid in (SELECT id FROM Servicio WHERE localidadDeEntregas like '%"
								+ localidad + "%') AND nombre like '%" + nombre + "%' AND categoria like '%" + categoria + "%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});

	}
}
