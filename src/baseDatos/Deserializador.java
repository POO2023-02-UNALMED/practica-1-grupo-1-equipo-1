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
import gestorAplicacion.Cosas.Gestor;

public class Deserializador {
	public static void deserializar(Gestor gestor) {
		deserializarClientes(gestor,new File("src\\baseDatos\\temp\\Clientes.txt"));
		deserializarEmpleados(gestor, new File("src\\baseDatos\\temp\\Empleados.txt"));
		deserializarMesas(gestor, new File("src\\baseDatos\\temp\\Mesas.txt"));
		deserializarEmpleadoDelMes(gestor, new File("src\\baseDatos\\temp\\EmpleadoDelMes.txt"));
	}
	public static void deserializarClientes(Gestor gestor, File ruta) {
		try {
			FileInputStream fis=new FileInputStream(ruta);
			ObjectInputStream ois=new ObjectInputStream(fis);
			gestor.setClientes((ArrayList<Cliente>) ois.readObject());
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Error en la deserialización "+e);
		}
	}
	public static void deserializarEmpleados(Gestor gestor, File ruta) {
		try {
			FileInputStream fis=new FileInputStream(ruta);
			ObjectInputStream ois=new ObjectInputStream(fis);
			gestor.setEmpleados((ArrayList<Empleado>) ois.readObject());
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Error en la deserialización "+e);
		}
	}
	public static void deserializarMesas(Gestor gestor, File ruta) {
		try {
			FileInputStream fis=new FileInputStream(ruta);
			ObjectInputStream ois=new ObjectInputStream(fis);
			gestor.setMesas((ArrayList<Mesa>) ois.readObject());
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Error en la deserialización "+e);
		}
	}
	public static void deserializarEmpleadoDelMes(Gestor gestor, File ruta) {
		try {
			FileInputStream fis=new FileInputStream(ruta);
			ObjectInputStream ois=new ObjectInputStream(fis);
			gestor.setEmmpleadoDelMes((Empleado) ois.readObject());
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Error en la deserialización "+e);
		}
	}
}
