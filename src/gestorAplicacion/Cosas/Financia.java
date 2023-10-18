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
	 private Restaurante restaurante;
	
	public Financia(Restaurante restaurante, double presupuesto, double gastosMateriales, double pagosEmpleados, double ganancias, double liquidacion, double perdidas) {
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.pagosEmpleados = pagosEmpleados;
	this.ganancias = ganancias;
	this.liquidacion = liquidacion;
	this.perdidas = perdidas;
	this.restaurante = restaurante;
	
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
	 
	 //Calcular el presupuesto
	 public double Presupuesto() {
		    double totalGastos = gastosMateriales() + pagosEmpleados(restaurante);
		    this.presupuesto = this.presupuesto - totalGastos;
		    return this.presupuesto;
		}
	//Calcular Gasto de los Materiales
	 public double gastosMateriales() {
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
	 
	 public double calcularLiquidacionEmpleado(String nombreEmpleado) {
		 
	        // Iterar sobre la lista de empleados del restaurante
		 
	        for (Empleado empleado : restaurante.getEmpleados()) {
	        	
	            // Comprobar si el nombre del empleado actual coincide con el nombre del empleado proporcionado
	        	
	            if (empleado.getNombre().equals(nombreEmpleado)) {
	                double totalPago = 0;
	                for (Turno turno : empleado.getTurnos()) {
	                    if (turno.isCompletado() && !turno.isCobrado()) {
	                        totalPago += calcularPago(turno, empleado);
	                        turno.setCobrado(true);
	                    }
	                }
	                return totalPago;
	            }
	        }

	        // Si no se encuentra al empleado, devolver -1
	        return -1;
	    }

	    // Método separado para calcular el pago por un turno, incluyendo horas extras
	    private double calcularPago(Turno turno, Empleado empleado) {
	        double pago = turno.getSalario();
	        int horasExtras = turno.HorasExtras();
	        if (horasExtras > 0) {
	            double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
	            pago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
	        }
	        return pago;
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
