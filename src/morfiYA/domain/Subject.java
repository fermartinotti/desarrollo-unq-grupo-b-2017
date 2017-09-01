package morfiYA.domain;

public interface Subject {
	public void attachCantidadMinima(ICambioDePrecio observador);
	public void attachCantidadMinima2(ICambioDePrecio observador);
	public void dettachCantidadMinima(ICambioDePrecio observador);
	public void dettachCantidadMinima2(ICambioDePrecio observador);
	public void notifyObservers();
	

}
