/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.nayaritguideg91.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marieuri
 */
@Entity
@Table(name = "marcaturistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcaturistica.findAll", query = "SELECT m FROM Marcaturistica m")
    , @NamedQuery(name = "Marcaturistica.findByIdmarca", query = "SELECT m FROM Marcaturistica m WHERE m.idmarca = :idmarca")
    , @NamedQuery(name = "Marcaturistica.findByNombremarcaturistica", query = "SELECT m FROM Marcaturistica m WHERE m.nombremarcaturistica = :nombremarcaturistica")})
public class Marcaturistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarca")
    private Integer idmarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombremarcaturistica")
    private String nombremarcaturistica;
    @OneToMany(mappedBy = "idmarca", fetch = FetchType.LAZY)
    private List<Lugarturistico> lugarturisticoList;

    public Marcaturistica() {
    }

    public Marcaturistica(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public Marcaturistica(Integer idmarca, String nombremarcaturistica) {
        this.idmarca = idmarca;
        this.nombremarcaturistica = nombremarcaturistica;
    }

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public String getNombremarcaturistica() {
        return nombremarcaturistica;
    }

    public void setNombremarcaturistica(String nombremarcaturistica) {
        this.nombremarcaturistica = nombremarcaturistica;
    }

    @XmlTransient
    public List<Lugarturistico> getLugarturisticoList() {
        return lugarturisticoList;
    }

    public void setLugarturisticoList(List<Lugarturistico> lugarturisticoList) {
        this.lugarturisticoList = lugarturisticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarca != null ? idmarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcaturistica)) {
            return false;
        }
        Marcaturistica other = (Marcaturistica) object;
        if ((this.idmarca == null && other.idmarca != null) || (this.idmarca != null && !this.idmarca.equals(other.idmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.nayaritguideg91.entidades.Marcaturistica[ idmarca=" + idmarca + " ]";
    }
    
}
