package gestorAplicacion.Cosas;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.Material.Tipo;
import java.io.Serializable;
import gestorAplicacion.Personas.*;

public class Restaurante {
    private final String nombre = "Queseria de mi sin ti";
    private Empleado empleadoDelMes;
    private int numMesas;
    private int numEmpleados;
    private int numClientes;
    private List<Empleado> listadoEmpleados;
    private List<Cliente> listadoClientes;
    private List<Mesa> listadoMesas;
    private Map<Tipo, Material> inventario;
    private List<String> inventarioStr;
    


    public Restaurante () {
        this(new ArrayList<>());
    }
    public Restaurante(List<Mesa> listadoMesas) {
        this(listadoMesas, new ArrayList<>());
    }
    public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados) {
        this(listadoMesas, listadoEmpleados, new ArrayList<>());
    }
    public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados, List<Cliente> listadoClientes) {
        this(listadoMesas, listadoEmpleados, listadoClientes, new HashMap<>());
    }
    public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados, List<Cliente> listadoClientes, Map<Tipo, Material> inventario) {
        this.listadoMesas = listadoMesas;
        this.listadoEmpleados = listadoEmpleados;
        this.listadoClientes = listadoClientes;
        this.inventario = inventario;
        this.numMesas += contadorListado(listadoMesas);
        this.numEmpleados += contadorListado(listadoEmpleados);
        this.numClientes += contadorListado(listadoEmpleados);
    }

    public <T> int contadorListado (List<T> listado) {
        int contador = 0;
        for (T elemento : listado) {
            if (elemento != null) {
                contador++;
            }
        }
        return contador;
    }
    public Empleado getEmpleadoDelMes () {
        return this.empleadoDelMes;
    }
    public void setEmpleadoDelMes (Empleado empleadoDelMes) {
        this.empleadoDelMes = empleadoDelMes;
    }
    public String getNombre () {
        return this.nombre;
    }
    public int getNumMesas () {
        return this.numMesas;
    }
    public int getNumEmpleados () {
        return this.numEmpleados;
    }
    public int getNumClientes () {
        return this.numClientes;
    }
    public List<Empleado> getEmpleados () {
        return this.listadoEmpleados;
    }
    public List<Cliente> getClientes () {
        return this.listadoClientes;
    }
    public List<Mesa> getMesas () {
        return this.listadoMesas;
    }
    public Map<Tipo, Material> getInventario () {
        return this.inventario;
    }
    public void contratarEmpleado(Empleado novato) {
        this.listadoEmpleados.add(novato);
    }
    public void afiliarCliente (Cliente nuevoCliente) {
        this.listadoClientes.add(nuevoCliente);
    }
    public void comprarMesa (Mesa nuevaMesa) {
        this.listadoMesas.add(nuevaMesa);
    }
    public void comprarMaterial (Material materialComprado, int cantidad) {
        if (this.inventario.containsKey(materialComprado.getTipo())) {
            materialComprado.comprarMaterial(cantidad);
        }
        else {
            inventario.put(materialComprado.getTipo(), materialComprado);
        }
    }
    //metodo para eliminar un material
    public void botarMaterial(Material materialEliminado,int cantidad) {
    	if (this.inventario.containsKey(materialEliminado.getTipo()) && materialEliminado.getCantidad()>=1) {
    		materialEliminado.botarMaterial(cantidad);
    	}
    	else {
    		operacionInvalida();
    	}
    }
    /*public List<String> consultarInventario() {
    	
    	for(Material material:inventario.values()) {
    		
    	}
    	return inventarioStr;
    }
    public void ordenaPorVencimiento() {
    	
    }*/
 
    public List<Mesa> listadoMesasValidasParaReserva(Reserva reserva) {
        List<Mesa> mesasFiltradas = new ArrayList<>();
        for (Mesa mesa : listadoMesas) {
            if (mesa.suficienteCapacidad1(reserva) && mesa.mesaCompatible(reserva)) {
                mesasFiltradas.add(mesa);
            }
        }
        return mesasFiltradas;
    }
    //metodo para decir si una accion no puede ser ejecutada
    public String operacionInvalida() {
    	return "Operacion Inválida";
    	}
}