package gestorAplicacion.Cosas;
import java.util.ArrayList;

import gestorAplicacion.Personas.Empleado;

public class Pedido {
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private ArrayList<Plato> platos;
    private ArrayList<Plato> verificados;
    private boolean verificado = false;
	private String tipoPedido;

    public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero) {
        this(mesa, tipoPedido, cocinero, mesero, null);
    }

    public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, Empleado domiciliario) {
        this.mesa = mesa;
        this.tipoPedido = tipoPedido;
        this.cocinero = cocinero;
        this.mesero = mesero;
        this.domiciliario = domiciliario;
        this.platos = new ArrayList<>();
        this.setVerificados(new ArrayList<>());
        this.verificado = false;
    }

    // Verificar pedido
     public boolean verificarPedido(){
     	boolean verificado_insumos = false;
     	// se inicializa como true el domiciliario ya que ste se utiliza para pedidos de tipo domiciliario
     	boolean verificado_domiciliario = true;
     	boolean verificado_cocinero = false;
     	for(Plato plato : platos){
     		if (plato.verificarInsumos(plato)){
     			verificado_insumos = true;
     			}else if(true){
     				break;
     		}
     		if (this.cocinero.verificarTiempo(plato.getTiempo())){
     			verificado_cocinero = true;
     			}else if(true){
     				break;
     				}
     		if(this.domiciliario.verificarTiempo()){
     			verificado_cocinero = true;
     		}
     		if (this.tipoPedido.equals("domicilio")) {
     			if(this.domiciliario.verificarTiempo()){
     				// si hay disponibilidad no se cambia nada ya que su operador booleano esta inicializado en true es true no se cambia nada
     				}else if(true){
     					verificado_domiciliario = false;
     					}
     			}
     		}
     	return (verificado_insumos && verificado_cocinero && verificado_domiciliario);
     	}
    
     // Metodos de plato
     public void agregarPlato(Plato plato) {
    	    this.platos.add(plato);
    	}
     
     public void removerPlato(Plato plato) {
    	    this.platos.remove(plato);
    	}
     
     // Metodos de verificacion
     public boolean isVerificado() {
    	    return verificado;
    	}

   	public void setVerificado(boolean verificado) {
   		this.verificado = verificado;
   		}
   	// Metodos de mesa
   	public Mesa getMesa() {
   	    return mesa;
   	}

   	public void setMesa(Mesa mesa) {
   	    this.mesa = mesa;
   	}
   	
   	// Metodos de listas verificados
	public ArrayList<Plato> getVerificados() {
		return verificados;
	}

	public void setVerificados(ArrayList<Plato> verificados) {
		this.verificados = verificados;
	}   	

}
