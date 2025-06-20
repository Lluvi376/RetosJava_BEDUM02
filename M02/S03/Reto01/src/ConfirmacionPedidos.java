//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.stream.*;

public class ConfirmacionPedidos {

    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Elizabeth", "domicilio", "555-1234"),
                new Pedido("Yoalli", "local", null),
                new Pedido("Enriqueto", "domicilio", null),
                new Pedido("Arath", "domicilio", "555-5678")
        );

        // Almacenamos los mensajes en una lista
        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio")) //Filtrar por entrega a domicilio
                .map(Pedido::getTelefono) //Transformar Pedido → Optional<String>
                .filter(Optional::isPresent) //Filtrar los Optional con valor
                .map(Optional::get) // Extraer el número del Optional
                .map(tel -> "Confirmación enviada al número: " + tel) // 📨 Crear mensaje
                .toList(); //Recolectar en una lista

        // Mostrar los mensajes (podrías guardarlos, enviarlos, etc.)
        System.out.println("Confirmaciones de pedidos a domicilio:");
        mensajes.forEach(System.out::println);
    }
}