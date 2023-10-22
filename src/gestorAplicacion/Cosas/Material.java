//Autor: Daniel Garzón.
//Componentes: importaciones, constructores, getters y metodos de funcionalidades

package gestorAplicacion.Cosas;
import java.time.LocalDate;
import java.io.Serializable;

public class Material implements Serializable{
	private static final long serialVersionUID=1L;
	
    public enum Tipo {TOMATES,CEBOLLAS,PAPAS,ACEITES,VINOS,QUESOS,CHAMPINONES,RES,
    PESCADOS,CERDOS,POLLOS,PANES,AJOS,ESPECIAS,HUEVOS,ATUN,CUCHARAS,TENEDORES,PLATOS,VASOS};
    
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
    public void restarCantidad(int cantidad){
    	this.cantidad-=cantidad;
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
    public String fechaMaterial() {
    	return "Este material no tiene fecha de vencimiento";
    }
}
