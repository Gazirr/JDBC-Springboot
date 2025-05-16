package org.example.demojdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.demojdbc.model.Productos;

import org.springframework.jdbc.core.RowMapper;

public class ProductoMapper implements RowMapper<Productos> {

    @Override
    public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Crear un nuevo objeto Persona y mapear los campos del ResultSet
        Productos persona = new Productos();
        persona.setId(rs.getInt("id"));
        persona.setNombre(rs.getString("nombre"));
        persona.setPrecio(rs.getDouble("Precio"));
        return persona;
    }
}

