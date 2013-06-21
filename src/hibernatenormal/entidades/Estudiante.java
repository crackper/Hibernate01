/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class Estudiante {
    private long id; 
    private String nombre; 
    private List<Libro> libros = new ArrayList<Libro>(); 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
