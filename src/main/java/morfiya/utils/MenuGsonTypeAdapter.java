package morfiya.utils;

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

		return new Menu(jobject.get("nombre").getAsString(), jobject.get("descripcion").getAsString(), categoria, jobject.get("valorDelivery").getAsDouble(), null, null, null, jobject.get("precio").getAsDouble(), jobject.get("cantidadMinima").getAsInt(), jobject.get("cantidadMinima2").getAsInt(), jobject.get("precioCantidadMinima").getAsDouble(), jobject.get("precioCantidadMinima2").getAsDouble(), null);

		// new Timestamp(jobject.get("update_date").getAsLong()));
	}
}