package com.lobo.inventario.controllers;

import com.lobo.inventario.repositories.ArticulosRepository;
import com.lobo.inventario.domain.Articulo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@Api(tags = "Articulo API")
@RestController
public class ArticulosController {


    @Autowired
    private ArticulosRepository articulosRepository;

    @GetMapping("/articulos")
    public ResponseEntity getAllUsers() {
        List<Articulo> articulos;

        try {
             articulos = articulosRepository.findAll();
        }
        catch(Exception e) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.status(HttpStatus.OK)
                .body(articulos);
    }
}
