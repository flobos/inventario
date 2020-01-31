package com.lobo.inventario;

import com.lobo.inventario.domain.Articulo;
import com.lobo.inventario.repositories.ArticulosRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class articulosRepositoryTests {

    @Autowired
    private ArticulosRepository articulosRepository;

    @Test
    public void testSaveArticulo() {

        Articulo articulo = new Articulo(1, "fernando", 43 );
        articulosRepository.save(articulo);
        Articulo articulo2 = articulosRepository.findByName("fernando");
        assertNotNull(articulo);
        assertEquals(articulo2.getName(), articulo.getName());
        assertEquals(articulo2.getAge(), articulo.getAge());
    }

    @Test
    public void testDeleteArticulo() {
        Articulo articulo = new Articulo(1, "fernando", 45);
        articulosRepository.save(articulo);
        articulosRepository.delete(articulo);
        Articulo articulo2 = articulosRepository.findByName("fernando");
        assertNull(articulo2);
    }

    @Test
    public void findAllArticulo() {
        Articulo articulo = new Articulo(1, "fernando", 45);
        articulosRepository.save(articulo);
        assertNotNull(articulosRepository.findAll());
    }

    @Test
    public void deletByArticuloIdTest() {
        Articulo articulo = new Articulo(1, "fernando", 45);
        Articulo art = articulosRepository.save(articulo);
        articulosRepository.deleteById(art.getId());
        Articulo articulo2 = articulosRepository.findByName("fernando");
        assertNull(articulo2);
    }
}
