package morfiYA.domain;

public enum Localidad {
	QUILMES("Quilmes"),
	FLORENCIO_VARELA("Florencio Varela"),
	AVELLANEDA("Avellaneda"), 
	LA_MATANZA("La Matanza"),
	LOMAS_DE_ZAMORA("Lomas de Zamora"),
	ESCOBAR("Escobar"),
	TEMPERLEY("Temperley"),
	CAMPANA("Campana"),
	BERAZATEGUI("Berazategui"),
	BERISSO("Berisso"),
	LANUS("Lanus"),
	MERLO("Merlo"),
	LA_PLATA("La Plata"),
	LUJAN("Lujan"),
	HURLINGHAM("Hurlingham"),
	TRES_DE_FEBRERO("3 de Febrero");
	
	
	private final String localidad;
	
	Localidad(String name){
		this.localidad = name;
	}
	
	public String getLocalidad(){
		return this.localidad;
	}
}
