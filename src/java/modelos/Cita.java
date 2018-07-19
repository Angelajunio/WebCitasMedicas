/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByCitaid", query = "SELECT c FROM Cita c WHERE c.citaid = :citaid")
    , @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora")
    , @NamedQuery(name = "Cita.findByDia", query = "SELECT c FROM Cita c WHERE c.dia = :dia")
    , @NamedQuery(name = "Cita.findByObservacion", query = "SELECT c FROM Cita c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "Cita.findByRealizada", query = "SELECT c FROM Cita c WHERE c.realizada = :realizada")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "citaid")
    private Integer citaid;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 15)
    @Column(name = "hora")
    private String hora;
    @Size(max = 15)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "realizada")
    private boolean realizada;
    @JoinColumn(name = "medicoid", referencedColumnName = "medicoid")
    @ManyToOne(optional = false)
    private Medico medicoid;
    @JoinColumn(name = "pacienteid", referencedColumnName = "pacienteid")
    @ManyToOne(optional = false)
    private Paciente pacienteid;
    @Transient
    private String strFecha;

    public String getStrFecha() {
        return strFecha;
    }

    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }
    public String getFechaDesc() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(fecha);
    }
    @Transient
    private int idpaciente;

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }
    @Transient
    private int idmedico;

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }
    
    
    
    public Cita() {
    }

    public Cita(Integer citaid) {
        this.citaid = citaid;
    }

    public Cita(Integer citaid, String observacion, boolean realizada) {
        this.citaid = citaid;
        this.observacion = observacion;
        this.realizada = realizada;
    }

    public Integer getCitaid() {
        return citaid;
    }

    public void setCitaid(Integer citaid) {
        this.citaid = citaid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Medico getMedicoid() {
        return medicoid;
    }

    public void setMedicoid(Medico medicoid) {
        this.medicoid = medicoid;
    }

    public Paciente getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(Paciente pacienteid) {
        this.pacienteid = pacienteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaid != null ? citaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.citaid == null && other.citaid != null) || (this.citaid != null && !this.citaid.equals(other.citaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Cita[ citaid=" + citaid + " ]";
    }
    
}
