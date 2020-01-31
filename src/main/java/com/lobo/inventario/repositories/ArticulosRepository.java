package com.lobo.inventario.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lobo.inventario.domain.Articulo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticulosRepository extends JpaRepository<Articulo,Number> {

    Articulo findByName(String name);
}
