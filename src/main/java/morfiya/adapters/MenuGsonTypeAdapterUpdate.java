package morfiya.adapters;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import morfiya.domain.Categoria;
import morfiya.exceptions.DatoInvalidoException;

public class MenuGsonTypeAdapterUpdate  implements JsonDeserializer<MenuUpdate> {
	
	public String checkStringOrNull(String string, JsonObject jobject){
		
		if(jobject.get(string) == null || jobject.get(string).isJsonNull()  ){
			return null;
		}
		else{
			return jobject.get(string).getAsString();
		}
	}
	
	public Double checkDoubleOrNull(String string, JsonObject jobject){
		
		if(jobject.get(string) == null || jobject.get(string).isJsonNull()){
			return null;
		}
		else{
			return jobject.get(string).getAsDouble();
		}
	}
	
	public Integer checkIntegerOrNull(String string,  JsonObject jobject ){
		
		if(jobject.get(string) == null || jobject.get(string).isJsonNull()){
			return null;
		}
		else{
			return jobject.get(string).getAsInt();
		}
	}
	
	public Categoria checkCategoriaOrNull(Categoria categoria){
		if(categoria == null)
			return null;
		else
			return categoria;
	}
	
	public ArrayList<String> checkListaOrNull(ArrayList<String> lista){
		if(lista == null)
			return null;
		else
			return lista;
	}



	public MenuUpdate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException, DatoInvalidoException {

		JsonObject jobject = json.getAsJsonObject();

		Gson gson = new Gson();
		JsonElement categoriaJson = jobject.get("categoria");
		Categoria categoria = gson.fromJson(categoriaJson, Categoria.class);	
		
		
		Type listType = new TypeToken<ArrayList<String>>() {}.getType();
		ArrayList<String> hEntregas = new Gson().fromJson(jobject.getAsJsonArray("horariosDeEntrega"), listType);
		ArrayList<String> henvios = new Gson().fromJson(jobject.getAsJsonArray("horariosDeEnvio"), listType);

		return new MenuUpdate(
				
				checkStringOrNull("nombre", jobject), 
				checkStringOrNull("descripcion", jobject), 
				checkCategoriaOrNull(categoria), 
				checkDoubleOrNull("valorDelivery",jobject), 
				checkStringOrNull("fechaVigenciaDesde", jobject), 
				checkStringOrNull("fechaVigenciaDesde", jobject), 
				null, // Inicializo el menu en null, porque todavia no definimos bien cual va a ser el uso
				checkListaOrNull(hEntregas),
				checkListaOrNull(henvios),
				//("horariosDeEntrega"),
				checkDoubleOrNull("precio",jobject), 
				checkIntegerOrNull("cantidadMinima", jobject), 
				checkIntegerOrNull("cantidadMinima2", jobject), 
				checkDoubleOrNull("precioCantidadMinima", jobject), 
				checkDoubleOrNull("precioCantidadMinima2", jobject), 
				checkIntegerOrNull("cantidadMaxVtasPorDia", jobject),
				checkIntegerOrNull("id", jobject));
		}
}
