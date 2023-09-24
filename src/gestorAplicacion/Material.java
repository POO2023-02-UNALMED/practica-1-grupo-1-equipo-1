package gestorAplicacion;

public class Material {
    private int cantidad;
    private double precioUnitario;
    private String tipo;
    public Material (int cantidad) {
        this.cantidad = cantidad;
    }
    public void comprarMaterial(int cantidad) {
        this.cantidad += cantidad;
    }
    public String getTipo () {
        return this.tipo;
    }
    public int getCantidad () {
        return this.cantidad;
    }
    public double getPrecioUnitario () {
        return this.precioUnitario;
    }
}