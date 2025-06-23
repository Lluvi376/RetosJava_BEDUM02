
package com.ejemplo.demo;

import com.ejemplo.demo.entidad.Marca;
import com.ejemplo.demo.entidad.Producto;
import com.ejemplo.demo.repositorio.MarcaRepository;
import com.ejemplo.demo.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return (args) -> {
            Marca marca1 = new Marca("HP");
            Marca marca2 = new Marca("Logitech");

            marcaRepo.save(marca1);
            marcaRepo.save(marca2);

            productoRepo.save(new Producto("Laptop HP", "Laptop para oficina", 750, marca1));
            productoRepo.save(new Producto("Monitor HP", "Monitor de 24 pulgadas", 300, marca1));
            productoRepo.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 25, marca2));
            productoRepo.save(new Producto("Teclado Logitech", "Teclado mecánico", 120, marca2));

            System.out.println("\n Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
