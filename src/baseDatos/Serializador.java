package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Restaurante;
public class Serializador {
	private static File rutaTemp=new File("src\\basedatos\\temp");
	public static void serializar(Restaurante restaurante) {
		FileOutputStream archivo;
		ObjectOutputStream codificador;
		File[] documentos = rutaTemp.listFiles();
		PrintWriter lector;
		for(File file:documentos) {
			try {
				lector = new PrintWriter(file);
			} catch (FileNotFoundException excepcion) {
				excepcion.printStackTrace();
			}
		}
		for(File file:documentos) {
			if(file.getAbsolutePath().contains("clientes")) {
				try {
					archivo = new FileOutputStream(file);
					codificador = new ObjectOutputStream(archivo);
					codificador.writeObject(restaurante.getClientes());
				} catch (FileNotFoundException excepcion) {
					excepcion.printStackTrace();
				} catch (IOException excepcion) {
					excepcion.printStackTrace();
				}
			}
		}
	}
	
}
