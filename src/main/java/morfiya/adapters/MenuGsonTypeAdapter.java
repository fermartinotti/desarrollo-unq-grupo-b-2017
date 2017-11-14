package morfiya.adapters;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import morfiya.domain.Categoria;
import morfiya.domain.Menu;
import morfiya.exceptions.DatoInvalidoException;

public class MenuGsonTypeAdapter implements JsonDeserializer<Menu> {

	public Menu deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException, DatoInvalidoException {

		JsonObject jobject = json.getAsJsonObject();

		Gson gson = new Gson();
		JsonElement categoriaJson = jobject.get("categoria");
		Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);	
		
		
//		Type listType = new TypeToken<ArrayList<String>>() {}.getType();
//		ArrayList<String> hEntregas = new Gson().fromJson(jobject.getAsJsonArray("horariosDeEntrega"), listType);
//		ArrayList<String> henvios = new Gson().fromJson(jobject.getAsJsonArray("horariosDeEnvio"), listType);

		Menu menu = new Menu();
		if(jobject.has("nombre")) menu.setNombre(jobject.get("nombre").getAsString());
		if(jobject.has("descripcion")) menu.setDescripcion(jobject.get("descripcion").getAsString());
		if(categoria != null) menu.setCategoria(categoria);
		if(jobject.has("valorDelivery")) menu.setValorDelivery(jobject.get("valorDelivery").getAsDouble());
//		if(jobject.has("fechaVigenciaDesde")) menu.setFechaVigenciaDesde(jobject.get("fechaVigenciaDesde").getAsString());
//		if(jobject.has("fechaVigenciaHasta"))jobject.get("fechaVigenciaHasta").getAsString();
		
		if(jobject.has("precio")) menu.setPrecio(jobject.get("precio").getAsDouble());
		if(jobject.has("cantidadMinima")) menu.setCantidadMinima(jobject.get("cantidadMinima").getAsInt());
		if(jobject.has("cantidadMinima2")) menu.setCantidadMinima2(jobject.get("cantidadMinima2").getAsInt());
		if(jobject.has("precioCantidadMinima")) menu.setPrecioCantidadMinima(jobject.get("precioCantidadMinima").getAsDouble());
		if(jobject.has("precioCantidadMinima2"))  menu.setPrecioCantidadMinima2(jobject.get("precioCantidadMinima2").getAsDouble()); 
		if(jobject.has("cantidadMaxVtasPorDia")) menu.setCantidadMaxVtasPorDia(jobject.get("cantidadMaxVtasPorDia").getAsInt());
		
		return menu;
	}
}