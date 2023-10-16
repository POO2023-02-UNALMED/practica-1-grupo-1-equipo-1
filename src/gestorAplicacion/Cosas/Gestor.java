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
	private List<Cliente> clientes=restaurante.getClientes();
	private List<Empleado> empleados=restaurante.getEmpleados();
	private List<Mesa> mesas=restaurante.getMesas();
	private Empleado empMes=restaurante.getEmpleadoDelMes();
	private List<Reserva> reservas = new ArrayList<>();
	
	public List<Reserva> getReservas(){
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

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Mesa> getMesas() {
		return this.mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	public  Restaurante getRestaurante() {
		return this.restaurante;
	}
	
}
