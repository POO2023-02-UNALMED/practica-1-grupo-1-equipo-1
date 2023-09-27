package gestorAplicacion.Cosas;
import java.io.Serializable;

public class Mesa {
    private int capacidad;
    private Reserva reserva;
    private boolean ocupada;
    private int numeroMesa;
    public Mesa (int capacidad) {
        this(capacidad, 0);
    }
    public Mesa (int capacidad, int numeroMesa) {
        this.capacidad = capacidad;
        this.numeroMesa = numeroMesa;
        this.ocupada = false;
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
        this.reserva.setMesa(this);
        this.setOcupada(true);
    }
    public boolean isOcupada () {
        return this.ocupada;
    }
    public void setOcupada (boolean ocupacion) {
        this.ocupada = ocupacion;
    }
    public int getNumeroMesa () {
        return this.numeroMesa;
    }
    public void setNumeroMesa (int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
