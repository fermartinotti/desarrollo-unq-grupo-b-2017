package morfiya.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Menu;
import morfiya.repositories.MenuDAO;

public class MenuService extends GenericService<Menu> {

	private static final long serialVersionUID = -7961010215734577876L;

	@Transactional
	public List<Menu> getAll() {
		return getRepository().findAll();
	}

	@Transactional
	public void crearMenu(Menu menu) {
		getRepository().save(menu);
	}
	
	@Transactional
	public List<Menu> findMenuForCategory(String categoria,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByCategoria(categoria, pageSize, pageNumber);
	}
	
	@Transactional
	public List<Menu> findMenuForName(Serializable nombre,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByName(nombre, pageSize, pageNumber);
	}
	
	@Transactional
	public List<Menu> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	@Transactional
	public Menu findByID(Integer id){
		return getRepository().findById(id);
	}
	
	@Transactional
	public void editarMenu(Menu menu){
		getRepository().update(menu);
	}
	
}