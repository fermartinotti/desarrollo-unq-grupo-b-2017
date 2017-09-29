package morfiya.domain;

public class LocalizacionMapa extends Entity {
	
	private static final long serialVersionUID = -437707288653161778L;
	double latitud;
	double longitud;
	
	public double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public LocalizacionMapa(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
}
