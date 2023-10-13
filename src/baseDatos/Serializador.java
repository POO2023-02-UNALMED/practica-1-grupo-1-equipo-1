package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class Serializador {
	private static File rutaTemp=new File("src\\baseDatos\\temp");
	
	public static void serializar(Restaurante restaurante) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs =rutaTemp.listFiles();
		PrintWriter pw;
	
	for (File file:docs) {
		try {
			pw=new PrintWriter(file);
			
		}catch (FileNotFoundException excepcion) {
			excepcion.printStackTrace();
			}
	}
	for (File file:docs) {
		if(file.getAbsolutePath().contains("Empleados")) {
			try {
				fos= new FileOutputStream(file);
				oos= new ObjectOutputStream(fos);
				oos.writeObject(restaurante.getEmpleados());
			}catch(FileNotFoundException e)  {
					e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if (file.getAbsolutePath().contains("Clientes")) {
			try {
				fos= new FileOutputStream(file);
				oos= new ObjectOutputStream(fos);
				oos.writeObject(restaurante.getClientes());
			}catch(FileNotFoundException e)  {
					e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if (file.getAbsolutePath().contains("Mesas")) {
			try {
				fos= new FileOutputStream(file);
				oos= new ObjectOutputStream(fos);
				oos.writeObject(restaurante.getMesas());
			}catch(FileNotFoundException e)  {
					e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if (file.getAbsolutePath().contains("Inventario")) {
			try {
				fos= new FileOutputStream(file);
				oos= new ObjectOutputStream(fos);
				oos.writeObject(restaurante.getInventario());
			}catch(FileNotFoundException e)  {
					e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if (file.getAbsolutePath().contains("Reservas")) {
			List<Mesa> mesas=restaurante.getMesas();
			for (Mesa mesa: mesas) {
				try {
					fos= new FileOutputStream(file);
					oos= new ObjectOutputStream(fos);
					oos.writeObject(mesa.getReserva());
				}catch(FileNotFoundException e)  {
						e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
	
}

