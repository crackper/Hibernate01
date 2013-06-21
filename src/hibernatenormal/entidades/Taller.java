/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name="TALLER")
public class Taller implements Serializable{
    @Id
    @Column(name = "IdTaller")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    private boolean activo;
    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "IdParticipante",referencedColumnName = "Id" )
    Participante participante;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    
    
}
