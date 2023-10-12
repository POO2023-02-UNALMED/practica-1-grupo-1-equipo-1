package baseDatos;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class Serializador {
	public static void serializar(GestionDatos gest) {
		serializarClientes(gest, new File("src\\baseDatos\\temp\\Clientes.txt"));
		serializarEmpleados(gest, new File("src\\baseDatos\\temp\\Empleados.txt"));
		serializarMesas(gest, new File("src\\baseDatos\\temp\\Mesas.txt"));
		serializarReservas(gest, new File("src\\baseDatos\\temp\\Reservas.txt"));
	}
		public static void serializarMesas(GestionDatos gest,File ruta) {
			try {
				PrintWriter pw= new PrintWriter(ruta);
				FileOutputStream file=new FileOutputStream(ruta);
				ObjectOutputStream output=new ObjectOutputStream(file);
				output.writeObject(gest.getMesas());
				output.close();
				file.close();
			}catch (IOException excepcion) {
				System.out.println("Error en la serializacion" + excepcion);
			}
		}
		public static void serializarClientes(GestionDatos gest,File ruta) {
			try {
				PrintWriter pw= new PrintWriter(ruta);
				FileOutputStream file=new FileOutputStream(ruta);
				ObjectOutputStream output=new ObjectOutputStream(file);
				output.writeObject(gest.getClientes());
				output.close();
				file.close();
			}catch (IOException excepcion) {
				System.out.println("Error en la serializacion" + excepcion);
			}
		}
		public static void serializarEmpleados(GestionDatos gest,File ruta) {
			try {
				PrintWriter pw= new PrintWriter(ruta);
				FileOutputStream file=new FileOutputStream(ruta);
				ObjectOutputStream output=new ObjectOutputStream(file);
				output.writeObject(gest.getEmpleados());
				output.close();
				file.close();
			}catch (IOException excepcion) {
				System.out.println("Error en la serializacion" + excepcion);
			}
		}
		public static void serializarReservas(GestionDatos gest,File ruta) {
			for (Mesa mesas:gest.getRestaurante().getMesas()) {
				try {
					PrintWriter pw= new PrintWriter(ruta);
					FileOutputStream file=new FileOutputStream(ruta);
					ObjectOutputStream output=new ObjectOutputStream(file);
					output.writeObject(mesas.getReserva());
					output.close();
					file.close();
				}catch (IOException excepcion) {
					System.out.println("Error en la serializacion" + excepcion);
				}
			}
			
		}
		
	
}
