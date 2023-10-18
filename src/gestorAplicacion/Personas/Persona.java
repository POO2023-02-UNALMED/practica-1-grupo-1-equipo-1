package gestorAplicacion.Personas;
import java.io.Serializable;
public abstract class Persona implements Serializable {
	private static final long serialVersionUID=1L;
	protected String nombre;
	protected Long cedula;
	
	public Persona() {
		
	}
    public Persona(String nombre,Long cedula) {
        this.nombre = nombre;
        this.cedula=cedula;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public abstract void puntuacion(Empleado e);
}
