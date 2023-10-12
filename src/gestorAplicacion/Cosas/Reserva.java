package gestorAplicacion.Cosas;
import java.time.LocalDate;
//import java.time.LocalTime;
import java.io.Serializable;
import gestorAplicacion.Personas.Cliente;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private Cliente duenoReserva;
    private Mesa mesa;
    private int numAsistentes;
    private LocalDate diaReserva;
    //private LocalTime horaReserva;
    public Reserva (Cliente duenoReserva, int numAsistentes,LocalDate diaReserva/*, LocalTime horaReserva*/) {
        this.duenoReserva = duenoReserva;
        this.numAsistentes = numAsistentes;
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
    public int getNumeroAsistentes () {
        return this.numAsistentes;
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
    public String resumenReserva () {
        if (this.mesa == null) {
            return "Dueño de la reserva: "+this.getDuenoReserva().getNombre()+"\nCédula del reservista: "+this.getDuenoReserva().getCedula()+"\nNumero de asistentes: "+this.getNumeroAsistentes()+"\nMesa número: "
        +"Sin mesa asignada"+"\nFecha reservada: "+this.getDiaReserva()/*+"\nHora reservada: "+this.getHoraReserva()*/;
        }
        else {
            return "Dueño de la reserva: "+this.getDuenoReserva().getNombre()+"\nCédula del reservista: "+this.getDuenoReserva().getCedula()+"\nNumero de asistentes: "+this.getNumeroAsistentes()+"\nMesa número: "
        +this.mesa.getNumeroMesa()+"\nFecha reservada: "+this.getDiaReserva()/*+"\nHora reservada: "+this.getHoraReserva()*/;
        }
    }
    public static LocalDate deStringaFecha(String fechaString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);
        return fecha;
    }
}