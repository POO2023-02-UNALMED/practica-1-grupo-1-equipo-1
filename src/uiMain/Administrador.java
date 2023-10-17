package uiMain;
import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.sql.rowset.spi.SyncResolver;

import baseDatos.Serializador;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Empleado;

public class Administrador implements Menu {

	static Scanner scan = new Scanner(System.in);
	
	static long readLong() {
		return scan.nextLong();
	}
	static String readln() {
		scan.nextLine();
		return scan.nextLine();
	}
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	Gestor gestor=new Gestor();
    	Restaurante restaurante=gestor.getRestaurante();
    	restaurante.setClientes(gestor.getClientes());
    	restaurante.setEmpleados(gestor.getEmpleados());
    	restaurante.setMesas(gestor.getMesas());
    	restaurante.setEmpleadoDelMes(gestor.getEmpleadoDelMes());
    	restaurante.setInventario(gestor.getInventario());
    	
    	
    	
    	ArrayList<Plato> menu=Menu.crearMenu();
    	Material res = new Material(Material.Tipo.RES, 100, 100);
    	Material especias = new Material(Material.Tipo.ESPECIAS, 100, 50);
    	Material aceites = new Material(Material.Tipo.ACEITES, 100, 100);
    	Material pollos = new Material(Material.Tipo.POLLOS, 100, 200);
    	Material vinos = new Material(Material.Tipo.VINOS, 100, 300);
    	Material cebollas = new Material(Material.Tipo.CEBOLLAS, 100, 50);
    	Material champinones = new Material(Material.Tipo.CHAMPINONES, 500, 100);
    	Material ajos = new Material(Material.Tipo.AJOS, 100, 30);
    	Material tomates = new Material(Material.Tipo.TOMATES, 400, 200);
    	Material quesos = new Material(Material.Tipo.QUESOS, 300, 150);
    	Material cerdos = new Material(Material.Tipo.CERDOS, 100, 200);
    	Material atun = new Material(Material.Tipo.ATUN, 100, 250);
    	Material panes = new Material(Material.Tipo.PANES, 200, 50);
    	Material pescados = new Material(Material.Tipo.PESCADOS ,200 ,300 );
    	Material papas = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	Material huevos = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	
        Turno turno1= new Turno(Turno.Tipo.SEMANA, 8, 50000);
        Turno turno2= new Turno(Turno.Tipo.SEMANA, 8, 50000);
        Turno turno3= new Turno(Turno.Tipo.SEMANA, 8, 50000);
        Empleado domiciliario1 = new Empleado("Manolo","domiciliario", restaurante, turno1);;
        Empleado cocinero1 = new Empleado("Juan", "cocinero", restaurante, turno2);
        Empleado mesero1 = new Empleado("Ana", "mesero", restaurante, turno3);
        Material tomate = new Material(Material.Tipo.TOMATES, 10, 200);
        Material cebolla = new Material(Material.Tipo.CEBOLLAS, 5, 300);
        Material huevo = new Material(Material.Tipo.HUEVOS, 5, 400);
        Map<Material, Integer> ingredientes = new HashMap<>();
        ingredientes.put(tomate, 10);
        ingredientes.put(cebolla, 5);
        ingredientes.put(huevo, 3);
        Plato plato1 = new Plato("Huevos pericos", 10, 30, ingredientes);
        // Crear un objeto Pedido
        Pedido pedidoDomicilio = new Pedido("domicilio", cocinero1, domiciliario1, restaurante);
        Pedido pedidoRestaurante = new Pedido(null, "restaurante", cocinero1, mesero1, restaurante);
        // Agregar un plato al pedido
        pedidoDomicilio.agregarPlato(plato1);
        pedidoRestaurante.agregarPlato(plato1);
        // Verificar el pedido
        boolean resultado1 = pedidoDomicilio.verificarPedido(pedidoDomicilio);
        boolean resultado2 = pedidoRestaurante.verificarPedido(pedidoRestaurante);
    	
