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
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByHorarioid", query = "SELECT h FROM Horario h WHERE h.horarioid = :horarioid")
    , @NamedQuery(name = "Horario.findByDias", query = "SELECT h FROM Horario h WHERE h.dias = :dias")
    , @NamedQuery(name = "Horario.findByHorainicial", query = "SELECT h FROM Horario h WHERE h.horainicial = :horainicial")
    , @NamedQuery(name = "Horario.findByHorafinal", query = "SELECT h FROM Horario h WHERE h.horafinal = :horafinal")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "horarioid")
    private Integer horarioid;
    @Size(max = 45)
    @Column(name = "dias")
    private String dias;
    @Size(max = 8)
    @Column(name = "horainicial")
    private String horainicial;
    @Size(max = 8)
    @Column(name = "horafinal")
    private String horafinal;
    @OneToMany(mappedBy = "horarioid")
    private List<Medico> medicoList;

    public Horario() {
    }

    public Horario(Integer horarioid) {
        this.horarioid = horarioid;
    }

    public Integer getHorarioid() {
        return horarioid;
    }

    public void setHorarioid(Integer horarioid) {
        this.horarioid = horarioid;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorainicial() {
        return horainicial;
    }

    public void setHorainicial(String horainicial) {
        this.horainicial = horainicial;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
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
        hash += (horarioid != null ? horarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horarioid == null && other.horarioid != null) || (this.horarioid != null && !this.horarioid.equals(other.horarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Horario[ horarioid=" + horarioid + " ]";
    }
    
}
