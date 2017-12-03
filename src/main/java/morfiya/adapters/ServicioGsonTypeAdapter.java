package morfiya.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import morfiya.domain.Direccion;
import morfiya.domain.Localidad;
import morfiya.domain.Menu;
import morfiya.domain.Servicio;
import morfiya.domain.Telefono;
import morfiya.exceptions.DatoInvalidoException;

public class ServicioGsonTypeAdapter implements JsonDeserializer<Servicio> {
	
	public Servicio deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException, DatoInvalidoException {

		JsonObject jobject = json.getAsJsonObject();

		Gson gson = new Gson();
		
		JsonElement localidadJson = jobject.get("localidadDeEntregas");
		Localidad localidad = gson.fromJson(localidadJson, Localidad.class);	
		
		JsonElement telefonoJson = jobject.get("telefono");
		Telefono telefono = gson.fromJson(telefonoJson, Telefono.class);
		
		//JsonElement diasDeAtencionJson = jobject.get("atencionAlPublico");
		//DiasDeAtencion diasDeAtencion = gson.fromJson( diasDeAtencionJson, DiasDeAtencion.class);
		
		JsonElement direccionJson = jobject.get("direccion");
		Direccion direccion = gson.fromJson( direccionJson, Direccion.class);
		
		Type listType = new TypeToken<ArrayList<Menu>>() {}.getType();
		Gson gsonMenu = new GsonBuilder().registerTypeAdapter(Menu.class, new MenuGsonTypeAdapter()).create();
		ArrayList<Menu> menus = gsonMenu.fromJson(jobject.getAsJsonArray("menus"), listType);
		

		return new Servicio(
				jobject.get("nombre").getAsString(), 
				menus,
				direccion,
				jobject.get("descripcion").getAsString(), 
				jobject.get("link").getAsString(), 
				jobject.get("email").getAsString(), 
				telefono,
				//diasDeAtencion,
				localidad);
	}
}