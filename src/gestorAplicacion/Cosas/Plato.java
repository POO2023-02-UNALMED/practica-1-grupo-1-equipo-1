package gestorAplicacion.Cosas;
import java.io.Serializable;

public class Plato {
    private String nombre;
    private int precio;
    private Material[] ingredientes;

    public Plato(String nombre, int precio, Material[] ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }
    
    // Métodos getter
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public Material[] getIngredientes() {
        return ingredientes;
    }
    
    // Métodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setIngredientes(Material[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    // Método para establecer un ingrediente específico
    public void setIngrediente(int index, Material ingrediente) {
        if (index >= 0 && index < ingredientes.length) {
            this.ingredientes[index] = ingrediente;
        } else {
            System.out.println("Índice fuera de rango");
        }
    }
    
    // Método para obtener el número total de ingredientes
    public int getNumeroDeIngredientes() {
        return ingredientes.length;
    }

    // Método para imprimir los detalles del plato
    public void imprimirDetalles() {
        System.out.println("Nombre del plato: " + nombre);
        System.out.println("Precio del plato: " + precio);
        System.out.print("Ingredientes del plato: ");
        for (Material ingrediente : ingredientes) {
            System.out.print(ingrediente.getTipo() + ", ");
        }
        System.out.println();
    }
}
