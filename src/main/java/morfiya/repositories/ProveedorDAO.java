package morfiya.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Proveedor;

public final class ProveedorDAO extends HibernateGenericDAO<Proveedor>{

	private static final long serialVersionUID = 2274059891644843280L;

	@Override
	protected Class<Proveedor> getDomainClass() {
		return Proveedor.class;
	}

	// CON paginacion
	@SuppressWarnings("unchecked")
	public List<Proveedor> getAllByPage(final Integer pageSize, final Integer pageNumber) {
		HibernateTemplate template = getHibernateTemplate();
		return (List<Proveedor>) template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Proveedor");
				query.setMaxResults(pageSize);
				query.setFirstResult(pageSize * (pageNumber - 1));
				return query.list();
			}
		});
	}

	public Proveedor findByEmail(String email){
		DetachedCriteria criteria = DetachedCriteria.forClass(Proveedor.class);
		criteria.add(Restrictions.eq("email", email));

		return (Proveedor) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}
}
