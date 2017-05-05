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
@Table(name = "poblacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poblacion.findAll", query = "SELECT p FROM Poblacion p")
    , @NamedQuery(name = "Poblacion.findByIdpoblacion", query = "SELECT p FROM Poblacion p WHERE p.idpoblacion = :idpoblacion")
    , @NamedQuery(name = "Poblacion.findByNombrepoblacion", query = "SELECT p FROM Poblacion p WHERE p.nombrepoblacion = :nombrepoblacion")
    , @NamedQuery(name = "Poblacion.findByIdentidad", query = "SELECT p FROM Poblacion p WHERE p.identidad = :identidad")})
public class Poblacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpoblacion")
    private Integer idpoblacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombrepoblacion")
    private String nombrepoblacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identidad")
    private int identidad;

    public Poblacion() {
    }

    public Poblacion(Integer idpoblacion) {
        this.idpoblacion = idpoblacion;
    }

    public Poblacion(Integer idpoblacion, String nombrepoblacion, int identidad) {
        this.idpoblacion = idpoblacion;
        this.nombrepoblacion = nombrepoblacion;
        this.identidad = identidad;
    }

    public Integer getIdpoblacion() {
        return idpoblacion;
    }

    public void setIdpoblacion(Integer idpoblacion) {
        this.idpoblacion = idpoblacion;
    }

    public String getNombrepoblacion() {
        return nombrepoblacion;
    }

    public void setNombrepoblacion(String nombrepoblacion) {
        this.nombrepoblacion = nombrepoblacion;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoblacion != null ? idpoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poblacion)) {
            return false;
        }
        Poblacion other = (Poblacion) object;
        if ((this.idpoblacion == null && other.idpoblacion != null) || (this.idpoblacion != null && !this.idpoblacion.equals(other.idpoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.nayaritguideg91.entidades.Poblacion[ idpoblacion=" + idpoblacion + " ]";
    }
    
}
