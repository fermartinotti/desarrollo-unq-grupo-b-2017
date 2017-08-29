package morfiYA.domain;

public enum Localidad {
	
	ALMIRANTE_BROWN("Almirante Brown"),
	ALTA_GRACIA("Alta Gracia"),
	APOLINARIO_SARAVIA("Apolinario Saravia"),
	AVELLANEDA("Avellaneda"), 
	AZUL("Azul"),
	BAHIA_BLANCA("Bahia Blanca"),
	BERAZATEGUI("Berazategui"),
	BERISSO("Berisso"),
	CAMPANA("Campana"),
	CAPITAL_FEDERAL("Capital Federal"),
	CAPITAN_BERMUDEZ("Capitan Bermudez"),
	CHACABUCO("Chacabuco"),
	CHILECITO("Chilecito"),
	COLONIA("Colonia"),
	COMODORO_RIVADAVIA("Comodoro Rivadavia"),
	CORDOBA("Cordoba"),
	CORRIENTES("Corrientes"),
	COSQUIN("Cosquin"),
	ESCOBAR("Escobar"),
	ESTEBAN_ECHEVERRIA("Esteban Echeverria"),
	EXALTACION_DE_LA_CRUZ("Exaltaci�n de la Cruz"),
	EZEIZA("Ezeiza"),
	FLORENCIO_VARELA("Florencio Varela"),
	FRAY_LUIS_BELTRAN("Fray Luis Beltr�n"),
	GENERAL_JUAN_MADARIAGA("General Juan Madariaga"),
	GENERAL_ROCA("General Roca"),
	GENERAL_RODRIGUEZ("General Rodr�guez"),
	GODOY_CRUZ("Godoy Cruz"),
	GRANADERO_BAIGORRIA("Granadero Baigorria"),
	FUNES("Funes"),
	GUAYMALLEN("Guaymallen"),
	HURLINGHAM("Hurlingham"),	
	ITUZAINGO("Ituzaingo"),
	JESUS_MARIA("Jesus Maria"),
	JOAQUIN_V_GONZALEZ("Joaquin V. Gonz�lez"),
	JUNIN("Junin"),
	LA_CALERA("La Calera"),
	LA_COSTA("La Costa"),
	LA_FALDA("La Falda"),
	LA_MATANZA("La Matanza"),
	LA_PLATA("La Plata"),
	LANUS("Lanus"),
	LAS_HERAS("Las Heras"),
	LAS_TALITAS("Las Talitas"),
	LOBOS("Lobos"),
	LOMAS_DE_ZAMORA("Lomas de Zamora"),
	LUJAN("Lujan"),
	LUJAN_DE_CUYO("Luj�n de Cuyo"),
	MAIPU("Maipu"),
	MALVINAS_ARGENTINAS("Malvinas Argentinas"),
	MAR_DEL_PLATA("Mar del Plata"),
	MENDIOLAZA("Mendiolaza"),
	MENDOZA ("Mendoza"),
	MERLO("Merlo"),
	MIRAMAR("Miramar"),
	MORENO("Moreno"),
	MORON("Moron"),
	NECOCHEA("Necochea"),
	NEUQUEN("Neuquen"),
	PALPALA("Palpala"),
	PARANA("Paran�"),
	PILAR("Pilar"),
	PINAMAR("Pinamar"),
	POSADAS("Posadas"),
	PUEBLO_ESTHER("Pueblo Esther"),
	PUERTO_GENERAL_SAN_MARTIN("Puerto General San Mart�n"),
	PUERTO_IGUAZU("Puerto Iguaz�"),
	QUILMES("Quilmes"),RADA_TILLY("Rada Tilly"),
	RAFAELA("Rafaela"),
	RECONQUISTA("Reconquista"),
	RIO_CEBALLOS("R�o Ceballos"),
	RIO_CUARTO("R�o Cuarto"),
	RIO_GALLEGOS("R�o Gallegos"),
	RIO_PRIMERO("R�o Primero"),
	RIVADAVIA_SAN_JUAN("Rivadavia de San Juan"),
	ROLDAN("Rold�n"),
	ROSARIO("Rosario"),
	SALTA("Salta"),
	SAN_FERNANDO("San Fernando"),
	SAN_FRANCISCO("San Francisco"),
	SAN_ISIDRO("San Isidro"),
	SAN_JUAN("San Juan"),
	SAN_LORENZO("San Lorenzo"),
	SAN_LUIS("San Luis"),
	SAN_MARTIN("San Mart�n"),
	SAN_MARTIN_DE_LOS_ANDES("San Mart�n de los Andes"),
	SAN_MIGUEL("San Miguel"),
	SAN_MIGUEL_DE_TUCUMAN("San Miguel de Tucum�n"),
	SAN_MIGUEL_DEL_MONTE("San Miguel del Monte"),
	SAN_NICOLAS("San Nicol�s"),
	SAN_PEDRO_DE_JUJUY("San Pedro de Jujuy"),
	SAN_RAFAEL("San Rafael"),
	SAN_SALVADOR_DE_JUJUY("San Salvador de Jujuy"),
	SANTA_FE("Santa Fe"),
	SANTA_LUCIA("Santa Luc�a"),
	SANTA_ROSA("Santa Rosa"),
	SANTIAGO_DEL_ESTERO("Santiago del Estero"),	
	SANTO_TOME("Santo Tom�"),
	TANDIL("Tandil"),
	TEMPERLEY("Temperley"),
	TIGRO("Tigre"),
	TRENQUE_LAUQUEN("Trenque Lauquen"),
	TRES_DE_FEBRERO("3 de Febrero"),
	UNQUILLO("Unquillo"),
	VICENTE_LOPEZ("Vicente L�pez"),
	VILLA_ALLENDE("Villa Allende"),
	VILLA_CARLOS_PAZ("Villa Carlos Paz"),
	VILLA_GESELL("Villa Gesell"),	
	VILLA_GOBERNADOR_GALVEZ("Villa Gobernador G�lvez"),
	VILLA_KRAUSE("Villa Krause"),
	VILLA_MARIA("Villa Mar�a"),
	VILLA_MERCEDES("Villa Mercedes"),
	YERBA_BUENA("Yerba Buena"),
	ZARATE("Z�rate");
	
	private final String localidad;
	
	Localidad(String name){
		this.localidad = name;
	}
	
	public String getLocalidad(){
		return this.localidad;
	}
}
