package morfiYA.domain;

public class LocalizacionMapa {
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
