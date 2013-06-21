/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal.entidades;

import java.io.Serializable;

/**
 *
 * @author Samuel
 */
public class Persona implements  Serializable{
    private long id;
    private String nombre;
    private Direccion direccion;

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
