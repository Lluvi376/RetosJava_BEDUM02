
package com.ejemplo.demo;

import com.ejemplo.demo.entidad.Producto;
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
    public CommandLineRunner demo(ProductoRepository productoRepository) {
        return (args) -> {
            productoRepository.save(new Producto("Laptop HP", "Laptop para oficina", 750));
            productoRepository.save(new Producto("Monitor LG", "Monitor de 27 pulgadas", 300));
            productoRepository.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 25));
            productoRepository.save(new Producto("Mesa escritorio", "Mesa de madera para PC", 600));

            System.out.println("== Productos con precio mayor a 500 ==");
            productoRepository.findByPrecioGreaterThan(500)
                    .forEach(System.out::println);

            System.out.println("== Productos que contienen 'lap' en el nombre ==");
            productoRepository.findByNombreContainingIgnoreCase("lap")
                    .forEach(System.out::println);

            System.out.println("== Productos con precio entre 400 y 1000 ==");
            productoRepository.findByPrecioBetween(400, 1000)
                    .forEach(System.out::println);

            System.out.println("== Productos cuyo nombre comienza con 'M' ==");
            productoRepository.findByNombreStartingWithIgnoreCase("m")
                    .forEach(System.out::println);
        };
    }
}
