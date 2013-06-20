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
public class Contacto  implements Serializable{
    
    private long id;
    private String nombre;
    private String email;
    private String telefono;

    public Contacto()
    {}
    
    public Contacto(String nombre, String email, String telefono)
    {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}