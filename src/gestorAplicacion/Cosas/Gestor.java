package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import baseDatos.Deserializador;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Empleado;
import gestorAplicacion.Personas.Cliente;


public class Gestor implements Serializable{
	private static final long serialVersionUID=1L;
	private Restaurante restaurante=new Restaurante();
	private ArrayList<Cliente> clientes=(ArrayList<Cliente>) restaurante.getClientes();
	private ArrayList<Empleado> empleados= (ArrayList<Empleado>) restaurante.getEmpleados();
	private ArrayList<Mesa> mesas= (ArrayList<Mesa>) restaurante.getMesas();
	private Empleado empMes=restaurante.getEmpleadoDelMes();
	private ArrayList<Reserva> reservas = new ArrayList<>();
	
	public ArrayList<Reserva> getReservas(){
		return reservas;
	}
	/*public void setReservas(ArrayList<Reserva> reservas) {
		ArrayList<Mesa> mesas1 = mesas;
		for (Mesa mesa:mesas1) {
			reservas.add(Reserva mesa.getReserva());
		}
	}*/
	
	public Empleado getEmpleadoDelMes() {
		return this.empMes;
	}

	public void setEmpleadoDelMes(Empleado empMes) {
		this.empMes = empMes;
	}

	public Gestor() {
		Deserializador.deserializar(this);
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Mesa> getMesas() {
		return this.mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	public  Restaurante getRestaurante() {
		return this.restaurante;
	}
	
}
