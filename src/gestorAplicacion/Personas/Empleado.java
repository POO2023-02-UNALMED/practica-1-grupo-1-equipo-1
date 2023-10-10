package gestorAplicacion.Personas;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;

public class Empleado extends Persona{
    private ArrayList<Turno> turnos;
    private Turno turno;
    private String puesto;
    private double salario;
    private Date fechaContratacion;
    private Restaurante restaurante;
    private int puntuacion;
    public Empleado(String nombre, String puesto,Restaurante restaurante, Turno turno){
        super(nombre);
        this.puesto = puesto;
        this.restaurante = restaurante;
        this.turno = turno;
        this.setFechaContratacion(new Date()); // Guarda la fecha actual
    }
    
    
    // Metodos de funcionalidades
    // Verificar Tiempo
    public boolean verificarTiempo(int tiempoPlato){
    	int tiempoDisponible = this.turno.getHoras()* 60;
    	if(tiempoDisponible>tiempoPlato){
    		return true;
    		}
    	return false;
    	}
    public boolean verificarTiempo(){
    	int tiempoDisponible = this.turno.getHoras()* 60; 
    	if( tiempoDisponible > Plato.TIEMPO_DOMICILIO_MINUTOS ){
    		return true;
    	}
		return false;
    }
	
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
	public Restaurante getRestaurante() {
		return this.restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante=restaurante;
	}
	public int getPuntuacion() {
	    return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
	    this.puntuacion = puntuacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	//metodo que permite reportar daños a un material no organico
	public void reportarDano(Material material,int cantidad) {
		this.restaurante.botarMaterial(material, cantidad);
	}
}