package morfiya.services;

import java.util.List;

import morfiya.domain.Menu;

public class MenuService extends GenericService<Menu>{
	
	private static final long serialVersionUID = -7961010215734577876L;

	public List<Menu> getAll() {
		return getRepository().findAll();
	}
	
	public void crearMenu(Menu menu) {
		getRepository().save(menu);
	}
}