package gestorAplicacion.Cosas;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.Material.*;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class Financia {
	private double presupuesto;
	private double gastosMateriales;
	private float pagosEmpleados;
	private float compraMateriales;
	private float ganancias;
	private float liquidacion;
	private float perdidas;
	
	public Financia(double presupuesto, double gastosMateriales, float pagosEmpleados, float compraMateriales, float ganancias, float liquidacion, float perdidas) {
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.pagosEmpleados = pagosEmpleados;
	this.compraMateriales = compraMateriales;
	this.ganancias = ganancias;
	this.liquidacion = liquidacion;
	this.perdidas = perdidas;
	
	}
	
	//Calcular Gasto de los Materiales
	public double gastosMateriales() {
	    double totalGastosMateriales = 0;
	    for (Material material: Tipo.values()) {
	    	totalGastosMateriales += material.getCantidad()*material.getPrecioUnitario();
	    	}
	    	return totalGastosMateriales;
	}
	public double presupuesto() {
		double total=0;
		
}
}
