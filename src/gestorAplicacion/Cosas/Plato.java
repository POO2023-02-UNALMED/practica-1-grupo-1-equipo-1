package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

public class Plato {
    private String nombre;
    private int precio;
    private String descripcion;
    private int tiempo;
    public static final int TIEMPO_DOMICILIO_MINUTOS = 30;
    private Map<Material, Integer> ingredientes;

    public Plato(String nombre, int precio, String desc, Map<Material, Integer> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.descripcion = desc;    
       }
    public Plato(String nombre, int precio, Map<Material, Integer> ingredientes) {
    	this(nombre,precio,"Platillo simple",ingredientes);
    }
    public boolean verificarInsumos(Plato plato){
    	boolean verificado = false;
		for(Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()){
			Material ingrediente = entrada.getKey();
			Integer cantidadPlato = entrada.getValue();
			if(ingrediente.getCantidad() < cantidadPlato){
				verificado = false;
			}
			if(ingrediente.getCantidad() >= cantidadPlato){
				verificado = true;
				
			}
		}
    	return verificado;
    	
    }
 // Métodos getter 
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
    	return descripcion;
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
    public void setDescripcion(String desc) {
    	this.descripcion=desc;
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

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}
