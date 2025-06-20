//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\nMateriales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("\nDuración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println();
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio e = (Ejercicio) obj;
                e.setRevisado(true);
                System.out.println("Ejercicio '" + e.getTitulo() + "' marcado como revisado.");
            }
        }
    }


    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\nFiltrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        // Crear materiales
        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Introducción a Java", "Irving", 15),
                new Video("POO en Java", "Adair", 20),
                new Articulo("Historia de Java", "Judith", 1200),
                new Articulo("Tipos de datos", "Osiris", 800),
                new Ejercicio("Variables y tipos", "Osiris"),
                new Ejercicio("Condicionales", "Irving")
        );


        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }


        mostrarMateriales(materiales);


        contarDuracionVideos(videos);


        marcarEjerciciosRevisados(ejercicios);


        filtrarPorAutor(materiales, m -> m.getAutor().equals("Maritza"));
    }
}