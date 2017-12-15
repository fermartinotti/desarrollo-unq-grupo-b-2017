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

import morfiya.domain.Cliente;
import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.Proveedor;
import morfiya.exceptions.DatoInvalidoException;

public class PedidoGsonTypeAdapter implements JsonDeserializer<Pedido> {
		
		public Pedido deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException, DatoInvalidoException {

			JsonObject jobject = json.getAsJsonObject();

			Gson gson = new Gson();
			
			JsonElement clienteJson = jobject.get("cliente");
			Cliente cliente = gson.fromJson(clienteJson, Cliente.class);	
		
			
			Type typeP = new TypeToken<Proveedor>(){}.getType();
			Gson gsonProveedor = new GsonBuilder().registerTypeAdapter(Proveedor.class, new ProveedorGsonTypeAdapter()).create();
			Proveedor proveedor = gsonProveedor.fromJson(jobject.get("proveedor"), typeP);
			
			Type typeM = new TypeToken<Menu>(){}.getType();
			Gson gsonMenu = new GsonBuilder().registerTypeAdapter(Menu.class, new MenuGsonTypeAdapter()).create();
			Menu menu = gsonMenu.fromJson(jobject.get("menu"), typeM);

			return new Pedido(
					jobject.get("fechaDeEntrega").getAsString(),
					jobject.get("descripcion").getAsString(),
					menu,
					cliente,
					proveedor);
		}
	}


