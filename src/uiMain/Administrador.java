package uiMain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

import baseDatos.Serializador;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Cliente;

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
    	Restaurante restaurante=new Restaurante();
    	int opcion;
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
    		case 1:
				System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Ver la lista de reservas");
    			System.out.println("2. Crear reserva");
    			System.out.println("3. Cancelar reserva");
    			System.out.println("4. Asignar mesas a");
    			System.out.println("5. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
				opcion=(int) readLong();
				switch(opcion) {
					case 1:	System.out.println("\nListado de reservas");
							System.out.println(restaurante.imprimirReservas());
							break;
					case 2: System.out.print("Ingrese la cedula del dueño de la reserva: ");
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
				}
			break;
    		case 2: do{
    			System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Lista de pedidos");
    			System.out.println("2. Añadir pedidos");
    			System.out.println("3. Cancelar pedidos");
    			System.out.println("4. Verificar pedidos");
    			System.out.println("5. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
    			opcion=(int) readLong();
    			switch(opcion) {
    			case 1: {
    			    for(Pedido pedido : Pedido.getPedidosSinFiltrar()){
    			        System.out.println(pedido);
    			    }
    			    break;
    			}
    			case 2: // Código para añadir pedidos
    			case 3: // Código para cancelar pedidos
    			case 4: // Código para verificar pedidos
    			case 5: break; // Volver al menú principal
    			}
    		}while(opcion!=5);
    		case 3:;break;
    		case 4: do {
    			System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Consultar Inventario");
    			System.out.println("2. Comprar Materiales");
    			System.out.println("3. Desechar Materiales");
    			System.out.println("4. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
    			opcion=(int) readLong();
    			switch(opcion) {
    			case 1: consultarInventario(restaurante);
    			case 2: 
    				do {
    					
    					System.out.println("1. ¿Que ingrediente desea comprar?");
    					System.out.println("2. ¿Que material desea comprar?");
    					System.out.println("3. ¿Que mesa deseas comprar?");
    					System.out.println("4. Volver al menú de gestión de inventario");
    					opcion=(int)readLong();
    					switch(opcion) {
    					case 1: 
    						mostrarIngredientes(restaurante);
    						System.out.println("Ingrese el ingrediente y la cantidad a comprar");
    						String ingrediente=scan.next();
    						Material.Tipo ingredienteEnum=Material.Tipo.valueOf(ingrediente);
    						int cantidad=(int) readLong();
    						restaurante.comprarMaterial(ingredienteEnum,cantidad);
    						System.out.println("Se han comprado "+cantidad+" "+ingredienteEnum);
    						break;
    					case 2: 
    						mostrarMateriales(restaurante);
    						System.out.println("Ingrese el material y la cantidad a comprar");
    						String material=scan.next();
    						int cantidad2=(int) readLong();
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						restaurante.comprarMaterial(materialEnum,cantidad2);
    						System.out.println("Se han comprado "+cantidad2+" "+materialEnum);
    						break;
    					case 3:
    						mostrarMesas(restaurante);
    						System.out.println("Escriba el numero de la nueva mesa y su capacidad");
    						int numMesa=(int) readLong();
    						int capacidad=(int) readLong();
    						Mesa nuevaMesa = new Mesa(numMesa,capacidad);
    						restaurante.comprarMesa(nuevaMesa);
    						System.out.println("La mesa numero "+numMesa+" con capadidad de "+capacidad+" personas ha sido registrada con éxito");
    						break;
    					case 4:break;
    					}
    				}while(opcion!=4);
    			case 3:
    				do {
    					System.out.println("Escoge la funcion que deseas usar");
    					System.out.println("1. ¿Que ingrediente vas a desechar?");
    					System.out.println("2. ¿Que material vas a desechar?");
    					System.out.println("3. ¿Que mesa vas a desechar?");
    					System.out.println("4. Volver al menú de gestión de inventario");
    					opcion=(int)readLong();
    					switch(opcion) {
    					case 1:  mostrarIngredientes(restaurante);
    						System.out.println("Ingrese el ingrediente y la cantidad a desechar");
    						String ingrediente =scan.next();
    						int cantidad=(int) readLong();
    						Material.Tipo ingredienteEnum=Material.Tipo.valueOf(ingrediente);
    						restaurante.botarMaterial(ingredienteEnum,cantidad);
    						System.out.println("Se han eliminado "+cantidad+" "+ingredienteEnum);
    						break;
    					case 2: mostrarMateriales(restaurante);
    						System.out.println("Ingrese el material y la cantidad a desechar");
    						String material= scan.next();
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						int cantidad2=(int) readLong();
    						restaurante.botarMaterial(materialEnum,cantidad2);
    						System.out.println("Se han eliminado "+cantidad2+" "+materialEnum);
    						break;
    					case 3:mostrarMesas(restaurante);
    					System.out.println("Escriba el numero de mesa a desechar");
    					int numMesa=(int) readLong();
    					restaurante.eliminarMesa(numMesa);
    					System.out.println("La mesa numero "+numMesa+" ha sido eliminada con éxito");
    					break;
    					case 4:break;
    					}
    				}while(opcion!=4);
    			case 4:break;
    			}
    		}while(opcion!=4);
    			
    			
  
    		case 5:;break;
    		case 6: salirDelSistema(restaurante);
			break;
    		}
    	} while(opcion!=6);
    		
    }
    public static void mostrarMesas(Restaurante restaurante) {
    	System.out.println("Mesas del restaurante: ");
    	for (Mesa mesa:restaurante.getMesas()) {
    		System.out.println("Mesa: " + mesa.getNumeroMesa()+" con Capacidad de: "+mesa.getCapacidad()+" personas");
    		System.out.println("-----------------------------");
    	}
    }
    public static void consultarInventario(Restaurante restaurante) {
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
    }
    public static void mostrarIngredientes(Restaurante restaurante) {   	
    	for (Material material: restaurante.getInventario().values()) {
    		System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nFecha: "+material.getFechaVencimiento()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    	
    	}
    }
    public static void mostrarMateriales(Restaurante restaurante) {
    	for (Material material: restaurante.getInventario().values()) {
    		System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    		
    	}
    }
    private static void salirDelSistema(Restaurante restaurante) {
    	System.out.println("Vuelva pronto");
    	Serializador.serializar(restaurante);
    	System.exit(0);
    }
}
