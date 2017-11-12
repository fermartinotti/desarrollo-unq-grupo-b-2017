package morfiya.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;
import morfiya.domain.Servicio;

public class ServicioDAO extends HibernateGenericDAO<Servicio> {

	private static final long serialVersionUID = 4848525334882686123L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getAllByPage(final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Servicio>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Servicio");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	// Sin paginación
	@Override
	public List<Servicio> findAll() {
		List<Servicio> list = (List<Servicio>) getHibernateTemplate().execute(new HibernateCallback<List<Servicio>>() {

			@SuppressWarnings("unchecked")
			public List<Servicio> doInHibernate(Session session) throws HibernateException {

				return (List<Servicio>) session.createCriteria(Servicio.class).list();
			}
		});

		return list;
	}

	@Override
	protected Class<Servicio> getDomainClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Con paginación
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

}
