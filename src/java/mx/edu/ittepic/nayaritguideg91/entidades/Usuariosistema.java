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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marieuri
 */
@Entity
@Table(name = "usuariosistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariosistema.findAll", query = "SELECT u FROM Usuariosistema u")
    , @NamedQuery(name = "Usuariosistema.findByIdusuariosistema", query = "SELECT u FROM Usuariosistema u WHERE u.idusuariosistema = :idusuariosistema")
    , @NamedQuery(name = "Usuariosistema.findByNombreusuariosistema", query = "SELECT u FROM Usuariosistema u WHERE u.nombreusuariosistema = :nombreusuariosistema")
    , @NamedQuery(name = "Usuariosistema.findByNombrecompleto", query = "SELECT u FROM Usuariosistema u WHERE u.nombrecompleto = :nombrecompleto")
    , @NamedQuery(name = "Usuariosistema.findByVigente", query = "SELECT u FROM Usuariosistema u WHERE u.vigente = :vigente")
    , @NamedQuery(name = "Usuariosistema.findByIdrol", query = "SELECT u FROM Usuariosistema u WHERE u.idrol = :idrol")
    , @NamedQuery(name = "Usuariosistema.findByContra", query = "SELECT u FROM Usuariosistema u WHERE u.contra = :contra")})
public class Usuariosistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariosistema")
    private Integer idusuariosistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreusuariosistema")
    private String nombreusuariosistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombrecompleto")
    private String nombrecompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigente")
    private Character vigente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrol")
    private int idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contra")
    private String contra;
    @JoinColumn(name = "idusuariosistema", referencedColumnName = "idrol", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Rol rol;

    public Usuariosistema() {
    }

    public Usuariosistema(Integer idusuariosistema) {
        this.idusuariosistema = idusuariosistema;
    }

    public Usuariosistema(Integer idusuariosistema, String nombreusuariosistema, String nombrecompleto, Character vigente, int idrol, String contra) {
        this.idusuariosistema = idusuariosistema;
        this.nombreusuariosistema = nombreusuariosistema;
        this.nombrecompleto = nombrecompleto;
        this.vigente = vigente;
        this.idrol = idrol;
        this.contra = contra;
    }

    public Integer getIdusuariosistema() {
        return idusuariosistema;
    }

    public void setIdusuariosistema(Integer idusuariosistema) {
        this.idusuariosistema = idusuariosistema;
    }

    public String getNombreusuariosistema() {
        return nombreusuariosistema;
    }

    public void setNombreusuariosistema(String nombreusuariosistema) {
        this.nombreusuariosistema = nombreusuariosistema;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public Character getVigente() {
        return vigente;
    }

    public void setVigente(Character vigente) {
        this.vigente = vigente;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariosistema != null ? idusuariosistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariosistema)) {
            return false;
        }
        Usuariosistema other = (Usuariosistema) object;
        if ((this.idusuariosistema == null && other.idusuariosistema != null) || (this.idusuariosistema != null && !this.idusuariosistema.equals(other.idusuariosistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.nayaritguideg91.entidades.Usuariosistema[ idusuariosistema=" + idusuariosistema + " ]";
    }
    
}
