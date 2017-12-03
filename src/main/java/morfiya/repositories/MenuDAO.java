package morfiya.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;
import morfiya.domain.Servicio;

public final class MenuDAO extends HibernateGenericDAO<Menu> {

	private static final long serialVersionUID = 6287473767660304813L;

	// NO SE COMO INICIALIZARLO
	//ServicioDAO servicioDAO; 
	
	
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
	
	// Con paginacion
	@SuppressWarnings("unchecked")
	public List<Menu> findByLocalidad(final String localidad, final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				//Query query = session.createQuery(("FROM Menu m INNER JOIN m.mid s WHERE s.localidadDeEntregas like '%"+localidad.toString()+"%'"));
				Query query = session.createQuery(("FROM Servicio WHERE localidadDeEntregas like '%" + localidad + "%'"));
				
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				List<Servicio> serviciosFiltrados = query.list();
				List<Menu> menusFiltrados = new ArrayList<Menu>();
				
				for(Servicio s : serviciosFiltrados){
					menusFiltrados.addAll(s.getMenus());
				}
				
				return menusFiltrados;
			}
		});

	}

	@SuppressWarnings("unchecked")
	public List<Menu> findByNameAndCategory(final String nombre, final String categoria, final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {			
				Query query = session.createQuery(("FROM Menu WHERE nombre like '%" + nombre + "%' AND categoria like '%" + categoria +"%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findByNameAndLocality(final String nombre, final String localidad,final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {							
				List<Menu> menusNombres = findByName(nombre, pageSize, pageNumber);
			
				return findByLocalidad(localidad, pageSize, pageNumber).stream().filter(menusNombres::contains).collect(Collectors.toList());
			}
		});

	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findByCategoryAndLocality(final String categoria, final String localidad,final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {							
				List<Menu> menusCategoria = findByCategoria(categoria, pageSize, pageNumber);
			
				return findByLocalidad(localidad, pageSize, pageNumber).stream().filter(menusCategoria::contains).collect(Collectors.toList());
			}
		});

	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findByNameCategoryAndLocality(final String nombre, final String categoria, String localidad,final Integer pageSize,
			final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Menu>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {							
				Query query = session.createQuery(("FROM Menu WHERE nombre like '%" + nombre + "%' AND categoria like '%" + categoria +"%'"));
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return findByLocalidad(localidad, pageSize, pageNumber).stream().filter(query.list()::contains).collect(Collectors.toList());
			}
		});

	}
}
