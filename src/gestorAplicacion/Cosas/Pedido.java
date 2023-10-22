package gestorAplicacion.Cosas;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import gestorAplicacion.Personas.Empleado;
import uiMain.Menu;

public class Pedido implements Serializable,Menu{
	private static final long serialVersionUID=1L;
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private Reserva reserva;
    private ArrayList<Plato> platos;
    private Restaurante restaurante;
    public static final int TIEMPO_DOMICILIO = 30;
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
	
	public Pedido (Mesa mesa,String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos, Restaurante restaurante, Reserva reserva) {
	    this(null, tipoPedido, cocinero, null, platos, restaurante);
	    this.reserva=reserva;
	}
	
	// Estos constructores estan para si se les da unos platos para inicializarlo
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, ArrayList<Plato> platos, Restaurante restaurante) {
	    this(null, tipoPedido, cocinero, null, platos, restaurante);
	    this.domiciliario=domiciliario;
	}

	public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos, Restaurante restaurante) {
	    this.mesa = mesa;
	    this.tipoPedido = tipoPedido;
	    this.cocinero = cocinero;
	    this.mesero = mesero;
	    this.platos = platos;
	    this.verificado = false;
	    this.restaurante = restaurante;
	    restaurante.agregarPedido(this);
	}

    
   // Metdos para Administrador
   // Gestion de Pedidos
     
     public String imprimirPlatos(){
    	 String stringPlatos = "";
    	 int i =0;
    	 for(Plato plato : this.getPlatos()){
    			 i+=1;
    			 stringPlatos+="\n   "+"Plato numero: "+i+plato.detallesPlato()+"\n";
         	}
		return stringPlatos;
     	}
     
     public String imprimirPedidosVerificadosPlato(){
    	 for(Pedido pedido : this.restaurante.getPedidos()){
    		 if(pedido.isVerificado()){
     		for(Plato plato : pedido.getPlatos()){
     			return plato.detallesPlato();
         	}
     	}
    	 }
		return null;
     }
     
     public String imprimirPedidosPlato(){
    	 for(Pedido pedido : this.restaurante.getPedidos()){
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
     
     public void setMesa(Mesa mesa){
    	 this.mesa = mesa;
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
     public  ArrayList<Pedido> getPedidos(Restaurante restaurante){
    	 ArrayList<Pedido> PedidosSinVerificar=new ArrayList<>();
    	 for(Pedido pedido: restaurante.getPedidos()) {
    		 if(!pedido.isVerificado()){
    			 PedidosSinVerificar.add(pedido);
    		 }
    	 }
    	 return PedidosSinVerificar;
     }
     
     
     public  ArrayList<Pedido> getPedidosVerificados(Restaurante restaurante){
    	 ArrayList<Pedido> PedidosVerificados=new ArrayList<>();
    	 for(Pedido pedido: restaurante.getPedidos()) {
    		 if(pedido.isVerificado()){
    			 PedidosVerificados.add(pedido);
    		 }
    	 }
    	 return PedidosVerificados;
     }
     public  ArrayList<Plato> getPlatos(){
    	 return this.platos;
     }
     public Empleado getCocinero() {
    	 return this.cocinero;
     }
     public Empleado getMesero() {
    	 return this.mesero;
     }
     public Empleado getDomiciliario() {
    	 return this.domiciliario;
     }
     @Override
     public String toString() {
    	 String mesaStr = (mesa != null) ? mesa.toString() : "N/A";
         String meseroStr = (mesero != null) ? mesero.toString() : "N/A";
         String domiciliarioStr = (domiciliario != null) ? domiciliario.toString() : "no tiene reserva asociada";
         String resumen = (reserva != null) ? reserva.resumenReserva() : "N/A";
         

         return "mesa: " + mesa +
                 "\n   cocinero: " + cocinero.toString() +
                 "\n   mesero: " + meseroStr +
                 "\n   domiciliario: " + domiciliarioStr +
                 "\n   numero de platos: " + this.getPlatos().size()+ 
                 "\n   platos: " + imprimirPlatos() +
                 "\n   Este pedido tiene esta reserva: " + resumen+
                 "\n   verificado: " + verificado +
                 "\n   tipoPedido: " + tipoPedido ;
     }
     public double getPrecioTotal() {
         double precioTotal = 0;
         for (Plato plato : this.getPlatos()) {
             precioTotal += plato.getPrecio();
         }
         return precioTotal;
     }
     
     public int getTiempoTotal() {
         int tiempoTotal = 0;
         for (Plato plato : this.getPlatos()) {
        	 tiempoTotal += plato.getTiempoPreparacion();
         }
         return tiempoTotal;
     }
     
     
     
     public void actualizarTiempoEmpleados(Pedido pedido){
    	 for(Turno turno : pedido.getCocinero().getTurnos()){
    		 if(turno.isCobrado()) {
    			 turno.restarTiempo(pedido.getTiempoTotal());
    		 }
    	 }
    	 if(pedido.getDomiciliario()!=null) {
    	 for(Turno turno : pedido.getDomiciliario().getTurnos()){
    		 if(turno.isCobrado()) {
    			 turno.restarTiempo(TIEMPO_DOMICILIO);
    		 }
    	 }
    	 }
     }
     
     public void actualizarInventario(Restaurante restaurante,Pedido pedido) {
		actualizarTiempoEmpleados(pedido);
		restaurante.actualizarInsumos(pedido);
}
	public Mesa verificarPedido(Restaurante restaurante,Pedido pedido) {
		Mesa mesa = restaurante.buscarMesaDisponible().get(0);
		pedido.setMesa(mesa);
		pedido.setVerificado(true);
		actualizarInventario(restaurante,pedido);
		return mesa;
	}


}
