//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando simulación de acceso al recurso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");


        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra. Navarrete", salaCirugia));
        executor.submit(new Profesional("Dr. González", salaCirugia));
        executor.submit(new Profesional("Enfermero Calvo", salaCirugia));
        executor.submit(new Profesional("Dra. Carrasco", salaCirugia));

        executor.shutdown();
    }
}