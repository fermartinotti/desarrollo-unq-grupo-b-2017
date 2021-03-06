package morfiya.repositories;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for generic DAO
 * 
 * @param <T>
 */
public interface GenericRepository<T> {

	T save(T entity);

	void delete(T entity);

	void update(T entity);

	T findById(Serializable id);

	List<T> findAll();
	
	void deleteById(Serializable id);

	int count();

	List<T> findByExample(T exampleObject);
	
	public List<T> getAllByPage(final Integer pageSize, final Integer pageNumber);

}