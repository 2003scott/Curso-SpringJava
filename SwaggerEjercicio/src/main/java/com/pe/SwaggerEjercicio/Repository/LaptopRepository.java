package com.pe.SwaggerEjercicio.Repository;

import com.pe.SwaggerEjercicio.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
