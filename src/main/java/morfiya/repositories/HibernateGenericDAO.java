package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Generic hibernate DAO
 *
 * @param <T>
 */
public abstract class HibernateGenericDAO<T> extends HibernateDaoSupport implements GenericRepository<T>, Serializable {

	private static final long serialVersionUID = 5058950102420892922L;

	protected Class<T> persistentClass = this.getDomainClass();

	@SuppressWarnings("unchecked")
	public int count() {
		List<Long> list = (List<Long>) this.getHibernateTemplate()
				.find("select count(*) from " + this.persistentClass.getName() + " o");

		// this.getHibernateTemplate().execute(new HibernateCallback<Car>() {
		//
		// @Override
		// public Car doInHibernate(final Session session) throws
		// HibernateException, SQLException {
		// throw new UnsupportedOperationException();
		// }
		// });
		Long count = list.get(0);
		return count.intValue();

	}

	public void delete(final T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	public void deleteById(final Serializable id) {
		T obj = this.findById(id);
		this.getHibernateTemplate().delete(obj);
	}

	// Funciona para todos
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> find = (List<T>) this.getHibernateTemplate().find("from " + this.persistentClass.getName() + " o");
		return find;
	}

	public List<T> findByExample(final T exampleObject) {
		return this.getHibernateTemplate().findByExample(exampleObject);

	}
	
	// Funciona para todos
	public T findById(final Serializable id) {
		return this.getHibernateTemplate().get(this.persistentClass, id);
	}
	
	protected abstract Class<T> getDomainClass();

	// Funciona para todos
	public T save(final T entity) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().save(entity);
		getHibernateTemplate().flush();
		
		return entity;
	}
	
	// Funciona para todos
	public void update(final T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	public void saveOrUpdate(final T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

}