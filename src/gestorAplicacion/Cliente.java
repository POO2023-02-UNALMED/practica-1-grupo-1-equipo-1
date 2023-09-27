package gestorAplicacion;
import java.io.Serializable;

public class Cliente extends Persona {
    public Cliente(String nombre, String genero, int edad) {
		super(nombre, genero, edad);
		// TODO Auto-generated constructor stub
	}
	Reserva reserva;
    Pedido pedido;
}
