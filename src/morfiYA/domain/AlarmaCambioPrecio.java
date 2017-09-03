package morfiYA.domain;

import java.util.ArrayList;
import java.util.List;

import morfiYA.exceptions.DatoInvalidoException;

public class AlarmaCambioPrecio {
	private static List<Cliente> compradoresCantidadMinima = new ArrayList<Cliente>();
	private static List<Cliente> compradoresCantidadMinima2 = new ArrayList<Cliente>();
	private static List<Proveedor> proveedores = new ArrayList<Proveedor>();

	
	public void attachCantidadMinima(Cliente observador) {
		compradoresCantidadMinima.add(observador);
		
	}
	
	
	public void attachCantidadMinima2(Cliente observador) {
		compradoresCantidadMinima2.add(observador);
		
	}
	
	public void attachProveedores(Proveedor proveedor) {
		proveedores.add(proveedor);
	}

	
	public void dettachCantidadMinima(Cliente observador) {
		compradoresCantidadMinima.remove(observador);
		
	}
	
	
	public void dettachCantidadMinima2(Cliente observador) {
		compradoresCantidadMinima2.remove(observador);
		
	}
	
	public void dettachProveedores(Proveedor proveedor) {
		proveedores.remove(proveedor);
	}

	public void notifyObserversCantidadMinima(double monto) throws DatoInvalidoException {
		for(int i  = 0; i < compradoresCantidadMinima.size(); i++){
			compradoresCantidadMinima.get(i).cargarCredito(monto);
		}
	}
		
	public void notifyObserversCantidadMinima2(double monto) throws DatoInvalidoException {
		for(int i  = 0; i < compradoresCantidadMinima2.size(); i++){
			compradoresCantidadMinima.get(i).cargarCredito(monto);
			}
	}

	public void notifyObserversProveedores(double monto) throws DatoInvalidoException {
		for(int i  = 0; i < proveedores.size(); i++){
			compradoresCantidadMinima.get(i).cargarCredito(monto);
		}
	}
}


