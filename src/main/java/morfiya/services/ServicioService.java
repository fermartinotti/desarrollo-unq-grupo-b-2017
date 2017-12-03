package morfiya.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import morfiya.domain.Menu;
import morfiya.domain.Servicio;
import morfiya.repositories.ServicioDAO;

public class ServicioService extends GenericService<Servicio> {

	private static final long serialVersionUID = 4521664640877587349L;
	
	@Transactional
	public List<Servicio> getAll() {
		return getRepository().findAll();
	}
	
	@Transactional
	public List<Servicio> getAllByPage(final int pageSize, final int pageNumber){
		return getRepository().getAllByPage(pageSize, pageNumber);
	}
	
	@Transactional
	public void crearServicio(Servicio servicio) {
		getRepository().save(servicio);
	}

	@Transactional
	public List<Menu> findMenuForLocalidad(String localidad, final Integer pageSize, final Integer pageNumber) {
		return ((ServicioDAO)getRepository()).findByLocalidad(localidad, pageSize, pageNumber);
	}
}
