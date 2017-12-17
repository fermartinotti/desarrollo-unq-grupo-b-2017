package morfiya.services;

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
	public Menu crearMenu(Menu menu) {
		return getRepository().save(menu);
	}
	
	@Transactional
	public List<Menu> findMenuForCategory(String categoria,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByCategoria(categoria, pageSize, pageNumber);
	}
	
	@Transactional
	public List<Menu> findMenuForName(String nombre,final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByName(nombre, pageSize, pageNumber);
	}

    @Transactional
	public List<Menu> findMenuForNameAndCategory(String nombre, String categoria, final Integer pageSize, final Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameAndCategory(nombre, categoria, pageSize, pageNumber);
	}
  
	@Transactional
	public List<Menu> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	@Transactional
	public Menu findByID(Integer id){
		authService.getCliente();
		return getRepository().findById(id);
	}
	
	@Transactional
	public void editarMenu(Menu menu){
		getRepository().update(menu);
	}
	
    @Transactional
	public List<Menu> findMenuForLocality(String localidad, Integer pageSize, Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByLocalidad(localidad, pageSize, pageNumber);
	}

    @Transactional
	public List<Menu> findByNameAndLocality(String nombre, String localidad, Integer pageSize, Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameAndLocality(nombre, localidad, pageSize, pageNumber);
	}

    @Transactional
	public List<Menu> findByCategoryAndLocality(String categoria, String localidad, Integer pageSize,
			Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByCategoryAndLocality(categoria, localidad, pageSize, pageNumber);
	}

    @Transactional
	public List<Menu> findByNameCategoryAndLocality(String nombre, String categoria, String localidad, Integer pageSize,
			Integer pageNumber) {
		return ((MenuDAO)getRepository()).findByNameCategoryAndLocality(nombre, categoria, localidad, pageSize, pageNumber);
	}

	
}