package morfiYA.domain;

public class Direccion {

	private Localidad localidad;
	private String direccion;
	private Integer numero;
	//private String geolocalizacion;
	private LocalizacionMapa geolocalizacion;
	
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public LocalizacionMapa getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(LocalizacionMapa geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
}