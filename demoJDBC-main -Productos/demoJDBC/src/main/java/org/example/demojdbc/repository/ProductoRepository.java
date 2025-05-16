package org.example.demojdbc.repository;

import java.util.List;

import org.example.demojdbc.model.Productos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductoRepository {

    private JdbcTemplate plantilla;

    public ProductoRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }
    @Transactional
    public void insertar(Productos Producto) {
        plantilla.update("insert into productos (nombre, Precio ) values (?,?)",
                Producto.getNombre(), Producto.getPrecio());
    }

    public List<Productos> buscarTodos() {
        return plantilla.query("select * from productos",new ProductoMapper());
    }

    public Productos buscarUno(String nombre) {
        List<Productos> resultados = plantilla.query("select * from productos where nombre=?",new ProductoMapper(),nombre);
        if (resultados.isEmpty()) {
            System.out.println("No se encontró ningún resultado para: " + nombre);
            return null;
        } else {
            System.out.println("Encontrado: " + resultados.get(0));
            return resultados.get(0);
        }
    }
    @Transactional
    public void borrar(Productos Producto) {
        plantilla.update("delete from productos where nombre=?",Producto.getNombre());
    }
    @Transactional
    public void borrarTodos() {
        plantilla.update("delete from productos");
    }
}
