package gestorAplicacion.Cosas;
import java.io.Serializable;

public class Turno implements Serializable{
	private static final long serialVersionUID=1L;
	public enum Tipo {SEMANA, SABADO, DOMINGO}
    private double salario;
    private boolean completado;
    private boolean cobrado;
    private int horas;

    // Constructor
    public Turno(Tipo tipo, int horas, double salario){
        this.setHoras(horas);
        this.salario = salario;
        this.completado = false;
        this.cobrado = false;
    }
    
    // Métodos getter
	public int getHoras() {
		return horas;
	}
	
	public int HorasExtras() {
        int horasRegulares = 8;  //suponer que es 8
        if (this.horas > horasRegulares) {
            return this.horas - horasRegulares;
        } else {
            return 0;
        }
	}
 
    public double getSalario() {
        return salario;
    }

    public boolean isCompletado() {
        return completado;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    // Métodos setter
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

	public void setHoras(int horas) {
		this.horas = horas;
	}
}

