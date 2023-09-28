package uiMain;

public class Administrador {
    public static void main(String[] args) {
    	Administrador admi = new Administrador();
    	int opcion;
    	do {
    		
    		System.out.println("Bienvenido al Gestor del Restaurante"); // agregar el método getNombre
    		System.out.println("¿Que función deseas usar?");
    		System.out.println("1. Gestión de Reserva");
    		System.out.println("2. Gestión de Pedidos");
    		System.out.println("3. Gestión de Empleados");
    		System.out.println("4. Gestión del Inventario");
    		System.out.println("5. Gestión Financiera");
    		System.out.print("Escribe el número de la opción que necesitas: ");
    		opcion = (int) readLong();
    		
    		switch(opcion) {
    		case 1: (admi); break
    		
    		}
    		}
    		
    		
    }
}
