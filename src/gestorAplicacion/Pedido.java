package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;

public class Pedido {
    private Mesa mesa;
    private ArrayList<Plato> platos;
    private boolean verificado;

    public Pedido(Mesa mesa) {
        this.setMesa(mesa);
        this.platos = new ArrayList<>();
        this.setVerificado(false);
    }
    public void agregarPlato(Plato plato) {
        this.platos.add(plato);
    }
    public void removerPlato(Plato plato) {
        this.platos.remove(plato);
    }
    public void completarPedido() {
        this.setVerificado(true);
    }
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public boolean isVerificado() {
		return verificado;
	}
	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
}