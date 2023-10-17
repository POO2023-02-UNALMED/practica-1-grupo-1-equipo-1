package gestorAplicacion.Cosas;

import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Empleado;

public class Financia implements Serializable{
	private static final long serialVersionUID=1L;
	
	private double presupuesto;
	private double gastosMateriales;
	private double pagosEmpleados;
	private double ganancias;
	private double liquidacion;
	private double perdidas;
	
	public Financia(double presupuesto, double gastosMateriales, double pagosEmpleados, double ganancias, double liquidacion, double perdidas) {
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.pagosEmpleados = pagosEmpleados;
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
	 
	 public double getPagosEmpleados() {
	        return this.pagosEmpleados;
	 }

	 public double getPerdidas() {
		 return this.perdidas;
		 
	    }
	//Calcular Gasto de los Materiales
	 public double gastosMateriales(Restaurante restaurante) {
		    double totalGastosMateriales = 0;
		    for (Pedido pedido : restaurante.getPedidos()) {
		        for (Plato plato : pedido.getPlatos()) {
		            for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
		                Material material = entrada.getKey();
		                int cantidadUtilizada = entrada.getValue();
		                totalGastosMateriales += material.getPrecioUnitario() * cantidadUtilizada;
		            }
		        }
		    }
		    this.gastosMateriales = totalGastosMateriales;
		    return totalGastosMateriales;
		}

	// Calcula el pago de la liquidacion de un empleado del restaurante
	public double LiquidacionEmpleado(Empleado empleado) {
	    double totalPago = 0;
	    for (Turno turno : empleado.getTurnos()) {
	        if (turno.isCompletado() && !turno.isCobrado()) {
	            totalPago += turno.getSalario();
	            int horasExtras = turno.HorasExtras();
	            if (horasExtras > 0) {
	                double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
	                totalPago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
	            }
	            turno.setCobrado(true);
	        }
	    }
	    return totalPago;
	}
	// Calcula las perdidas del inventario  del restaurante
	public void perdidas(Restaurante restaurante) {
        for (Material.Tipo tipo : restaurante.getInventario().keySet()) {
            Material material = restaurante.getInventario().get(tipo);
            this.perdidas += material.getPrecioUnitario() * material.getCantidad();
        }
    }
	
	//Calcular Pagos de los Empleados
	public double pagosEmpleados(Restaurante restaurante) {
	    double totalPago = 0;
	    for (Empleado empleado : restaurante.getEmpleados()) {
	        totalPago += empleado.getSalario();
	        for (Turno turno : empleado.getTurnos()) {
	            if (turno.isCompletado() && !turno.isCobrado()) {
	                int horasExtras = turno.HorasExtras();
	                if (horasExtras > 0) {
	                    double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
	                    totalPago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
	                }
	            }
	        }
	    }
	    this.pagosEmpleados = totalPago;
	    return totalPago;
	}
	
}
