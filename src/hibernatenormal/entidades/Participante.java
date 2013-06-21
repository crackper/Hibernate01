/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name="PARTICIPANTE")
public class Participante implements Serializable{
    
    @Id
    @Column(name="Id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Nombre",length = 200,nullable = false)
    private String nombre;
    @Column(name="Apellidos",length = 200,nullable = false)
    private String apellidos;
    @Column(name="Procedencia",length = 120,nullable = false)
    private String procedencia;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "participante" )
    private Set<Taller> talleres = new HashSet<Taller>();
    
    public Participante()
    {}
    
    public Participante(String nombre,String apellidos,String procedencia)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.procedencia = procedencia;
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Set<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Taller> talleres) {
        this.talleres = talleres;
    }
    
    public void addTaller(Taller taller)
    {
        this.talleres.add(taller);
        taller.setParticipante(this);
    }
    
}
