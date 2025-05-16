package org.example.demojdbc.model;

public class Productos {
    private int id;
    private String nombre;
    private Double Precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return Precio;
    }
    public void setPrecio(Double precio) {
        this.Precio = precio;
    }


    public Productos() {
    }

/*    public Persona(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }*/

    public Productos(String nombre, Double Precio) {
        super();
        this.nombre = nombre;
        this.Precio = Precio;
    }
    public Productos(String nombre) {
        this.nombre=nombre;
    }

}
