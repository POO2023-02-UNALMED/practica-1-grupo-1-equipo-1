package gestorAplicacion;
import java.io.Serializable;

public class Mesa {
    private int capacidad;
    private Reserva reserva;
    public Mesa (int capacidad) {
        this(capacidad, null);
    }
    public Mesa (int capacidad, Reserva reserva) {
        this.capacidad = capacidad;
        this.reserva = reserva;
    }
    public int getCapacidad () {
        return this.capacidad;
    }
    public void setCapacidad (int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }
    public Reserva getReserva () {
        return this.reserva;
    }
    public void reservarMesa (Reserva reserva) {
        this.reserva = reserva;
    }
}