        // Pedido
        Pedido pedido = new Pedido();
        Plato plato = new Plato();
    	//mostrarMenu(menu);
    	int opcion, opcion2;
		for (Mesa mesa1 : restaurante.getMesas()) {
			mesa1.anadirNumero(mesa1.getNumeroMesa());
		}
    	do {
    		System.out.println("");
    		System.out.println("Bienvenido al Gestor del Restaurante " + restaurante.getNombre()); // agregar el método getNombre
    		System.out.println("");
    		System.out.println("¿Que función deseas usar?");
    		System.out.println("");
    		System.out.println("1. Gestión de Reserva");
    		System.out.println("2. Gestión de Pedidos");
    		System.out.println("3. Gestión de Empleados");
    		System.out.println("4. Gestión de Inventario");
    		System.out.println("5. Gestión Financiera");
			System.out.println("6. Terminar");
			System.out.println("");
    		System.out.print("Escribe el número de la opción que necesitas: ");
    		opcion = (int) readLong();
    		
    		switch(opcion) {
				case 1: do {
				System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Ver la lista de reservas por confirmar");
				System.out.println("2. Ver la lista de reservas ya confirmadas");
    			System.out.println("3. Crear reserva");
    			System.out.println("4. Cancelar reserva");
    			System.out.println("5. Asignar mesas a las reservas");
    			System.out.println("6. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
				opcion2=(int) readLong();
				switch(opcion2) {
					case 1:	System.out.println("\nListado de reservas");
							System.out.println(restaurante.imprimirReservas());
							break;
					case 2: System.out.println("\nListado de reservas");
							System.out.println(restaurante.imprimirReservas2());
							break;
					case 3: System.out.print("Ingrese la cedula del dueño de la reserva: ");
							Long cedulaDuenoReserva = readLong();
							String nombre = "";
							if (restaurante.verificarCliente(cedulaDuenoReserva)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante");
								System.out.print("Ingrese el nombre del cliente: ");
								nombre = readln();
							}
							else {
								nombre = restaurante.obtenerCliente(cedulaDuenoReserva).getNombre();
							}
							System.out.print("Ingrese el numero de Asistentes: ");
							int numAsistentes = (int) readLong();
							System.out.print("Ingrese el dia de la reserva en formato dia-mes-año: ");
							String diaReserva = readln();
							if (Reserva.revisarFecha(diaReserva)) {
								restaurante.asignarReservaCliente(cedulaDuenoReserva, nombre, numAsistentes, diaReserva);
								System.out.println("Reserva creada");
							}
							else {
								System.out.println("La fecha ingresada no es válida, por favor intente con una fecha posterior a hoy");
							}
							break;
					case 4: System.out.print("Ingrese la cedula del dueño de la reserva a cancelar: ");
							Long cedulaDuenoReserva2 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva2)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante");
							}
							else {
								restaurante.obtenerCliente(cedulaDuenoReserva2).setReserva(null);
								System.out.println("\nReserva cancelada\n");
							}
							break;
					case 5:	System.out.print("Ingrese la cédula del dueño de la reserva: ");
							Long cedulaDuenoReserva3 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva3)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante, por lo que no tiene una reserva");
							}
							else {
								System.out.println("\nMesas válidas para la reserva de "+restaurante.obtenerCliente(cedulaDuenoReserva3).getNombre());
								System.out.println(restaurante.mesasQueCumplen(cedulaDuenoReserva3));
								if (!restaurante.mesasQueCumplen(cedulaDuenoReserva3).equals("\nNo hay mesas válidas para esa reserva\n")) {
								System.out.print("Ingrese el numero de la mesa a la cual desea asignar la reserva: ");
								int numeroMesa = (int) readLong();
								System.out.println(restaurante.confirmarReserva(numeroMesa, cedulaDuenoReserva3));
								}
							}
							break;
					case 6: break;
				} } while(opcion2 != 6);
			break;
    		case 2: do{
    			System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Ver lista de pedidos");
    			System.out.println("2. Añadir pedidos");
    			System.out.println("3. Cancelar pedidos");
    			System.out.println("4. Verificar pedidos");
    			System.out.println("5. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
    			
    			opcion=(int) readLong();
    			
    			switch(opcion) {
    			
    			case 1:
	    			System.out.println("\nListado de Pedidos sin Verificar");
	    			if (pedido.getPedidos(restaurante).size()==0)
	    			{
	    				System.out.println("\n-No hay pedidos sin verificar");
	    			}
	    			for(int i = 0; i < pedido.getPedidos(restaurante).size(); i++){
	    				System.out.println((i + 1) + ". " +pedido.getPedidos(restaurante).get(i));
	    			}
	    			
	    			System.out.println("\nListado de Pedidos Verificados");
	    			if(pedido.getPedidosVerificados(restaurante).size()==0){
	    				System.out.println("\n-No hay pedidos verificados\n");
	    			}
	    			for(int i = 0; i < pedido.getPedidosVerificados(restaurante).size(); i++){
	    				System.out.println((i + 1) + ". " +pedido.getPedidosVerificados(restaurante).get(i));
	    			}
	    			System.out.println("\n");
	    			break;
	    			
	    			case 2:
	    				ArrayList<Plato> platosTemp = new ArrayList<Plato>();
	    				// Imprimir el menú
	    				int i1 =0;
	    				for(Plato platof : restaurante.veirificarMenu(menu)){
	    					i1+=1;
	    					System.out.println((i1 + 1) + ". "+platof.detallesPlato());
	    					}
	    				System.out.print("Por favor, introduce los índices de los platos que deseas (separados por comas): ");
	    				String platos = readln();
	    				String[] indices = platos.split(",");
	    				for (String indice : indices) {
	    				    int i = Integer.parseInt(indice.trim()); // convertir el índice a int
	    				    platosTemp.add(menu.get(i-1));
	    				}
	    				
	    				System.out.print("\nIngrese el tipo de pedido indicando consumo(domicilio o restaurante): ");
	    				String tipoPedido = scanner.nextLine();
	    				
		    			if(tipoPedido.equals("domicilio")){
		    				System.out.println("Estos son los empleados registrados\n");
		    				for(int i = 0; i < restaurante.getEmpleados().size(); i++){
		    					System.out.println((i + 1) + ". " + restaurante.getEmpleados().get(i));
		    				}
		    			    System.out.print("Ingrese el Nombre del Cocinero: ");
		    				String nombreCocinero = scanner.nextLine();
		    			    Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero, "cocinero");
		    			    if (cocinero == null) {
		    			        System.out.println("Cocinero no encontrado");
		    			        break;
		    			    }
		    			    System.out.print("Ingrese el Nombre del Domiciliario: ");
		    			    String nombreDomiciliario = scanner.nextLine();
		    			    Empleado domiciliario = restaurante.buscarEmpleado(nombreDomiciliario, "domiciliario");
		    			    if (domiciliario == null) {
		    			        System.out.println("Domiciliario no encontrado");
		    			        break;
		    			    }
		    			    // Se guarda en pedidos ya que en el constructor de pedidos hay im
		    			    new Pedido(tipoPedido, cocinero, domiciliario, platosTemp, restaurante);
		    			    System.out.println("Pedido creado exitosamente");
		    			    
		    			} else if(tipoPedido.equals("restaurante")){
		    				for(int i = 0; i < restaurante.getEmpleados().size(); i++){
		    					System.out.println((i + 1) + ". " + restaurante.getEmpleados().get(i));
		    				}
		    				System.out.println("Estos son los empleados registrados");
		    			    System.out.print("\nIngrese la Mesa: ");
		    			    int numMesa = (int)readLong();
		    			    Mesa mesa = restaurante.encontrarMesa(numMesa);
		    			    if (mesa == null) {System.out.println("\nMesa no encontrada");}
		    			    else if(restaurante.encontrarReserva(numMesa)!=null){
		    			    	Reserva reserva = restaurante.encontrarReserva(numMesa);
		    			    	String nombre = reserva.getDuenoReserva().getNombre();
		    			    	System.out.println("\nHola, esta reserva esta asociada a" + nombre);
			    				for(int i = 0; i < restaurante.getEmpleados().size(); i++){
			    					System.out.println((i + 1) + ". " + restaurante.getEmpleados().get(i));
			    				}
			    			    System.out.print("\nIngrese el Nombre del Cocinero: ");
			    			    String nombreCocinero = readln();
			    			    Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero, "cocinero");
			    			    if (cocinero == null) {
			    			        System.out.println("\nCocinero no encontrado");
			    			        break;
			    			    }
			    			    System.out.print("Ingrese el Nombre del Mesero: ");
			    			    String nombreMesero = scanner.nextLine();
			    			    Empleado mesero = restaurante.buscarEmpleado(nombreMesero, "mesero");
			    			    if (mesero == null) {
			    			        System.out.println("Mesero no encontrado");
			    			        break;
			    			    }
			    			    new Pedido(mesa, tipoPedido, cocinero, mesero, platosTemp, restaurante, reserva);
		    			    	
		    			    }
		    			    else {
		    			    	System.out.println("reserva no asociada");
			    				for(int i = 0; i < restaurante.getEmpleados().size(); i++){
			    					System.out.println((i + 1) + ". " + restaurante.getEmpleados().get(i));
			    				}
			    			    System.out.print("Ingrese el Nombre del Cocinero: ");
			    			    String nombreCocinero = readln();
			    			    Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero, "cocinero");
			    			    if (cocinero == null) {
			    			        System.out.println("\nCocinero no encontrado");
			    			        break;
			    			    }
			    			    System.out.println("\nIngrese el Nombre del Mesero: ");
			    			    String nombreMesero = readln();
			    			    Empleado mesero = restaurante.buscarEmpleado(nombreMesero, "mesero");
			    			    if (mesero == null) {
			    			        System.out.println("Mesero no encontrado");
			    			        break;
			    			    }
			    			    new Pedido(mesa, tipoPedido, cocinero, mesero, platosTemp, restaurante);
		    			    }
		    			}
		    			else{
		    				System.out.println("\nTipo de pedido no encontrado");
		    			}
		    			//Para reinicializar la lista para mandar
		    			platosTemp = new ArrayList<Plato>();
					break;
    			case 3:
    				System.out.println("Estos son los pedidos que puedes cancelar");
        			for(int i = 0; i < pedido.getPedidos(restaurante).size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos(restaurante).get(i));
        			}
        			System.out.print("que pedido deseas cancelar: ");
        			int numPedido = (int)readLong();
        			pedido.getPedidos(restaurante).remove(numPedido-1);
        			System.out.println("Estos son los pedidos actualizados");
        			System.out.println("El pedido numero: "  + numPedido);
           			for(int i = 0; i < pedido.getPedidos(restaurante).size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos(restaurante).get(i));
        			}
    			case 4:
    				System.out.println("\nListado de Pedidos sin Verificar");
        			if (pedido.getPedidos(restaurante).size()==0)
        			{
        				System.out.println("\n-No hay pedidos sin verificar");
        			}else{
        				for(int i = 0; i < pedido.getPedidos(restaurante).size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos(restaurante).get(i));
        			}
        			System.out.println("\nListado de Pedidos Verificados");
            		if (pedido.getPedidosVerificados(restaurante).size()==0)
            		{
            			System.out.println("\n-No hay pedidos verificados");
            		}
            		else{
            			for(int i = 0; i < pedido.getPedidosVerificados(restaurante).size(); i++){
            				System.out.println((i + 1) + ". " + pedido.getPedidosVerificados(restaurante).get(i));
            				}
            			}
        			System.out.print("\nIngrese los pedidos que desee verificar separado por comas: ");
    			    String numsPedido = scanner.nextLine();
    			    String[] nums = numsPedido.split(",");
    			    for(String numStr : nums){
    			    	int num = Integer.parseInt(numStr);
    			    	if(pedido.verificarPedido(pedido.getPedidos(restaurante).get(num-1))) {
    			    		pedido.setVerificado(true);
    			    	System.out.println("\nPedido: " + num +  " verificado exitosamente");
    			    	}
    			    	else{System.out.println("\nHay un problema en el pedido numero: " + num);}
    			    }
            		}
    			case 5: break; // Volver al menú principal
    			}
    		}while(opcion!=5); break;
    		case 3:
    			
    			break;
			//funcionalidad Sebas
    		case 4: 
    			int opcionInv;
    			int opcionInv1;
    			int opcionInv2;
    			do {
    			System.out.println("-------------------------------------------------------");
    			System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Consultar Inventario");
    			System.out.println("2. Comprar Materiales");
    			System.out.println("3. Desechar Materiales");
    			System.out.println("4. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
    			opcionInv=(int) readLong();
    			switch(opcionInv) {
    			case 1:System.out.println("-------------------------------------------------------"); 
    				mostrarIngredientes(restaurante);
    				System.out.println("-------------------------------------------------------");
					mostrarMesas(restaurante);
    				break;
    			case 2:
    				
    				do {
    					System.out.println("-------------------------------------------------------");
    					System.out.println("1. ¿Que ingrediente desea comprar?");
    					System.out.println("2. ¿Que material desea comprar?");
    					System.out.println("3. ¿Que mesa deseas comprar?");
    					System.out.println("4. Volver al menú de gestión de inventario");
    					opcionInv1=(int)readLong();
    					switch(opcionInv1) {
    					case 1: 
    						System.out.println("-------------------------------------------------------");
    						mostrarIngredientes(restaurante);
    						System.out.print("Ingrese el ingrediente a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						String ingrediente=scan.next();
    						Material.Tipo ingredienteEnum=Material.Tipo.valueOf(ingrediente);
    						System.out.print("Ingrese la cantidad a comprar: ");
    						System.out.println("\n-------------------------------------------------------");	
    						int cantidad=(int) readLong();
    						System.out.print("Ingrese el precio unitario de dicho ingrediente: ");
    						System.out.println("\n------------------------------------------------------");
    						int precio=(int) readLong();
    						System.out.print("Ingrese la fecha de vencimiento del ingrediente en formato dia-mes-año: ");
    						System.out.println("\n-------------------------------------------------------");
    						String vence = readln();
							if (Reserva.revisarFecha(vence)) {
								restaurante.comprarMaterial(ingredienteEnum,cantidad,precio,vence);
								System.out.println("Se han comprado "+cantidad+" "+ingredienteEnum+" al precio de "+precio+" que vencen el "+vence);
							}
							else {
								System.out.println("La fecha ingresada no es válida, por favor intente con una fecha posterior a hoy");
							}
							break;
    				
    				
    					case 2: 
    						System.out.println("-------------------------------------------------------");
    						mostrarIngredientes(restaurante);
    						System.out.println("-------------------------------------------------------");
    						System.out.print("Ingrese el material a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						String material=scan.next();
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						System.out.print("Ingrese la cantidad a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						int cantidad2=(int) readLong();
    						System.out.print("Ingrese el precio de dicho material: ");
    						System.out.println("\n-------------------------------------------------------");
    						int precio2=(int) readLong();
    						restaurante.comprarMaterial(materialEnum,cantidad2,precio2);
    						System.out.println("Se han comprado "+cantidad2+" "+materialEnum+" al precio de "+precio2);
    						break;
    					case 3:
    						mostrarMesas(restaurante);
    						System.out.print("Escriba el numero de la nueva mesa: ");
    						System.out.println("\n-------------------------------------------------------");
    						int numMesa=(int) readLong();
    						System.out.print("Escriba la capacidad de la nueva mesa: ");
    						System.out.println("\n-------------------------------------------------------");
    						int capacidad=(int) readLong();
    						restaurante.comprarMesa(new Mesa(capacidad,numMesa));
    						System.out.println("La mesa numero "+numMesa+" con capadidad de "+capacidad+" personas ha sido registrada con éxito");
    						break;
    					case 4:
    						break;
    					}
    				}while(opcionInv1!=4); break;
    			case 3:
    				
					do {
    					System.out.println("-------------------------------------------------------");
    					System.out.println("1. ¿Que ingrediente vas a desechar?");
    					System.out.println("2. ¿Que material vas a desechar?");
    					System.out.println("3. ¿Que mesa vas a desechar?");
    					System.out.println("4. Volver al menú de gestión de inventario");
    					opcionInv2=(int)readLong();
    					switch(opcionInv2) {
    					case 1:  mostrarIngredientes(restaurante);
    						System.out.print("Ingrese el ingrediente a desechar: ");
    						String ingrediente =scan.next();
    						System.out.print("Ingrese la cantidad a desechar: ");
    						int cantidad=(int) readLong();
    						Material.Tipo ingredienteEnum=Material.Tipo.valueOf(ingrediente);
    						restaurante.botarMaterial(ingredienteEnum,cantidad);
    						System.out.println("Se han eliminado "+cantidad+" "+ingredienteEnum);
    						break;
    					case 2: mostrarIngredientes(restaurante);
    						System.out.print("Ingrese el material a desechar: ");
    						String material= scan.next();
    						System.out.print("Ingrese la cantidad a desechar: ");
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						int cantidad2=(int) readLong();
    						restaurante.botarMaterial(materialEnum,cantidad2);
    						System.out.println("Se han eliminado "+cantidad2+" "+materialEnum);
    						break;
    					case 3:
    						mostrarMesas(restaurante);
    						System.out.print("Escriba el numero de mesa a desechar: ");
    						System.out.println("\n-------------------------------------------------------");
    						int numMesa=(int) readLong();
    						restaurante.eliminarMesa(numMesa);
    						System.out.println("La mesa numero "+numMesa+" ha sido eliminada con éxito");
    						break;
    					case 4:
    						break;
    					}
    				} while(opcionInv2!=4); break;
    			case 4:
    				break;
    			}
    		}while(opcionInv!=4);break;
    			
    			
  //funcionalidad financiera
    		
  //funcionalidad financiera
    		
    		case 5:
    			do{
        			System.out.println("¿Que deseas hacer?");
        			System.out.println("1. Consultar el Presupuesto Total de Restaurante");
        			System.out.println("2. Consultar los Gastos del Restaurante");
        			System.out.println("3. Consultar los Perdidas del Restaurante");
        			System.out.println("4. Consultar las Ganancias del Restaurante");
        			System.out.println("5. Calcular la liquidacion de un Empleado");
        			System.out.print("Escribe el número de la opción que necesitas: ");
        			
        			opcion=(int) readLong();
        			
        			switch(opcion) {
        			
        			case 1:
        				//double presupuesto = Financia.getPresupuesto();
    	    			//System.out.println("\nEl presupuesto Total del Restaurante es: " + presupuesto);
    			
    			
    			
    			break;
    		case 6: salirDelSistema(gestor);
			break;
    		}
    	} while(opcion!=6);
    		
    }
    public static void mostrarMesas(Restaurante restaurante) {
    	System.out.println("Mesas del restaurante: ");
    	for (Mesa mesa:restaurante.getMesas()) {
    		System.out.println("Mesa: " + mesa.getNumeroMesa()+" con Capacidad de: "+mesa.getCapacidad()+" personas");
    		System.out.println("-------------------------------------------------------");
    	}
    }
    
    public static void mostrarIngredientes(Restaurante restaurante) {   	
    	if (restaurante.getInventario().size()==0) {
    		System.out.println("No hay materiales en el inventario");
    	}
    	for (Material material: restaurante.getInventario().values()) {
    		if(material.getFechaVencimiento()!=null) {
    			System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nFecha de Vencimiento: "+material.getFechaVencimiento()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    			System.out.println("-------------------------------------------------------");
    		}else {
    			System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nFecha de Vencimiento: "+material.fechaMaterial()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    			System.out.println("-------------------------------------------------------");
    		}
    	}
    }
    
    public static void mostrarMenu(ArrayList<Plato> menu) {
    	short cont=1;
    	for (Plato plato:menu) {
    		System.out.println(cont+". "+plato.detallesPlato());
    		cont++;
    	}
    }
    
    private static void salirDelSistema(Gestor gestor) {
    	System.out.println("Vuelva pronto");
    	Serializador.serializar(gestor);
    	System.exit(0);
    }
}
