
package com.ejemplo.demo.repositorio;

import com.ejemplo.demo.entidad.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
