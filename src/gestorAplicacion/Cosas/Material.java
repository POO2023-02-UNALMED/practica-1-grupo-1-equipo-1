package gestorAplicacion.Cosas;
import java.time.LocalDate;
import java.io.Serializable;

public class Material {
    public enum Tipo {TOMATE,CEBOLLA,MANTEQUILLA,ACEITE,VINO,QUESO,HARINA,CHAMPINON,RES,
    PESCADO,CERDO,PAN,AJO,ESPECIA,HUEVO,TRUFA,CUCHARA,TENEDOR,PLATO,VASO};
    private Tipo tipo;
    private int cantidad;
    private double precioUnitario;
    private LocalDate fechaVencimiento;
    public Material (Tipo tipo) {
        this(tipo, 0, 0);
    }
    public Material (Tipo tipo, int cantidad, double precioUnitario) {
        this(tipo, cantidad, precioUnitario, null);
    }
    public Material (Tipo tipo, int cantidad, double precioUnitario, LocalDate fechaVencimiento) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVencimiento = fechaVencimiento;
    }
    public Tipo getTipo () {
        return this.tipo;
    }
    public int getCantidad () {
        return this.cantidad;
    }
    public void restarCantidad(){
    	this.cantidad-=1;
    }
    public double getPrecioUnitario () {
        return this.precioUnitario;
    }
    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    public void comprarMaterial(int cantidad) {
        this.cantidad += cantidad;
    }
    public void botarMaterial(int cantidad) {
    	this.cantidad -= cantidad;
    }
    public void cambiarPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public void cambiarFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
