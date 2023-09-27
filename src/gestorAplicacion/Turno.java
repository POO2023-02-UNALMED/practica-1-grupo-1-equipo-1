package gestorAplicacion;
import java.io.Serializable;

import java.util.Date;

public class Turno {
    private Date inicio;
    private Date fin;
    private double salario;
    private boolean completado;
    private boolean cobrado;

    public Turno(Date inicio, Date fin, double salario) {
        this.setInicio(inicio);
        this.setFin(fin);
        this.setSalario(salario);
    }

    // Métodos getter
    public double getSalario() {
		return salario;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFin() {
		return fin;
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
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
}
