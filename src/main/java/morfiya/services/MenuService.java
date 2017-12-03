package morfiya.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Menu;
import morfiya.repositories.MenuDAO;

@Transactional
public class MenuService extends GenericService<Menu> {

	private static final long serialVersionUID = -7961010215734577876L;

	public List<Menu> getAll() {
		return getRepository().findAll();
	}

	public Menu crearMenu(Menu menu) {
		return getRepository().save(menu);
	}

	public Menu getMenuById(int id) {
		return getRepository().findById(id);
	}

	public List<Menu> findMenuForCategory(String categoria,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByCategoria(categoria, pageSize, pageNumber);
	}
	
	public List<Menu> findMenuForName(String nombre,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByName(nombre, pageSize, pageNumber);
	}
	
	public List<Menu> findMenuForNameAndCategory(String nombre, String categoria, final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameAndCategory(nombre, categoria, pageSize, pageNumber);
	}
	
	public List<Menu> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	public Menu findByID(Integer id){
		return getRepository().findById(id);
	}
	
	public void editarMenu(Menu menu){
		getRepository().update(menu);
	}
	
	public List<Menu> findMenuForLocality(String localidad, Integer pageSize, Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByLocalidad(localidad, pageSize, pageNumber);
	}

	public List<Menu> findByNameAndLocality(String nombre, String localidad, Integer pageSize, Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameAndLocality(nombre, localidad, pageSize, pageNumber);
	}

	public List<Menu> findByCategoryAndLocality(String categoria, String localidad, Integer pageSize,
			Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByCategoryAndLocality(categoria, localidad, pageSize, pageNumber);
	}

	public List<Menu> findByNameCategoryAndLocality(String nombre, String categoria, String localidad, Integer pageSize,
			Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameCategoryAndLocality(nombre, categoria, localidad, pageSize, pageNumber);
	}
	
}