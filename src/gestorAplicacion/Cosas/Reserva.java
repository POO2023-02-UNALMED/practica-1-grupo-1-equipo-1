package gestorAplicacion.Cosas;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable;
import gestorAplicacion.Personas.Cliente;

public class Reserva {
    private Cliente duenoReserva;
    private Mesa mesa;
    private LocalDate diaReserva;
    private LocalTime horaReserva;
    public Reserva (Cliente duenoReserva, Mesa mesa, LocalDate diaReserva, LocalTime horaReserva) {
        this.duenoReserva = duenoReserva;
        this.mesa = mesa;
        this.diaReserva = diaReserva;
        this.horaReserva = horaReserva;
    }
    
}
