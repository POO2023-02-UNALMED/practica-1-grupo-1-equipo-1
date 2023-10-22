package gestorAplicacion.Cosas;
import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.Material.*;
import java.io.Serializable;
import java.time.LocalDate;
import gestorAplicacion.Personas.*;
import baseDatos.Deserializador;
public class Restaurante implements Serializable {
    private static final long serialVersionUID=1L;
	private final String NOMBRE = "Le Quasó";
    private Empleado empleadoDelMes;
    private int numMesas;
    private int numEmpleados;
    private int numClientes;
    private List<Empleado> listadoEmpleados=new ArrayList<>();
    private List<Cliente> listadoClientes=new ArrayList<>();
    private List<Mesa> listadoMesas=new ArrayList<>();
    private List<Pedido> pedidos= new ArrayList<>();
    private Map<Tipo, Material> inventario=new HashMap<>();
    
    //Constructores, que se invocan uno a otro, dependiendo si los restaurantes se inicializan con listas o no
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

    //Cuenta el tamaño de una lista
    public <T> int contadorListado (List<T> listado) {
        int contador = 0;
        for (T elemento : listado) {
            if (elemento != null) {
                contador++;
            }
        }
        return contador;
    }

    //Metodos getter
    public String getNombre () {
        return this.NOMBRE;
    }
    public Empleado getEmpleadoDelMes () {
        return this.empleadoDelMes;
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

    //Metodos setter
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
    public void setEmpleados(List<Empleado> empleados) {
    	this.listadoEmpleados=empleados;
    }
    public void setClientes(List<Cliente> clientes) {
    	this.listadoClientes=clientes;
    }
    public void setMesas(List<Mesa> mesas) {
    	this.listadoMesas=mesas;
    }
    public void setInventario(Map<Tipo,Material> inv) {
    	this.inventario=inv;
    }
    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }
    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }
    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    //Metodos funcionalidades
    //busca el objeto empleado por el nombre
    public Empleado buscarEmpleado(String nombre, String puesto){
    	for(Empleado empleado : listadoEmpleados){
    		if((empleado.getNombre()).equals(nombre) && (empleado.getPuesto()).equals(puesto)){
    			return empleado;
    		}
    	}
		return  null;
    }
    //añade un empleado a la lista de empleados
    public void contratarEmpleado(Empleado novato) {
        this.listadoEmpleados.add(novato);
        int a = this.getNumEmpleados();
        this.setNumEmpleados(a+1);
    }
    //Añade el cliente a la lista de clientes
    public void afiliarCliente (Cliente nuevoCliente) {
        this.listadoClientes.add(nuevoCliente);
        int a = this.getNumClientes();
        this.setNumClientes(a+1);
    }
    //añade la mesa a la lista de mesas
    public void comprarMesa (Mesa nuevaMesa) {
        this.listadoMesas.add(nuevaMesa);
        int a = this.getNumMesas();
        this.setNumMesas(a+1);
    }
    //elimina la mesa del listado de mesas en base al número
    public void eliminarMesa(int numeroMesa) {
    	for(Mesa mesa:listadoMesas) {
    		if(mesa.getNumeroMesa()==numeroMesa) {
    			listadoMesas.remove(mesa);
    			return;
    		}
    	}
    }
    //Metodos gestion de inventario


    public void comprarMaterial (Material.Tipo tipo, int cantidad, int precio, String fecha) {

        if (this.inventario.containsKey(tipo)) {
        	Material materialComprado = this.inventario.get(tipo);
        	LocalDate vence = Reserva.deStringaFecha(fecha);
            materialComprado.comprarMaterial(cantidad);
            materialComprado.cambiarPrecioUnitario(precio);
            materialComprado.cambiarFechaVencimiento(vence);
            
            
        }
        else {
        	LocalDate vence = Reserva.deStringaFecha(fecha);
        	Material nuevoMaterial=new Material(tipo,cantidad,precio,vence);
            inventario.put(tipo, nuevoMaterial);
            nuevoMaterial.cambiarPrecioUnitario(precio);
            nuevoMaterial.cambiarFechaVencimiento(vence);
        }
    }
    public void comprarMaterial (Material.Tipo tipo, int cantidad, int precio) {
        if (this.inventario.containsKey(tipo)) {
        	Material materialComprado = this.inventario.get(tipo);
            materialComprado.comprarMaterial(cantidad);
            materialComprado.cambiarPrecioUnitario(precio);
        }
        else {
        	Material nuevoMaterial=new Material(tipo,cantidad,precio);
            inventario.put(tipo, nuevoMaterial);
            nuevoMaterial.cambiarPrecioUnitario(precio);
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
    
    //metodo para decir si una accion no puede ser ejecutada
    public String operacionInvalida() {
    	return "Operacion Inválida";
    }

    public List<Mesa> mesasDisponibles() {
        LocalDate fechaActual = LocalDate.now();
        List<Mesa> listaDeMesasNo = new ArrayList<>();
        List<Mesa> listadoTotal = getMesas();
        for (Mesa mesa1 : getMesas()) {
            for (Reserva reserva1 : mesa1.getReservas()) {
                if (reserva1.getDiaReserva().equals(fechaActual)) {
                    listaDeMesasNo.add(mesa1);
                    break;
                }
            }
        }
        for (Mesa mesa2 : listaDeMesasNo) {
            listadoTotal.remove(mesa2);
        }
        return listadoTotal;
    }

    // Gestion de Reservas
    //retorna las mesas que son válidas (capacidad y fecha disponible) para la reserva
    public List<Mesa> listadoMesasValidasParaReserva(Reserva reserva) {
        List<Mesa> mesasFiltradas = new ArrayList<>();
        for (Mesa mesa : listadoMesas) {
            if (mesa.suficienteCapacidad(reserva) && mesa.mesaCompatible(reserva)) {
                mesasFiltradas.add(mesa);
            }
        }
        return mesasFiltradas;
    }
    //encuentra una mesa por su numero
    public Mesa encontrarMesa(int numMesa) {
        Long b = (long) numMesa;
        for (Mesa mesa1 : getMesas()) {
            Long a = (long) mesa1.getNumeroMesa();
            if (b.equals(a)) {
                return mesa1;
            }
        }
        return null;
    }
    
    public List<Pedido> getPedidos(){
    	return pedidos;
    }
    //Imprime las reservas por confirmar (sin mesa asignada)
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
            r = "\nNo se han hecho reservas\n";
        }
        return r;
    }
    //Imprime las reservas confirmadas (con mesa asignada)
    public String imprimirReservas2() {
        String r = "";
        List<Reserva> listado = new ArrayList<>();
        for (Mesa mesa1 : getMesas()) {
            listado.addAll(mesa1.getReservas());
        }
        for (Reserva reserva1 : listado) {
            if (reserva1 != null) {
                r += "\n"+reserva1.resumenReserva()+"\n\n+++++++++++++++++++++++++\n";
            }
        }
        if (r.equals("")) {
            r = "\nNo se han confirmado reservas\n";
        }
        return r;
    }

    public void borrarReservasViejas() {
        LocalDate fechaActual = LocalDate.now();
        List<Reserva> nuevaLista = new ArrayList<>();
        for (Mesa mesa1 : getMesas()) {
            for (Reserva reserva1 : mesa1.getReservas()) {
                if (!reserva1.getDiaReserva().isBefore(fechaActual)) {
                    nuevaLista.add(reserva1);
                }
            }
            mesa1.setReservas(nuevaLista);
        }
    }

    //dice si el cliente si está guardado en la lista de clientes
    public boolean verificarCliente(Long cedula) {
        for (Cliente cliente1 : getClientes()) {
            if (cedula.equals(cliente1.getCedula())) {
                return false;
            }
        }
        return true;
    }
    //devuelve el objeto cliente en base a su cédula
    public Cliente obtenerCliente(Long cedula) {
        for (Cliente cliente1 : getClientes()) {
            if (cedula.equals(cliente1.getCedula())) {
                return cliente1;
            }
        }
        return null;
    }
    //obtiene el cliente en base a la cédula llamando al método obtenerCliente, y le asigna la reserva
    public void asignarReservaCliente(Long cedula, String nombre, int numAsistentes, String diaReserva) {
        if (verificarCliente(cedula)) {
            Cliente c1 = new Cliente(nombre, cedula);
            afiliarCliente(c1);
        }
        Cliente c1 = obtenerCliente(cedula);
        LocalDate diaReserva2 = Reserva.deStringaFecha(diaReserva);
        c1.setReserva(new Reserva(c1, numAsistentes, diaReserva2));
    }
    //retorna el listado de mesas que cumplen para la reserva que tenga asignada ek cliente
    public String mesasQueCumplen(Long cedulaDuenoReserva) {
        String t = "";
        Cliente c1 = obtenerCliente(cedulaDuenoReserva);
        Reserva r1 = c1.getReserva();
        List<Mesa> listado = this.listadoMesasValidasParaReserva(r1);
        for (Mesa mesa1 : listado) {
                t += "\n"+mesa1.resumenMesa()+"\n\n+++++++++++++++++++++++++\n";
        }
        if (t.equals("")) {
            t = "\nNo hay mesas válidas para esa reserva\n";
        }
        return t;
    }

    //Si la mesa seleccionada cumple, le asigna la reserva a la mesa
    public String confirmarReserva(int numMesa, Long cedula) {
        Cliente c1 = obtenerCliente(cedula);
        Reserva r1 = c1.getReserva();
        if (Mesa.verificarNumero(numMesa)) {
            Mesa mesa1 = encontrarMesa(numMesa);
            if (mesa1.suficienteCapacidad(r1)) {
                mesa1.reservarMesa(r1);
                c1.setReserva(null);
                return "Reserva asignada a la mesa #"+numMesa;
            }
            else {
                return "La mesa seleccionada no tiene la capacidad suficiente, vuelva a intentarlo";
            }
        }
        else {
            return "No existe una mesa con ese número, por favor vuelva a intentarlo";
        }
    }
    /*public String confirmarReserva(int numMesa, Long cedula) {
        Cliente c1 = obtenerCliente(cedula);
        Reserva r1 = c1.getReserva();
        List<Mesa> mesas=listadoMesas;
        for(Mesa mesa:mesas) {
        	if (numMesa==mesa.getNumeroMesa()) {
                Mesa mesa1 = encontrarMesa(numMesa);
                if (mesa1.suficienteCapacidad(r1)) {
                    mesa1.reservarMesa(r1);
                    c1.setReserva(null);
                    return "Reserva asignada a la mesa #"+numMesa;
                }
                else {
                    return "La mesa seleccionada no tiene la capacidad suficiente, vuelva a intentarlo";
                }
            }
            else {
                return "No existe una mesa con ese número, por favor vuelva a intentarlo";
            }
        }
    }*/
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public  ArrayList<Plato>  veirificarMenu(ArrayList<Plato> menu) {
		ArrayList<Plato> menuVerificado= new ArrayList<>();
		for(Plato plato: menu){
			if(plato.verificarInsumos(plato)){
				menuVerificado.add(plato);
			}
		}
		return menuVerificado;
	}
	
	
	
	public Reserva encontrarReserva(int numMesa, String nombre) {
		Mesa mesa = encontrarMesa(numMesa);
		for(Reserva reserva : mesa.getReservas()){
			if((reserva.getDuenoReserva().getNombre()).equals(nombre)){
				return reserva;
			}
		}
		return null;
}
	public List<Empleado> clasificarEmpleados( List<Empleado> empleados, String tipo){
		List<Empleado> empleadosClasificados = new ArrayList<>();
		for(Empleado empleado : empleados){
			if(empleado.getPuesto().equals(tipo)){
				empleadosClasificados.add(empleado);
			}
		}
		return empleadosClasificados;
	}
	public Mesa buscarMesaDisponible() {
		LocalDate fechaActual = LocalDate.now();
		for(Mesa mesa : listadoMesas){
			for(Reserva reserva : mesa.getReservas()){
				if(!reserva.getDiaReserva().equals(fechaActual)){
					return mesa;
				}
			}
		}
		return null;
	}
	
	public List<Empleado> verificarCocineros(List<Empleado> empleados, ArrayList<Plato> platos){
	    List<Empleado> cocineros = clasificarEmpleados(empleados, "cocinero");
	    List<Empleado> cocinerosVerificados = new ArrayList<>();
	    int tiempoPreparacion = platos.get(0).getTiempoTotal(platos);
	    for(Empleado empleado : cocineros){
	        if(empleado.verificarTiempo(empleado, tiempoPreparacion)){
	            cocinerosVerificados.add(empleado);
	        }
	    }
	    return cocinerosVerificados;
	}
	
	public List<Empleado> verificarDomiciliarios(List<Empleado> empleados) {
	    List<Empleado> domiciliarios = clasificarEmpleados(empleados, "domiciliario");
	    List<Empleado> domiciliariosVerificados = new ArrayList<>();
	    for(Empleado empleado : domiciliarios){
	        if(empleado.verificarTiempo(empleado)){
	            domiciliariosVerificados.add(empleado);
	        }
	    }
	    return domiciliariosVerificados;
	}


	
 	public List<Pedido> getPedidosVerificados() {
		List<Pedido> pedidosVerificados = new ArrayList<>();
		for(Pedido pedido : getPedidos()){
			if(pedido.isVerificado()){
				pedidosVerificados.add(pedido);
			}
		}
		return pedidosVerificados;
	}
 	
	public List<Pedido> getPedidosSinVerificar(){
		List<Pedido> pedidosSinVerificar = new ArrayList<>();
		for(Pedido pedido : getPedidos()){
			if(pedido.isVerificado()==false){
				pedidosSinVerificar.add(pedido);
			}
		}
		return pedidosSinVerificar;
	}
	
	public String imprimirPedidosVerificados(){
		String pedidosVerificados ="";
		for(int i = 0; i < getPedidosVerificados().size(); i++){
			pedidosVerificados+=(i + 1) + ". " + getPedidosVerificados().get(i);
			pedidosVerificados+="\n-------------------------------------------------------\n";
			}
		return pedidosVerificados;
	}
	public String imprimirPedidosSinVerificar(){
	    String pedidosSinVerificar ="";
	    for(int i = 0; i < getPedidosSinVerificar().size(); i++){
	        pedidosSinVerificar+=(i + 1) + ". " + getPedidosSinVerificar().get(i);
	        pedidosSinVerificar+="\n-------------------------------------------------------\n";
	    }
	    return pedidosSinVerificar;
	}


	public void actualizarInsumos(Pedido pedido) {
	    for (Plato plato : pedido.getPlatos()) {
	        for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
	            Material material = entrada.getKey();
	            int cantidadUtilizada = entrada.getValue();
	            material.restarCantidad(cantidadUtilizada);
	        }
	    }
	}

	
}