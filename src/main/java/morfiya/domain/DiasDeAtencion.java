package morfiya.domain;

import java.time.LocalTime;
import java.util.List;

public class DiasDeAtencion extends Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<DiaLaboral> diasAbierto; // falta ver como mapear
	LocalTime horarioDeApertura;
	LocalTime horarioDeCierre;
}
