package gestorAplicacion.Cosas;
import java.time.LocalDate;
//import java.time.LocalTime;
import java.io.Serializable;
import gestorAplicacion.Personas.Cliente;

public class Reserva {
    private Cliente duenoReserva;
    private Mesa mesa;
    private LocalDate diaReserva;
    //private LocalTime horaReserva;
    public Reserva (Cliente duenoReserva, LocalDate diaReserva/*, LocalTime horaReserva*/) {
        this.duenoReserva = duenoReserva;
        this.diaReserva = diaReserva;
        //this.horaReserva = horaReserva;
    }
    public Cliente getDuenoReserva () {
        return this.duenoReserva;
    }
    public Mesa getMesa () {
        return this.mesa;
    }
    public LocalDate getDiaReserva () {
        return this.diaReserva;
    }
    /*public LocalTime getHoraReserva () {
        return this.horaReserva;
    } */
    public void setDuenoReserva (Cliente duenoReserva) {
        this.duenoReserva = duenoReserva;
    }
    public void setMesa (Mesa mesa) {
        this.mesa = mesa;
    }
    public void setDiaReserva (LocalDate diaReserva) {
        this.diaReserva = diaReserva;
    }
    /*public void setHoraReserva (LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }*/
    public String toString () {
        return "Dueño de la reserva: "+this.getDuenoReserva()+"\nMesa número: "
        +this.mesa.getNumeroMesa()+"\nCapacidad: "+this.mesa.getCapacidad()+
        "\nDía de la reserva: "+this.getDiaReserva()/*+"\nHora de la Reserva: "+this.getHoraReserva()*/;
    }
}