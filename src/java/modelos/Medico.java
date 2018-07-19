/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author User
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByMedicoid", query = "SELECT m FROM Medico m WHERE m.medicoid = :medicoid")
    , @NamedQuery(name = "Medico.findByNombres", query = "SELECT m FROM Medico m WHERE m.nombres = :nombres")
    , @NamedQuery(name = "Medico.findByApellidos", query = "SELECT m FROM Medico m WHERE m.apellidos = :apellidos")
    , @NamedQuery(name = "Medico.findByCorreo", query = "SELECT m FROM Medico m WHERE m.correo = :correo")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicoid")
    private Integer medicoid;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "especialidadid", referencedColumnName = "especialidadid")
    @ManyToOne
    private Especialidad especialidadid;
    @JoinColumn(name = "horarioid", referencedColumnName = "horarioid")
    @ManyToOne
    private Horario horarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoid")
    private List<Cita> citaList;

     @Transient
     private int idespecialidad;

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }
     
    @Transient
     private int idhorario;

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }
    public Medico() {
    }

    public Medico(Integer medicoid) {
        this.medicoid = medicoid;
    }

    public Medico(Integer medicoid, String correo) {
        this.medicoid = medicoid;
        this.correo = correo;
    }

    public Integer getMedicoid() {
        return medicoid;
    }

    public void setMedicoid(Integer medicoid) {
        this.medicoid = medicoid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Especialidad getEspecialidadid() {
        return especialidadid;
    }

    public void setEspecialidadid(Especialidad especialidadid) {
        this.especialidadid = especialidadid;
    }

    public Horario getHorarioid() {
        return horarioid;
    }

    public void setHorarioid(Horario horarioid) {
        this.horarioid = horarioid;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoid != null ? medicoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.medicoid == null && other.medicoid != null) || (this.medicoid != null && !this.medicoid.equals(other.medicoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Medico[ medicoid=" + medicoid + " ]";
    }
    
}





