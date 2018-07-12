/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e")
    , @NamedQuery(name = "Especialidad.findByEspecialidadid", query = "SELECT e FROM Especialidad e WHERE e.especialidadid = :especialidadid")
    , @NamedQuery(name = "Especialidad.findByNombre", query = "SELECT e FROM Especialidad e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Especialidad.findByDescripcion", query = "SELECT e FROM Especialidad e WHERE e.descripcion = :descripcion")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "especialidadid")
    private Integer especialidadid;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "especialidadid")
    private List<Medico> medicoList;

    public Especialidad() {
    }

    public Especialidad(Integer especialidadid) {
        this.especialidadid = especialidadid;
    }

    public Integer getEspecialidadid() {
        return especialidadid;
    }

    public void setEspecialidadid(Integer especialidadid) {
        this.especialidadid = especialidadid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidadid != null ? especialidadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.especialidadid == null && other.especialidadid != null) || (this.especialidadid != null && !this.especialidadid.equals(other.especialidadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Especialidad[ especialidadid=" + especialidadid + " ]";
    }
    
}
