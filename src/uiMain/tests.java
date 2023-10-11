package uiMain;
import java.util.HashMap;
import java.util.Map;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class tests {
    public static void main(String[] args) {
        // Crear objetos de las clases necesarias
        Mesa mesa = new Mesa(4, 1);
        Turno turnoSemana= new Turno(Turno.Tipo.SEMANA, 8, 50000);
        Empleado domiciliario = new Empleado("Manolo","domiciliario", null, turnoSemana);;
        Empleado cocinero = new Empleado("Juan", "Cocinero", null, turnoSemana);
        Empleado mesero = new Empleado("Ana", "Mesero", null, turnoSemana);
        Material tomate = new Material(Material.Tipo.TOMATES, 10, 200);
        Material cebolla = new Material(Material.Tipo.CEBOLLAS, 5, 300);
        Material huevo = new Material(Material.Tipo.HUEVOS, 5, 400);
        Map<Material, Integer> ingredientes = new HashMap<>();
        ingredientes.put(tomate, 10);
        ingredientes.put(cebolla, 5);
        ingredientes.put(huevo, 3);
        Plato plato = new Plato("Huevos pericos", 10, 30, ingredientes);
        // Crear un objeto Pedido
        Pedido pedidoDomicilio = new Pedido("domicilio", cocinero, domiciliario);
        Pedido pedidoRestaurante = new Pedido(mesa, "restaurante", cocinero, mesero);
        // Agregar un plato al pedido
        pedidoDomicilio.agregarPlato(plato);
        pedidoRestaurante.agregarPlato(plato);
        // Verificar el pedido
        boolean resultado1 = pedidoDomicilio.verificarPedido();
        boolean resultado2 = pedidoRestaurante.verificarPedido();
        System.out.println("Resultado de la verificación domicilio: " + resultado1 + " Resultado de la verificación restaurante: " + resultado2);
    }
}
