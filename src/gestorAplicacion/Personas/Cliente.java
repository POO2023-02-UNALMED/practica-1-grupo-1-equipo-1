package gestorAplicacion.Personas;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;

public class Cliente extends Persona {
	private Reserva reserva;
    private Pedido pedido;
    public Cliente(String nombre, String genero, int edad) {
		super(nombre, genero, edad);
	}
	public Reserva getReserva() {
		return this.reserva;
	}
	public void setReserva (Reserva reserva) {
		this.reserva = reserva;
	}
	public Pedido getPedido() {
		return this.pedido;
	}
	public void PedirComida(Pedido pedido) {
		this.pedido = pedido;
	}
}
