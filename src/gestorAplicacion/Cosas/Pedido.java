package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Pedido {
    private Mesa mesa;
    private ArrayList<Plato> platos;
    private ArrayList<Plato> verificados;
    private boolean verificado = false;

    public Pedido(Mesa mesa) {
        this.setMesa(mesa);
        this.platos = new ArrayList<>();
        this.verificados = new ArrayList<>();
        this.setVerificado(false);
    }
    
    
    // Verificar pedido
    public String verificarPedido(){
    	for(Plato plato : platos){
    		for(Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()){
    			Material ingrediente = entrada.getKey();
    			Integer cantidad = entrada.getValue();
    			if(cantidad>ingrediente.getCantidad()){
    				verificado=false;
    				return "Hay un problema con este material";
    			}
    			if(cantidad >= ingrediente.getCantidad()){
    				verificado = true;
    			}
    		}
        	if(verificado= true){
        		System.out.println(plato.getNombre());
        		if(plato!= null) {
        			this.verificados.add(plato);
        			return "pedido verificado";
        		}
        	}
    	}
		return null;
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
	
	public ArrayList<Plato> getVerificados() {
		return verificados;
	}


	public void setVerificados(ArrayList<Plato> verificados) {
		this.verificados = verificados;
	}

}
