package gestorAplicacion.Cosas;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.Material.*;
import java.io.Serializable;
import java.time.LocalDate;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class Restaurante {
    private final String nombre = "Le Quasó";
    private Empleado empleadoDelMes;
    private int numMesas;
    private int numEmpleados;
    private int numClientes;
    private List<Empleado> listadoEmpleados;
    private List<Cliente> listadoClientes;
    private List<Mesa> listadoMesas;
    private Map<Tipo, Material> inventario;
    
    


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
    public void setEmpleadoDelMes() {
        Empleado empleadoDelMes = null;
        int puntuacionMaxima = 0;

        // Encontrar al empleado con mayor puntuación
        for (Empleado empleado : listadoEmpleados) {
            if (empleado.getPuntuacion() > puntuacionMaxima) {
                puntuacionMaxima = empleado.getPuntuacion();
                empleadoDelMes = empleado;
            }
        }

        //Establecer al empleado del mes
        setEmpleadoDelMes(empleadoDelMes);
    }
    /*public double despedirEmpleado(Empleado empleado) {
        // Verificar si el empleado está en la lista de empleados
    	double liquidacion = empleado.getSalario();
    	if (listadoEmpleados.contains(empleado)) {
            // Calcular la liquidación     
            // Eliminar al empleado de la lista
            listadoEmpleados.remove(empleado);
        }
    	return liquidacion;
        
    }*/
    /*public void contratarEmpleado(String puesto, Turno.Tipo tipoTurno) {
        Empleado empleadoDisponible = null;

        // Buscar un empleado disponible en la lista de empleados
        for (Empleado empleado : listadoEmpleados) {
            if (empleado.getRestaurante() == null) {
                empleadoDisponible = empleado;
                break;
            }
        }

        if (empleadoDisponible != null) {
            // Configurar el empleado contratado con el puesto y turno
            empleadoDisponible.setPuesto(puesto);
            Turno turno = null;
            switch (tipoTurno) {
              case SEMANA:
                turno = new Turno(Turno.Tipo.SEMANA, int horas, double salario);  
                break;
              case SABADO:
                turno = new Turno(Turno.Tipo.SABADO, int horas, double salario);  
                break;
              case DOMINGO:
                turno = new Turno(Turno.Tipo.int horas, double salario);
                break;
            }

            // Asignar el turno al empleado
            empleadoDisponible.setTurno(turno);

            // Asignar el restaurante al empleado
            empleadoDisponible.setRestaurante(this);
        }
    }*/
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
    /*public void contratarEmpleado(String nombre, String genero, int edad, String puesto, Turno.Tipo tipoTurno) {
        // Crear un nuevo objeto Turno en función del tipo de turno seleccionado
       //Agregar valores que vayamos a determinar en los turnos y salarios
        Turno turno = null;
        switch (tipoTurno) {
            case SEMANA:
                turno = new Turno(Turno.Tipo.SEMANA, int horas, double Turno.getSalario());  
                break;
            case SABADO:
                turno = new Turno(Turno.Tipo.SABADO, int horas, double salario);  
                break;
            case DOMINGO:
                turno = new Turno(Turno.Tipo.DOMINGO, int horas, double salario);
                break;
            default:
                break;
        }

        // Crear un nuevo empleado y agregarlo a la lista de empleados del restaurante
        Empleado nuevoEmpleado = new Empleado(nombre, genero, edad, puesto, this, turno);
        this.contratarEmpleado(nuevoEmpleado);
    }
    
    public void contratarEmpleado1(String puesto, Turno.Tipo tipoTurno) {
        Empleado empleadoDisponible = null;
    }*/
    
    public void afiliarCliente (Cliente nuevoCliente) {
        this.listadoClientes.add(nuevoCliente);
    }
    public void comprarMesa (Mesa nuevaMesa) {
        this.listadoMesas.add(nuevaMesa);
    }
    public void eliminarMesa(int numeroMesa) {
    	for(Mesa mesa:listadoMesas) {
    		if(mesa.getNumeroMesa()==numeroMesa) {
    			listadoMesas.remove(mesa);
    			return;
    		}
    	}
    }
    public void comprarMaterial (Material.Tipo tipo, int cantidad) {
        if (this.inventario.containsKey(tipo)) {
        	Material materialComprado = this.inventario.get(tipo);
            materialComprado.comprarMaterial(cantidad);
        }
        else {
        	Material nuevoMaterial=new Material(tipo,cantidad,0);
            inventario.put(tipo, nuevoMaterial);
        }
    }

    public void botarMaterial(Material.Tipo tipo,int cantidad) {
    	if (this.inventario.containsKey(tipo)) {
    		Material materialEliminado=this.inventario.get(tipo);
    		if (materialEliminado.getCantidad()>=cantidad) {
    			materialEliminado.botarMaterial(cantidad);
    		}else {
    			operacionInvalida();
    		}
    	}
    	else {
    		operacionInvalida();
    	}
    }
    public double calcularValorInventario() {
    	double valorTotal=0;
    	for (Material material: inventario.values()) {
    		valorTotal+=material.getCantidad()*material.getPrecioUnitario();
    	}
    	return valorTotal;
    }
    
 
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
    public String imprimirReservas() {
        String r = "";
        List<Reserva> listado = new ArrayList<>();
        for (Cliente cliente1 : getClientes()) {
            listado.add(cliente1.getReserva());
        }
        for (Reserva reserva1 : listado) {
            if (reserva1 != null) {
                r += "\n"+reserva1.resumenReserva()+"\n\n+++++++++++++++++++++++++\n";
            }
        }
        if (r.equals("")) {
            r = "\nNo se han echo reservas\n";
        }
        return r;
    }
    public boolean verificarCliente(Long cedula) {
        for (Cliente cliente1 : getClientes()) {
            if (cedula.equals(cliente1.getCedula())) {
                return false;
            }
        }
        return true;
    }
    public Cliente getCliente(Long cedula) {
        for (Cliente cliente1 : getClientes()) {
            if (cedula.equals(cliente1.getCedula())) {
                return cliente1;
            }
        }
        return null;
    }
    public void f1(Long cedula, String nombre, int numAsistentes, String diaReserva) {
        if (verificarCliente(cedula)) {
            Cliente c1 = new Cliente(nombre, cedula);
            afiliarCliente(c1);
        }
        Cliente c1 = getCliente(cedula);
        LocalDate diaReserva2 = Reserva.deStringaFecha(diaReserva);
        c1.setReserva(new Reserva(c1, numAsistentes, diaReserva2));
    }
}