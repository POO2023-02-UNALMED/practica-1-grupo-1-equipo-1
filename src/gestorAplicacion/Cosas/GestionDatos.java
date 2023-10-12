package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import baseDatos.Deserializador;
import gestorAplicacion.Personas.Cliente;
import gestorAplicacion.Personas.Empleado;

public class GestionDatos implements Serializable{
	private static final long serialVersionUID=1L;
	
	private Restaurante restaurante;
	private ArrayList<Mesa> mesas;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	public GestionDatos(Restaurante rest,ArrayList<Mesa> mesa,ArrayList<Empleado> emp,ArrayList<Cliente> clientes) {
		this.restaurante=rest;
		this.mesas=mesa;
		this.empleados=emp;
		this.clientes=clientes;
		//Deserializador.deserializar(this);
	}
	/*getter y setter*/
	public Restaurante getRestaurante() {
		return this.restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public ArrayList<Mesa> getMesas() {
		return this.mesas;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	public ArrayList<Empleado> getEmpleados() {
		return this.empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
}
