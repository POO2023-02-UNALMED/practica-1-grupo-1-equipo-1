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
import gestorAplicacion.Personas.Cliente;
import gestorAplicacion.Personas.Empleado;

public class Administrador {
	
	static Scanner scan=new Scanner(System.in);
	static long readLong() {
		return scan.nextLong();
	}
	static String readln() {
		scan.nextLine();
		return scan.nextLine();
	}
    public static void main(String[] args) {
    	
    	Gestor gestor=new Gestor();
    	Restaurante restaurante=new Restaurante();
    	restaurante.setClientes(gestor.getClientes());
    	restaurante.setEmpleados(gestor.getEmpleados());
    	restaurante.setMesas(gestor.getMesas());
    	restaurante.setEmpleadoDelMes(gestor.getEmpleadoDelMes());
    	Pedido pedido = new Pedido();
		
    	int opcion, opcion2;
        Material tomate = new Material(Material.Tipo.TOMATES, 10, 200);
        Material cebolla = new Material(Material.Tipo.CEBOLLAS, 5, 300);
        Material huevo = new Material(Material.Tipo.HUEVOS, 5, 400);
        Map<Material, Integer> ingredientes = new HashMap<>();
        ingredientes.put(tomate, 10);
        ingredientes.put(cebolla, 5);
        ingredientes.put(huevo, 3);
		Plato plato1 = new Plato("Huevos pericos", 10, 30, ingredientes);
		ArrayList<Plato> menu = new ArrayList<Plato>(Arrays.asList(plato1));
    	do {
    		
    		System.out.println("Bienvenido al Gestor del Restaurante " + restaurante.getNombre()); // agregar el método getNombre
    		System.out.println("¿Que función deseas usar?");
    		System.out.println("1. Gestión de Reserva");
    		System.out.println("2. Gestión de Pedidos");
    		System.out.println("3. Gestión de Empleados");
    		System.out.println("4. Gestión de Inventario");
    		System.out.println("5. Gestión Financiera");
			System.out.println("6. Terminar");
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
								nombre = restaurante.getCliente(cedulaDuenoReserva).getNombre();
							}
							System.out.print("Ingrese el numero de Asistentes: ");
							int numAsistentes = (int) readLong();
							System.out.print("Ingrese el dia de la reserva en formato dia-mes-año: ");
							String diaReserva = readln();
							restaurante.f1(cedulaDuenoReserva, nombre, numAsistentes, diaReserva);
							System.out.println("Reserva creada");
							break;
					case 4: System.out.print("Ingrese la cedula del dueño de la reserva a cancelar: ");
							Long cedulaDuenoReserva2 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva2)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante");
							}
							else {
								restaurante.getCliente(cedulaDuenoReserva2).setReserva(null);
								System.out.println("\nReserva cancelada\n");
							}
							break;
					case 5:	System.out.print("Ingrese la cédula del dueño de la reserva: ");
							Long cedulaDuenoReserva3 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva3)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante, por lo que no tiene una reserva");
							}
							else {
								System.out.println("\nMesas válidas para la reserva de "+restaurante.getCliente(cedulaDuenoReserva3).getNombre());
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
    			
    			case 1: System.out.println("\nListado de Pedidos sin Verificar");
    			for(int i = 0; i < pedido.getPedidos().size(); i++){
    				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
    			}
    			
    			System.out.println("\nListado de Pedidos Verificados");
    			for(int i = 0; i < pedido.getPedidos().size(); i++){
    				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
    			}
    			
    			case 2:
    				ArrayList<Plato> platosTemp = new ArrayList<Plato>();
    				// Imprimir el menú
    				for (int i = 0; i < menu.size(); i++) {
    				    System.out.println((i + 1) + ". " + menu.get(i).getNombre());
    				}
    				
    				System.out.println("Por favor, introduce los índices de los platos que deseas (separados por comas):");
    				String platos = readln();
    				String[] indices = platos.split(",");
    				for (String indice : indices) {
    				    int i = Integer.parseInt(indice.trim()); // convertir el índice a int
    				    platosTemp.add(menu.get(i-1));
    				}
    				
    				System.out.println("Ingrese el tipo de pedido indicando consumo(domicilio o restaurante)");
    				String tipoPedido = readln();
    				
	    			if(tipoPedido.equals("domicilio")){
	    			    System.out.println("Ingrese el Cocinero");
	    			    String nombreCocinero = readln();
	    			    Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero);
	    			    if (cocinero == null) {
	    			        System.out.println("Cocinero no encontrado");
	    			        break;
	    			    }
	    			    System.out.println("Ingrese el Domiciliario");
	    			    String nombreDomiciliario = readln();
	    			    Empleado domiciliario = restaurante.buscarEmpleado(nombreDomiciliario);
	    			    if (domiciliario == null) {
	    			        System.out.println("Domiciliario no encontrado");
	    			        break;
	    			    }
	    			    // Se guarda en pedidos ya que en el constructor de pedidos hay im
	    			    new Pedido(tipoPedido, cocinero, domiciliario, platosTemp);
	    			}
	    			
	    			else {
	    			    System.out.println("Ingrese la Mesa");
	    			    int numMesa = (int)readLong();
	    			    Mesa mesa = restaurante.buscarMesa(numMesa);
	    			    if (mesa == null) {
	    			        System.out.println("Mesa no encontrada");
	    			        break;
	    			    }
	    			    System.out.println("Ingrese el Cocinero");
	    			    String nombreCocinero = readln();
	    			    Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero);
	    			    if (cocinero == null) {
	    			        System.out.println("Cocinero no encontrado");
	    			        break;
	    			    }
	    			    System.out.println("Ingrese el Mesero");
	    			    String nombreMesero = readln();
	    			    Empleado mesero = restaurante.buscarEmpleado(nombreMesero);
	    			    if (mesero == null) {
	    			        System.out.println("Mesero no encontrado");
	    			        break;
	    			    }
	    			    new Pedido(mesa, tipoPedido, cocinero, mesero, platosTemp);
	    			}
	    			//Para reinicializar la lista para mandar
	    			platosTemp = new ArrayList<Plato>();
				break;
    			case 3:
    				System.out.println("Estos son los pedidos que puedes canclear");
        			for(int i = 0; i < pedido.getPedidos().size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
        			}
        			System.out.println("que pedido deseas cancelar");
        			int numPedido = (int)readLong();
        			pedido.getPedidos().remove(-1);
        			System.out.println("Estos son los pedidos actualizados");
        			System.out.println("El pedido numero: "  + numPedido);
           			for(int i = 0; i < pedido.getPedidos().size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
        			}
    			case 4:
    				System.out.println("\nListado de Pedidos sin Verificar");
        			for(int i = 0; i < pedido.getPedidos().size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
        			}
        			System.out.println("\nListado de Pedidos Verificados");
        			for(int i = 0; i < pedido.getPedidos().size(); i++){
        				System.out.println((i + 1) + ". " + pedido.getPedidos().get(i));
        			}
        			System.out.println("\nIngrese los pedidos que desee verificar separado por comas");
    			    String numsPedido = readln();
    			    String[] nums = numsPedido.split(",");
    			    for(String numStr : nums){
    			    	int num = Integer.parseInt(numStr);
    			    	if(pedido.verificarPedido(pedido.getPedidos().get(num-1))) {
    			    	System.out.println("\nPedido: " + num +  "verificado exitosamente");
    			    	}
    			    	else{
    			    		System.out.println("\nHay un problema en el pedido numero: " + num);
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
    						String fechaInput=scan.nextLine();
    						DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    						LocalDate fecha=LocalDate.parse(fechaInput,formato);
    						restaurante.comprarMaterial(ingredienteEnum,cantidad,precio,fecha);
    						System.out.println("Se han comprado "+cantidad+" "+ingredienteEnum+" al precio de "+precio+" que vencen el "+fecha);
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
    			
    			
  
    		case 5://break;
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
    /*public static void consultarInventario(Restaurante restaurante) {
    	List<Material> inventarioOrdenado=new ArrayList<>(restaurante.getInventario().values());
    	inventarioOrdenado.sort(Comparator.comparing(Material::getFechaVencimiento));
    	for(Material material:inventarioOrdenado) {
    		LocalDate hoy=LocalDate.now();
    		LocalDate fechaVencimiento=material.getFechaVencimiento();
    		System.out.println("Tipo: " + material.getTipo() + "\nCantidad: " + material.getCantidad() +  "\nPrecio unitario: " + material.getPrecioUnitario() 
			+ "\nFecha de Vencimiento: " + material.getFechaVencimiento());
    		if (fechaVencimiento!=null && fechaVencimiento.isBefore(hoy.plusDays(7L))) {
    			System.out.println("Este Material está próximo a vencer");
    		}else if(material.getCantidad()<=10) {
    			System.out.println("Este Material está próximo a acabar");
    		}
    	}
    }*/
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
    /*public static void mostrarMateriales(Restaurante restaurante) {
    	for (Material material: restaurante.getInventario().values()) {
    		System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    		System.out.println("-------------------------------------------------------");
    	}
    }*/
    private static void salirDelSistema(Gestor gestor) {
    	System.out.println("Vuelva pronto");
    	Serializador.serializar(gestor);
    	System.exit(0);
    }
}
