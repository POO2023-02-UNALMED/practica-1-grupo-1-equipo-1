package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mesa implements Serializable{
	private static final long serialVersionUID=1L;
    private static List<Integer> numeroMesas = new ArrayList<>();
    private int capacidad;
    private List<Reserva> reservas = new ArrayList<>();
    private boolean ocupada;
    private int numeroMesa;
    public Mesa (int capacidad, int numeroMesa) {
        this.capacidad = capacidad;
        if (Mesa.verificarNumero(numeroMesa)) {
            this.numeroMesa = Mesa.generarNumeroMesa();
        }
        else {
            this.numeroMesa = numeroMesa;
        }
        this.ocupada = false;
        Mesa.numeroMesas.add(this.numeroMesa);
    }
    
    public int getCapacidad () {
        return this.capacidad;
    }
    public static List<Integer> getNumeroMesas() {
        return numeroMesas;
    }
    public void setCapacidad (int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }
    public List<Reserva> getReserva () {
        return this.reservas;
    }
    public void setReservas(List<Reserva> reservas) {
    	this.reservas=reservas;
    }
    public boolean suficienteCapacidad(Reserva reserva) {
        if (this.capacidad >= reserva.getNumeroAsistentes()) {
            return true;
        }
        else {
            return false;
        }
    }
    public void reservarMesa (Reserva reserva) {
            this.reservas.add(reserva);
            reserva.setMesa(this);
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
        if (!Mesa.verificarNumero(numeroMesa)) {
            this.numeroMesa = numeroMesa;
        }
    }
    public static int generarNumeroMesa() {
        int numeroAleatorio;
        do {
            Random rand = new Random();
            numeroAleatorio = rand.nextInt(1000) + 1;
        } while (Mesa.verificarNumero(numeroAleatorio));
        return numeroAleatorio;
    }
    public static boolean verificarNumero(int numero) {
        if (Mesa.numeroMesas.contains(numero)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean mesaCompatible(Reserva reserva) {
        for (Reserva reserva1 : reservas) {
            if (reserva1.getDiaReserva().isEqual(reserva.getDiaReserva())) {
                return false;
            }
        }
        return true;
    }
    public String resumenMesa () {
        return "Capacidad de la mesa: "+this.getCapacidad()+"\nNúmero de la mesa: "+this.getNumeroMesa();
    }
}