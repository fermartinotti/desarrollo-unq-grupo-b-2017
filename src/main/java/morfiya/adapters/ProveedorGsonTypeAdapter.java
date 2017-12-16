package morfiya.adapters;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import morfiya.domain.Proveedor;
import morfiya.domain.Servicio;
import morfiya.exceptions.DatoInvalidoException;

public class ProveedorGsonTypeAdapter implements JsonDeserializer<Proveedor> {
	
	public Proveedor deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException, DatoInvalidoException {

		JsonObject jobject = json.getAsJsonObject();
		
		Type typeS = new TypeToken<Servicio>(){}.getType();
		Gson gsonServicio = new GsonBuilder().registerTypeAdapter(Servicio.class, new ServicioGsonTypeAdapter()).create();
		Servicio servicio = gsonServicio.fromJson(jobject.get("servicio"), typeS);

		return new Proveedor(
				jobject.get("nombre").getAsString(),
				servicio,
				jobject.get("creditos").getAsDouble(),
				jobject.get("email").getAsString());
	}
}

