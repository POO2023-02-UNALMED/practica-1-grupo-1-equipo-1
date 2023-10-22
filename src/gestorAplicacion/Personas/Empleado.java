package gestorAplicacion.Personas;
import java.util.Date;
import java.util.List;

import gestorAplicacion.Cosas.Material;
import gestorAplicacion.Cosas.Mesa;
import gestorAplicacion.Cosas.Pedido;
import gestorAplicacion.Cosas.Plato;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;

import java.util.ArrayList;
import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
    private ArrayList<Turno> turnos;
    private Turno turno;
    private String puesto;
    private double salario;
    private Date fechaContratacion;
    private Restaurante restaurante;
    private int puntuacion;
    
    public Empleado() {
    	
    }
    public Empleado(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
        super(nombre, cedula);
        this.puesto = puesto;
        this.restaurante = restaurante;
        this.turnos = new ArrayList<>(); // Inicializa la lista de turnos
        this.turnos.add(turno); // Añade el turno a la lista
        this.setFechaContratacion(new Date()); // Guarda la fecha actual
        restaurante.contratarEmpleado(this);
    }
    
    
    // Metodos de funcionalidades
    // Verificar Tiempo
    public boolean verificarTiempo(Empleado empleado,int tiempoPlato){
    	for (Turno turno : empleado.getTurnos()) {
    		if(!turno.isCobrado()){
    			int tiempoDisponible = turno.getHoras()* 60;
    	    	if(tiempoDisponible>tiempoPlato){
    	    		return true;
    	    		}
    	    	}
    			}
		return false;
    }
    public boolean verificarTiempo(Empleado empleado){
    	if(empleado.getPuesto().equals("domicilio")){
    	for (Turno turno : empleado.getTurnos()) {
    		if(!turno.isCobrado()){
    			int tiempoDisponible = turno.getHoras()* 60; 
    			if( tiempoDisponible > Pedido.TIEMPO_DOMICILIO ){
    				return true;}}}
    	if(empleado.getPuesto().equals("domicilio")){
    		for (Turno turno : empleado.getTurnos()) {
        		if(!turno.isCobrado()){
        			int tiempoDisponible = turno.getHoras()* 60; 
        			if( tiempoDisponible > Pedido.TIEMPO_MESERO ){
        				return true;}}}
    	}
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
	public Turno getTurno() {
		return turno;
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
	public void reportarDano(Material.Tipo material,int cantidad) {
		this.restaurante.botarMaterial(material, cantidad);
	}
	
	public String mostrarPorTipo(String tipo){
		for(Empleado empleado : restaurante.getEmpleados()){
			return empleado.toString();
		}
		return null;
	}
	private Turno turnoActual() {
		for(Turno turno : this.turnos)
		{
			if(!turno.isCobrado()){
				return turno;
			}
		}
		return null;
		}
	public String toString(){
		return "Nombre: " + this.getNombre()+ " Puesto: "+ this.getPuesto() ;
	}
	
	public void puntuacion(Empleado e) {
		
	}
	
}