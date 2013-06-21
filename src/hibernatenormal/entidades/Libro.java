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
public class Libro implements Serializable{
    private long id; 
    private String titulo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
