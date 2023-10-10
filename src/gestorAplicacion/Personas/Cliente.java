package gestorAplicacion.Personas;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;

public class Cliente extends Persona {
	private Reserva reserva;
    private Pedido pedido;
	private Long cedula;
    public Cliente(String nombre, Long cedula) {
		super(nombre);
		this.cedula = cedula;
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
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
}
