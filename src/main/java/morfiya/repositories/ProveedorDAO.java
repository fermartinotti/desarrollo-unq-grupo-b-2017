package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import morfiya.domain.Proveedor;

public class ProveedorDAO extends HibernateGenericDAO<Proveedor> implements GenericRepository<Proveedor>{

	private static final long serialVersionUID = 2274059891644843280L;


	@Override
	protected Class<Proveedor> getDomainClass() {
		return Proveedor.class;
	}
	
	@Override
	public List<Proveedor> findAll() {
		List<Proveedor> list = (List<Proveedor>) getHibernateTemplate().execute(new HibernateCallback<List<Proveedor>>(){

			@SuppressWarnings("unchecked")
			public List<Proveedor> doInHibernate(Session session) throws HibernateException {
				return (List<Proveedor>) session.createCriteria(Proveedor.class).list();
			}			
	});
		return list;
	}
	
	@Override
	public Proveedor findById(Serializable id){
		DetachedCriteria criteria = DetachedCriteria.forClass(Proveedor.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Proveedor) (this.getHibernateTemplate().findByCriteria(criteria).get(0));
	}
	
	@Override
	public void save(Proveedor proveedor) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(proveedor);
		getHibernateTemplate().flush();
	}

	@Override
	public Proveedor findBySubstring(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

