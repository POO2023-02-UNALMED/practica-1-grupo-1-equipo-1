package gestorAplicacion.Cosas;
import java.util.ArrayList;

import java.io.Serializable;
import gestorAplicacion.Personas.Empleado;
import gestorAplicacion.Cosas.Restaurante;

public class Pedido implements Serializable{
	private static final long serialVersionUID=1L;
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private ArrayList<Pedido> pedidosVerificados = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Plato> platos;
    private Restaurante restaurante;
    // Segun este atributo se van a mostrar y se van a dividir
    // En pedidos verificados y no verificados
    private boolean verificado = false;
	private String tipoPedido;
	
	public Pedido () {
	}
	
	// Estos constructores estan para que donde no se le asigne un array para platos se cree un por default vacio
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, Restaurante restaurante) {
	    this(null, tipoPedido, cocinero, null, new ArrayList<Plato>(), restaurante);
	    this.domiciliario=domiciliario;
	}
	
	public Pedido (Mesa mesa,String tipoPedido, Empleado cocinero, Empleado mesero, Restaurante restaurante) {
	    this(mesa, tipoPedido, cocinero, mesero, new ArrayList<Plato>(), restaurante);
	}
	
	// Estos constructores estan para si se les da unos platos para inicializarlo
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, ArrayList<Plato> platos, Restaurante restaurante) {
	    this(null, tipoPedido, cocinero, null, platos, restaurante);
	    this.domiciliario=domiciliario;
	}

	public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos, Restaurante restaurante) {
	    Pedido.pedidos.add(this);
	    this.mesa = mesa;
	    this.tipoPedido = tipoPedido;
	    this.cocinero = cocinero;
	    this.mesero = mesero;
	    this.platos = platos;
	    this.verificado = false;
	    this.restaurante = restaurante;
	}
    // Verificar pedido
     public boolean verificarPedido(Pedido pedido){
     	boolean verificado_insumos = false;
     	// se inicializa como true el domiciliario ya que ste se utiliza para pedidos de tipo domiciliario
     	boolean verificado_domiciliario = false;
     	boolean verificado_cocinero = false;
     	for(Plato plato : pedido.getPlatos()){
     		if (plato.verificarInsumos(plato)){
     			verificado_insumos = true;
     			}else if(true){
     				break;
     		}
     		if (pedido.cocinero.verificarTiempo(plato.getTiempoPreparacion())){
     			verificado_cocinero = true;
     			pedido.setVerificado(true);
     			}else if(true){
     				break;
     				}
     		if (pedido.tipoPedido.equals("domicilio")) {
     			if(pedido.domiciliario.verificarTiempo()){
     				verificado_domiciliario=true;
     				pedido.setVerificado(true);
     				return (verificado_insumos && verificado_cocinero && verificado_domiciliario);
     				}else if(true){
     					return (verificado_insumos && verificado_cocinero && verificado_domiciliario);
     					}
     		}
     		}
     	return (verificado_insumos && verificado_cocinero );
     	}
    
   // Metdos para Administrador
   // Gestion de Pedidos
     
     public String imprimirPlatos(){
    	 int i = 0;
    	 for (Pedido pedido: getPedidos()) {
    		 for(Plato plato : pedido.getPlatos()){
    			 i+=1;
    			 return "\n   "+i+":"+plato.detallesPlato();
         	}
     	}
		return null;
     }
     public String imprimirPedidosVerificadosPlato(){
    	 for(Pedido pedido : getPedidosVerificados()){
     		for(Plato plato : pedido.getPlatos()){
     			return plato.detallesPlato();
         	}
     	}
		return null;
     }
     public String imprimirPedidosPlato(){
    	 for(Pedido pedido : getPedidosVerificados()){
     		for(Plato plato : pedido.getPlatos()){
     			return plato.detallesPlato();
         	}
     	}
		return null;
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
     
     // Metodos de mostrar Pedidos
     public  ArrayList<Pedido> getPedidos(){
    	 return pedidos;
     }
     public  ArrayList<Pedido> getPedidosVerificados(){
    	 return pedidosVerificados;
     }
     
     public void actualizarPedidos() {
    	    for (int i = pedidos.size() - 1; i >= 0; i--) {
    	        Pedido pedido = pedidos.get(i);
    	        if (pedido.isVerificado()) {
    	            pedidosVerificados.add(pedido);
    	            pedidos.remove(i);
    	        }
    	    }
    	}
     public  ArrayList<Plato> getPlatos(){
    	 return this.platos;
     }
     
     @Override
     public String toString() {
    	 String mesaStr = (mesa != null) ? mesa.toString() : "N/A";
         String meseroStr = (mesero != null) ? mesero.toString() : "N/A";
         String domiciliarioStr = (domiciliario != null) ? domiciliario.toString() : "N/A";

         return "mesa: " + mesa +
                 "\n   cocinero: " + cocinero.toString() +
                 "\n   mesero: " + meseroStr +
                 "\n   domiciliario: " + domiciliarioStr +
                 "\n   numero de platos: " + this.getPlatos().size()+ 
                 "\n   platos: " + imprimirPlatos() +
                 "\n   verificado: " + verificado +
                 "\n   tipoPedido: " + tipoPedido ;
     }


}
