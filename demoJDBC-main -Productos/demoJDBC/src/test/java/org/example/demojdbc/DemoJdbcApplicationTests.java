package org.example.demojdbc;

import org.example.demojdbc.model.Productos;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repositorio;

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Productos> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Productos Producto = new Productos("Pollo", 18.0);
        repositorio.insertar(Producto);
        Producto = new Productos("Chuleta", 20.0);
        repositorio.insertar(Producto);
        List<Productos> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        List<Productos> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

  @Test
    void borrarProducto() {
        Productos persona = new Productos("Pollo", 18.0);
        repositorio.borrar(persona);
        List<Productos> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());

    }

    @Test
    void buscarUno() {
        Productos persona = repositorio.buscarUno("Chuleta");
        assertEquals("Chuleta", persona.getNombre());
    }


}
