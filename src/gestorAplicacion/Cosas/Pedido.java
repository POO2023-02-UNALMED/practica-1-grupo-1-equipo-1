package gestorAplicacion.Cosas;
import java.util.ArrayList;

import gestorAplicacion.Personas.Empleado;

public class Pedido {
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private static ArrayList<Pedido> pedidosVerificados = new ArrayList<>();
    private static ArrayList<Pedido> pedidosNoVerificados = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private ArrayList<Plato> platos;
    // Segun este atributo se van a mostrar y se van a dividir
    // En pedidos verificados y no verificados
    private boolean verificado = false;
	private String tipoPedido;

	public static Pedido crearPedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero) {
        if (tipoPedido.equals("domicilio")) {
            return new Pedido(null, tipoPedido, cocinero, mesero, null);
        } else {
            return new Pedido(mesa, tipoPedido, cocinero, mesero, null);
        }
    }
    	
    public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, Empleado domiciliario) {
    	Pedido.pedidos.add(this);
    	this.mesa = mesa;
        this.tipoPedido = tipoPedido;
        this.cocinero = cocinero;
        this.mesero = mesero;
        this.domiciliario = domiciliario;
        this.platos = new ArrayList<>();
        this.verificado = false;
    }

    // Verificar pedido
     public boolean verificarPedido(){
     	boolean verificado_insumos = false;
     	// se inicializa como true el domiciliario ya que ste se utiliza para pedidos de tipo domiciliario
     	boolean verificado_domiciliario = false;
     	boolean verificado_cocinero = false;
     	for(Plato plato : platos){
     		if (plato.verificarInsumos(plato)){
     			verificado_insumos = true;
     			}else if(true){
     				break;
     		}
     		if (this.cocinero.verificarTiempo(plato.getTiempoPreparacion())){
     			verificado_cocinero = true;
     			}else if(true){
     				System.out.println("false por cocinero");
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
     public static ArrayList<Pedido> getPedidosSinFiltrar(){
    	 return pedidos;
     }
     public static ArrayList<Pedido> getPedidosVerificados(){
    	 for (Pedido pedido : pedidos){
    		 if(pedido.isVerificado()){
    			 pedidosVerificados.add(pedido);
    		 }
    	 }
    	 return pedidosVerificados;
     }
     public static ArrayList<Pedido> getPedidosNoVerificados(){
    	 for (Pedido pedido : pedidos){
    		 if(pedido.isVerificado()){
    			 pedidosVerificados.add(pedido);
    		 }
    	 }
    	 return pedidosNoVerificados;
     }
     
}
