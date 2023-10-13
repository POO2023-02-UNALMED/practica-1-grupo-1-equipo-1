package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import uiMain.Administrador;
import gestorAplicacion.Cosas.Financia;
import gestorAplicacion.Cosas.Material;
import gestorAplicacion.Cosas.Mesa;
import gestorAplicacion.Cosas.Pedido;
import gestorAplicacion.Cosas.Plato;
import gestorAplicacion.Cosas.Reserva;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;
import gestorAplicacion.Personas.Persona;
import gestorAplicacion.Personas.Cliente;
import gestorAplicacion.Personas.Empleado;

public class Deserializador {
	private static File rutaTemp=new File("src\\baseDatos\\temp");
	
	public static void deserializar(Restaurante restaurante) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file: docs) {
			if (file.getAbsolutePath().contains("Empleados")) {
				try {
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis);
					restaurante.setEmpleados((List<Empleado>) ois.readObject());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("Clientes")) {
				try {
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis);
					restaurante.setClientes((List<Cliente>) ois.readObject());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("Mesas")) {
				try {
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis);
					restaurante.setMesas((List<Mesa>) ois.readObject());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("Inventario")) {
				try {
					fis=new FileInputStream(file);
					ois=new ObjectInputStream(fis);
					restaurante.setInventario((Map<Material.Tipo,Material>) ois.readObject());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}else if(file.getAbsolutePath().contains("Reservas")) {
				List<Mesa> mesas = restaurante.getMesas();
				for (Mesa mesa:mesas) {
					try {
						fis=new FileInputStream(file);
						ois=new ObjectInputStream(fis);
						mesa.setReservas((List<Reserva>) ois.readObject());
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}catch(IOException e) {
						e.printStackTrace();
					}catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
