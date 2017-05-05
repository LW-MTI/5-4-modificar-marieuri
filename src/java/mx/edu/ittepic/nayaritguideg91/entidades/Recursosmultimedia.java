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
@Table(name = "recursosmultimedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursosmultimedia.findAll", query = "SELECT r FROM Recursosmultimedia r")
    , @NamedQuery(name = "Recursosmultimedia.findByIdrecurso", query = "SELECT r FROM Recursosmultimedia r WHERE r.idrecurso = :idrecurso")
    , @NamedQuery(name = "Recursosmultimedia.findByDescripcion", query = "SELECT r FROM Recursosmultimedia r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Recursosmultimedia.findByContenido", query = "SELECT r FROM Recursosmultimedia r WHERE r.contenido = :contenido")
    , @NamedQuery(name = "Recursosmultimedia.findByTiporecurso", query = "SELECT r FROM Recursosmultimedia r WHERE r.tiporecurso = :tiporecurso")})
public class Recursosmultimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecurso")
    private Integer idrecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "contenido")
    private long contenido;
    @Column(name = "tiporecurso")
    private Character tiporecurso;
    @JoinColumn(name = "idlugarturistico", referencedColumnName = "idlugarturistico")
    @ManyToOne(optional = false)
    private Lugarturistico idlugarturistico;

    public Recursosmultimedia() {
    }

    public Recursosmultimedia(Integer idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Recursosmultimedia(Integer idrecurso, String descripcion, long contenido) {
        this.idrecurso = idrecurso;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public Integer getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(Integer idrecurso) {
        this.idrecurso = idrecurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getContenido() {
        return contenido;
    }

    public void setContenido(long contenido) {
        this.contenido = contenido;
    }

    public Character getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(Character tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

    public Lugarturistico getIdlugarturistico() {
        return idlugarturistico;
    }

    public void setIdlugarturistico(Lugarturistico idlugarturistico) {
        this.idlugarturistico = idlugarturistico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecurso != null ? idrecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursosmultimedia)) {
            return false;
        }
        Recursosmultimedia other = (Recursosmultimedia) object;
        if ((this.idrecurso == null && other.idrecurso != null) || (this.idrecurso != null && !this.idrecurso.equals(other.idrecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.nayaritguideg91.entidades.Recursosmultimedia[ idrecurso=" + idrecurso + " ]";
    }
    
}
