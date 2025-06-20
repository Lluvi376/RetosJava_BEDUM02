//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class ProcesadorEncuestas {

    public static void main(String[] args) {
        //Lista de sucursales con sus encuestas
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Gon", "El tiempo de espera fue largo", 2),
                        new Encuesta("Gerardo", null, 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Bianca", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Boris", null, 4)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Carlos", null, 2),
                        new Encuesta("Sofía", "No encontré el medicamento que necesitaba", 1)
                ))
        );

        System.out.println("Seguimiento a pacientes insatisfechos:");

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3) //Filtrar encuestas insatisfechas
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre())) // Combinar encuesta + sucursal
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent()) //Filtrar encuestas con comentario
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println); //Imprimir mensajes
    }

    // Clase auxiliar para transportar Encuesta + Sucursal juntos, tipo record
    record Seguimiento(Encuesta encuesta, String sucursal) {
    }
}