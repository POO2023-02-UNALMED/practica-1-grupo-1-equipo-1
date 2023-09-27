package gestorAplicacion.Personas;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;

public class Empleado extends Persona{
    private ArrayList<Turno> turnos;
    private String puesto;
    private double salario;
    private Date fechaContratacion;

    public Empleado(String nombre, String genero,int edad,String puesto) {
        super(nombre, genero, edad);
        this.setPuesto(puesto);
        this.setSalario(0);
        this.setFechaContratacion(new Date()); // Guarda la fecha actual
    }
    
    // Metodos de funcionalidades
	public void agregarTurno(Turno turno){
		this.turnos.add(turno);
	}

	// Este metodo verifica si un turno esta completado y no cobrado 
	// Para que se le agregué al salario total
	public void turnosCompletados(){
		for(Turno turno : turnos){
			if (turno.isCompletado()==true & turno.isCobrado()==false){
					salario+=turno.getSalario();
				}
			}
		}
	
    // Metodos getter
	public ArrayList<Turno> getTurno() {
		return turnos;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	
	// Métodos setter
	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}
	
	public void setTurno(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}


	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
}