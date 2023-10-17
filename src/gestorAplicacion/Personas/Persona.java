package gestorAplicacion.Personas;
import java.io.Serializable;
public abstract class Persona implements Serializable {
	private static final long serialVersionUID=1L;
	protected String nombre;
	
	public Persona() {
		
	}
    public Persona(String nombre) {
        this.nombre = nombre;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
