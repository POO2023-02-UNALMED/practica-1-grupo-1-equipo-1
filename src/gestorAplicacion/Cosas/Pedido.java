package gestorAplicacion.Cosas;
import java.util.ArrayList;

import java.io.Serializable;
import gestorAplicacion.Personas.Empleado;

public class Pedido implements Serializable{
	private static final long serialVersionUID=1L;
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private ArrayList<Pedido> pedidosVerificados = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Plato> platos;
    // Segun este atributo se van a mostrar y se van a dividir
    // En pedidos verificados y no verificados
    private boolean verificado = false;
	private String tipoPedido;
	
	public Pedido () {
	}
	
	// Estos constructores estan para que donde no se le asigne un array para platos se cree un por default vacio
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario) {
	    this(null, tipoPedido, cocinero, null, new ArrayList<Plato>());
	    this.domiciliario=domiciliario;
	}
	
	public Pedido (Mesa mesa,String tipoPedido, Empleado cocinero, Empleado mesero) {
	    this(mesa, tipoPedido, cocinero, mesero, new ArrayList<Plato>());
	}
	
	// Estos constructores estan para si se les da unos platos para inicializarlo
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, ArrayList<Plato> platos) {
	    this(null, tipoPedido, cocinero, null, platos);
	    this.domiciliario=domiciliario;
	}

	public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos) {
	    this.pedidos.add(this);
	    this.mesa = mesa;
	    this.tipoPedido = tipoPedido;
	    this.cocinero = cocinero;
	    this.mesero = mesero;
	    this.platos = platos;
	    this.verificado = false;
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
     		if (this.cocinero.verificarTiempo(plato.getTiempoPreparacion())){
     			System.out.println("mmm");
     			verificado_cocinero = true;
     			}else if(true){
     				break;
     				}
     		if (this.tipoPedido.equals("domicilio")) {
     			if(this.domiciliario.verificarTiempo()){
     				verificado_domiciliario=true;
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
    	 for (Pedido pedido: getPedidos()) {
    		 for(Plato plato : pedido.getPlatos()){
    			 return plato.detallesPlato();
         	}
     	}
		return null;
     }
     public String imprimirPedidosVerificados(){
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
    	 for (Pedido pedido : pedidos){
    		 if(pedido.isVerificado()){
    			 pedidosVerificados.add(pedido);
    		 }
    	 }
    	 return pedidosVerificados;
     }
     
     public  ArrayList<Plato> getPlatos(){
    	 return this.platos;
     }
     
     

     @Override
     public String toString() {
         String meseroStr = (mesero != null) ? mesero.toString() : "N/A";
         String domiciliarioStr = (domiciliario != null) ? domiciliario.toString() : "N/A";

         return "Pedido{" +
                 "mesa=" + mesa +
                 ", cocinero=" + cocinero +
                 ", mesero=" + meseroStr +
                 ", domiciliario=" + domiciliarioStr +
                 ", platos=" + platos +
                 ", verificado=" + verificado +
                 ", tipoPedido='" + tipoPedido + '\'' +
                 '}';
     }


}
