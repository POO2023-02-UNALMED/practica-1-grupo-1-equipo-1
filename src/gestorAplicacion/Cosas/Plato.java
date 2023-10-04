package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.Map;


public class Plato {
    private String nombre;
    private int precio;
    private Map<Material, Integer> ingredientes;

    public Plato(String nombre, int precio, Map<Material, Integer> ingredientes) {
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
    public Map<Material, Integer> getIngredientes() {
        return ingredientes;
    }
    
    // Métodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setIngredientes(Map<Material, Integer> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
    // Método para obtener el número total de ingredientes
    public int getNumeroDeIngredientes() {
        return ingredientes.size();
    }
    

}
