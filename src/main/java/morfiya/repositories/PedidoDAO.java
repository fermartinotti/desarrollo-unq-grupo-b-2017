package morfiya.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;
import morfiya.domain.Pedido;

public class PedidoDAO extends HibernateGenericDAO<Pedido> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Pedido> getDomainClass() {
		return Pedido.class;
	}

	// @SuppressWarnings("unchecked")
	// public List<Pedido> getCantDePedidosPorMenu(final Menu menu) {
	// HibernateTemplate template = getHibernateTemplate();
	// DetachedCriteria criteria = DetachedCriteria.forClass(Pedido.class);
	// criteria.add(Restrictions.eq("menu", menu));
	//
	// return (List<Pedido>)
	// (this.getHibernateTemplate().findByCriteria(criteria));
	//
	// }

	// Con paginacion
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getAllByPage(final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Pedido>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Pedido");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	// @SuppressWarnings("unchecked")
	// public List<Pedido> findMenu(Menu menu) {
	// HibernateTemplate template = getHibernateTemplate();
	// return (List<Pedido>) template.execute(new HibernateCallback<Object>() {
	//
	// public Object doInHibernate(Session session) throws HibernateException {
	// Criteria cr = session.createCriteria(Pedido.class, "pedido");
	// cr.createAlias("pedido.menu", "menu");
	// cr.add(Restrictions.eq("menu.nombre", menu.getNombre()));
	// return cr.list();
	// }
	// });
	// }

	@SuppressWarnings("unchecked")
	public List<Pedido> findMenu(Menu menu) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Pedido>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Pedido where menu.nombre = " + menu.getNombre() + ")");
				return query.list();
			}
		});
	}

	public Pedido findByDescripcion(String descripcion) {
		HibernateTemplate template = getHibernateTemplate();
		return (Pedido) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {

				Criteria c = session.createCriteria(Pedido.class, "pedido");
				c.add(Restrictions.eq("pedido.descripcion", descripcion));

				return (Pedido) c.uniqueResult();

			}
		});

	}

}
