package gestorAplicacion.Cosas;

import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.Material;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Empleado;

public class Financia implements Serializable{
	private static final long serialVersionUID=1L;
	private double presupuesto;
	private double gastosMateriales;
	private double pagosEmpleados;
	private double compraMateriales;
	private double ganancias;
	private double liquidacion;
	private double perdidas;
	
	public Financia(double presupuesto, double gastosMateriales, double pagosEmpleados, double compraMateriales, double ganancias, double liquidacion, double perdidas) {
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.pagosEmpleados = pagosEmpleados;
	this.compraMateriales = compraMateriales;
	this.ganancias = ganancias;
	this.liquidacion = liquidacion;
	this.perdidas = perdidas;
	
	}
	 public double getLiquidacion() {
	        return this.liquidacion;
	    }

	 
	 public double getGastosMateriales() {
	        return this.gastosMateriales;
	    }

	 public double getPerdidas() {
		 return this.perdidas;
	    }
	//Calcular Gasto de los Materiales
	public void gastosMateriales(Restaurante restaurante) {
        for (Material.Tipo tipo : restaurante.getInventario().keySet()) {
            Material material = restaurante.getInventario().get(tipo);
            this.gastosMateriales += material.getPrecioUnitario() * material.getCantidad();
        }
    }

	// Calcula el pago de la liquidacion de un empleado del restaurante
	
	public double liquidacion(Empleado empleado) {
        double totalSalario = 0;
        double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
        for(Turno turno : empleado.getTurnos()){
            if (turno.isCompletado() && !turno.isCobrado()){
                totalSalario += turno.getSalario();
                int horasExtras = turno.HorasExtras();
                if (horasExtras > 0) {
                    totalSalario += horasExtras * (turno.getSalario() / turno.getHoras()) * pagoHoraExtra;
                }
                turno.setCobrado(true);
            }
        }
        return totalSalario;
    }
	
	// Calcula las perdidas del inventario  del restaurante
	public void perdidas(Restaurante restaurante) {
        for (Material.Tipo tipo : restaurante.getInventario().keySet()) {
            Material material = restaurante.getInventario().get(tipo);
            this.perdidas += material.getPrecioUnitario() * material.getCantidad();
        }
    }
	
}
