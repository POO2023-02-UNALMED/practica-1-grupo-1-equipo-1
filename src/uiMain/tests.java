package uiMain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class tests {
    public static void main(String[] args) {
        // Crear objetos de las clases necesarias
        Mesa mesa = new Mesa(4, 1);
        Restaurante restaurante1 = new Restaurante();
        System.out.println(restaurante1);
        Turno turnoSemana= new Turno(Turno.Tipo.SEMANA, 8, 50000);
        Empleado domiciliario = new Empleado("Manolo","domiciliario", restaurante1, turnoSemana);;
        Empleado cocinero = new Empleado("Juan", "Cocinero", restaurante1, turnoSemana);
        Empleado mesero = new Empleado("Ana", "Mesero", restaurante1, turnoSemana);
        Material tomate = new Material(Material.Tipo.TOMATES, 10, 200);
        Material cebolla = new Material(Material.Tipo.CEBOLLAS, 5, 300);
        Material huevo = new Material(Material.Tipo.HUEVOS, 5, 400);
        Map<Material, Integer> ingredientes = new HashMap<>();
        ingredientes.put(tomate, 10);
        ingredientes.put(cebolla, 5);
        ingredientes.put(huevo, 3);
        Plato plato1 = new Plato("Huevos pericos", 10, 30, ingredientes);
        // Crear un objeto Pedido
        ArrayList<Plato> menu = new ArrayList<Plato>(Arrays.asList(plato1));
        Pedido pedidoDomicilio = new Pedido("domicilio", cocinero, domiciliario, restaurante1);
        Pedido pedidoRestaurante = new Pedido(mesa, "restaurante", cocinero, mesero, restaurante1);
        // Agregar un plato al pedido
        pedidoDomicilio.agregarPlato(plato1);
        pedidoRestaurante.agregarPlato(plato1);
        // Verificar el pedido
        boolean resultado1 = pedidoDomicilio.verificarPedido(pedidoDomicilio);
        boolean resultado2 = pedidoRestaurante.verificarPedido(pedidoRestaurante);
        System.out.println("pillelos");
        System.out.println(pedidoDomicilio.imprimirPedidosVerificadosPlato());
        System.out.println("Resultado de la verificación domicilio: " + resultado1 + " Resultado de la verificación restaurante: " + resultado2);
    }
}
