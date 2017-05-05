/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.nayaritguideg91.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marieuri
 */
@Entity
@Table(name = "visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByIdvisita", query = "SELECT v FROM Visita v WHERE v.idvisita = :idvisita")
    , @NamedQuery(name = "Visita.findByCalificacion", query = "SELECT v FROM Visita v WHERE v.calificacion = :calificacion")
    , @NamedQuery(name = "Visita.findByComentarios", query = "SELECT v FROM Visita v WHERE v.comentarios = :comentarios")
    , @NamedQuery(name = "Visita.findByTiposubida", query = "SELECT v FROM Visita v WHERE v.tiposubida = :tiposubida")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvisita")
    private Integer idvisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiposubida")
    private int tiposubida;
    @JoinColumn(name = "idlugarturistico", referencedColumnName = "idlugarturistico")
    @ManyToOne(optional = false)
    private Lugarturistico idlugarturistico;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Visita() {
    }

    public Visita(Integer idvisita) {
        this.idvisita = idvisita;
    }

    public Visita(Integer idvisita, int calificacion, String comentarios, int tiposubida) {
        this.idvisita = idvisita;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.tiposubida = tiposubida;
    }

    public Integer getIdvisita() {
        return idvisita;
    }

    public void setIdvisita(Integer idvisita) {
        this.idvisita = idvisita;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getTiposubida() {
        return tiposubida;
    }

    public void setTiposubida(int tiposubida) {
        this.tiposubida = tiposubida;
    }

    public Lugarturistico getIdlugarturistico() {
        return idlugarturistico;
    }

    public void setIdlugarturistico(Lugarturistico idlugarturistico) {
        this.idlugarturistico = idlugarturistico;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvisita != null ? idvisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.idvisita == null && other.idvisita != null) || (this.idvisita != null && !this.idvisita.equals(other.idvisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.nayaritguideg91.entidades.Visita[ idvisita=" + idvisita + " ]";
    }
    
}
