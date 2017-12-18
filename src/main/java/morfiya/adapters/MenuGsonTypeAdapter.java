package morfiya.adapters;

import java.lang.reflect.Type;
import java.time.LocalDate;

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

	
		return new Menu(
				jobject.get("nombre").getAsString(), 
				jobject.get("descripcion").getAsString(), 
				categoria, 
				jobject.get("valorDelivery").getAsDouble(), 
				"2017-12-05", 
				"2017-12-12", 
				//null,
				//hEntregas,
				//henvios,
				//("horariosDeEntrega"),
				jobject.get("precio").getAsDouble(), 
				jobject.get("cantidadMinima").getAsInt(), 
				jobject.get("cantidadMinima2").getAsInt(), 
				jobject.get("precioCantidadMinima").getAsDouble(), 
				jobject.get("precioCantidadMinima2").getAsDouble(), 
				jobject.get("cantidadMaxVtasPorDia").getAsInt());
	}
}