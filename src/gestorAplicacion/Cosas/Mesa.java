package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mesa {
    private static List<Integer> numeroMesas = new ArrayList<>();
    private int capacidad;
    private Reserva reserva;
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
        Mesa.numeroMesas.add(numeroMesa);
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
    public boolean suficienteCapacidad1(Reserva reserva) {
        if (this.capacidad >= reserva.getNumeroAsistentes()) {
            return true;
        }
        else {
            return false;
        }
    }
    public String suficienteCapacidad2(Reserva reserva) {
        if (this.capacidad >= reserva.getNumeroAsistentes()) {
            return "Mesa con capacidad suficiente";
        }
        else {
            return "Mesa sin suficiente capacidad para los asistentes";
        }
    }
    public void reservarMesa (Reserva reserva) {
        if (this.suficienteCapacidad1(reserva)) {
            this.reserva = reserva;
            this.reserva.setMesa(this);
            this.setOcupada(true);
        }
        
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
}