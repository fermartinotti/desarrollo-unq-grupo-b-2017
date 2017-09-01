package morfiYA.domain;

import java.util.ArrayList;
import java.util.List;

public class AlarmaCambioPrecio implements Subject {
	private static List<ICambioDePrecio> compradoresCantidadMinima = new ArrayList<ICambioDePrecio>();
	private static List<ICambioDePrecio> compradoresCantidadMinima2 = new ArrayList<ICambioDePrecio>();
	

	@Override
	public void attachCantidadMinima(ICambioDePrecio observador) {
		compradoresCantidadMinima.add(observador);
		
	}
	
	@Override
	public void attachCantidadMinima2(ICambioDePrecio observador) {
		compradoresCantidadMinima2.add(observador);
		
	}

	@Override
	public void dettachCantidadMinima(ICambioDePrecio observador) {
		compradoresCantidadMinima.remove(observador);
		
	}
	
	@Override
	public void dettachCantidadMinima2(ICambioDePrecio observador) {
		compradoresCantidadMinima2.remove(observador);
		
	}

	@Override
	public void notifyObservers() {
		for(int i  = 0; i < compradoresCantidadMinima.size(); i++){
			compradoresCantidadMinima.get(i).update();
		}
		
	}
	

}
