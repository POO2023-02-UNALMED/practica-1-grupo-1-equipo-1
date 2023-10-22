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
	private double gastoMaterialEspecifico;
	private double pagosEmpleados;
	private double gananciasBrutas;
	private double gananciasNetas;
	private double perdidas;
	private Restaurante restaurante;
	public Financia() {
		this.presupuesto = 1000000;
		this.gastosMateriales = 0;
		this.gastoMaterialEspecifico = 0;
		this.pagosEmpleados = 0;
		this.gananciasBrutas = 0;
		this.gananciasNetas = 0 ;
		this.perdidas = 0;
	}
	public Financia(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Financia(Restaurante restaurante, double presupuesto, double gastosMateriales,double gastoMaterialEspecifico, double pagosEmpleados, double gananciasBrutas, double gananciasNetas, double liquidacion, double perdidas) {
	this.restaurante = restaurante;
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.gastoMaterialEspecifico = gastoMaterialEspecifico;
	this.pagosEmpleados = pagosEmpleados;
	this.gananciasBrutas = gananciasBrutas;
	this.gananciasNetas = gananciasNetas;
	this.perdidas = perdidas;
	
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	public double getGastosMateriales() {
		return gastosMateriales;
	}
	public double getGastoMaterialEspecifico() {
		return gastoMaterialEspecifico;
	}
	public double getPagosEmpleados() {
		return pagosEmpleados;
	}
	public double getGananciasBrutas() {
		return gananciasBrutas;
	}
	public double getGananciasNetas() {
		return gananciasNetas;
	}
	public double getPerdidas() {
		return perdidas;
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
	    return this.gastosMateriales;
	}

	 // Calcula el valor de un tipo de material 
	 
	 public double gastoMaterialEspecifico(Material.Tipo tipoMaterial) {
	        double totalGastoMaterial = 0;
	        for (Pedido pedido : this.restaurante.getPedidos()) {
	            for (Plato plato : pedido.getPlatos()) {
	                for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
	                    Material material = entrada.getKey();
	                    if (material.getTipo() == tipoMaterial) {
	                        int cantidadUtilizada = entrada.getValue();
	                        totalGastoMaterial += material.getPrecioUnitario() * cantidadUtilizada;
	                    }
	                }
	            }
	        }
	        this.gastoMaterialEspecifico = totalGastoMaterial;  // Almacenar el resultado en la variable de instancia
	        return this.gastoMaterialEspecifico;
	    }


	// Calcula el pago de la liquidacion de un empleado del restaurante
	 
	 public double liquidacionEmpleado(String nombreEmpleado) {
		 
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
	 
	    public double calcularPago(Turno turno, Empleado empleado) {
	        double pago = turno.getSalario();
	        int horasExtras = turno.HorasExtras();
	        if (horasExtras > 0) {
	            double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
	            pago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
	        }
	        return pago;
	    }
	    
	// Calcula las perdidas del inventario  del restaurante
	    public double calcularPerdidas() {
	        
	        this.perdidas = 0;
	        
	        Map<Material.Tipo, Material> inventario = this.restaurante.getInventario();

	        for (Material.Tipo tipo : inventario.keySet()) {
	            Material material = inventario.get(tipo);

	            if (material.getCantidad() < 0) {
	                // Calculamos el costo de los materiales botados y lo sumamos a las pérdidas
	                this.perdidas += material.getPrecioUnitario() * Math.abs(material.getCantidad());
	            }
	        }
	        return this.perdidas;
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
	    return this.pagosEmpleados;
	}
	
	public double gananciasBrutas() {
        double totalGananciasBrutas = 0;
        for (Pedido pedido : restaurante.getPedidos()) {
        	totalGananciasBrutas += pedido.getPrecioTotal();
        }
        this.gananciasBrutas = totalGananciasBrutas;
        return this.gananciasBrutas;
    }

    // Método para calcular las ganancias netas del restaurante
    public double gananciasNetas() {
        double totalGastos = gastosMateriales() + pagosEmpleados(restaurante);
        double totalIngresos = gananciasBrutas();
        this.gananciasNetas = totalIngresos - totalGastos;
        return this.gananciasNetas;
    }

    // Método para calcular el presupuesto considerando las ganancias
    public double presupuesto() {
        double totalGastos = gastosMateriales() + pagosEmpleados(restaurante);
        double gananciasNetas = gananciasNetas();
        this.presupuesto = this.presupuesto - totalGastos + gananciasNetas;
        return presupuesto;
    }

	
}
