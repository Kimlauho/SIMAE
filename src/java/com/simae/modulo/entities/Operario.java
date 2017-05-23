/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nena
 */
@Entity
@Table(name = "operarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operario.findAll", query = "SELECT o FROM Operario o")
    , @NamedQuery(name = "Operario.findByNumeroDeDocumento", query = "SELECT o FROM Operario o WHERE o.numeroDeDocumento = :numeroDeDocumento")
    , @NamedQuery(name = "Operario.findByFechaDeAsignacionEquipo", query = "SELECT o FROM Operario o WHERE o.fechaDeAsignacionEquipo = :fechaDeAsignacionEquipo")})
public class Operario implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoOperario")
    private Integer codigoOperario;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroDeDocumento")
    private Long numeroDeDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDeAsignacionEquipo")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAsignacionEquipo;
    @JoinColumn(name = "matriculaEquipo", referencedColumnName = "matricula")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipo matriculaEquipo;
    @JoinColumn(name = "numeroDeDocumento", referencedColumnName = "numeroDeDocumento", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Operario() {
    }

    public Operario(Long numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Operario(Long numeroDeDocumento, Date fechaDeAsignacionEquipo) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.fechaDeAsignacionEquipo = fechaDeAsignacionEquipo;
    }

    public Long getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(Long numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Date getFechaDeAsignacionEquipo() {
        return fechaDeAsignacionEquipo;
    }

    public void setFechaDeAsignacionEquipo(Date fechaDeAsignacionEquipo) {
        this.fechaDeAsignacionEquipo = fechaDeAsignacionEquipo;
    }

    public Equipo getMatriculaEquipo() {
        return matriculaEquipo;
    }

    public void setMatriculaEquipo(Equipo matriculaEquipo) {
        this.matriculaEquipo = matriculaEquipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroDeDocumento != null ? numeroDeDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operario)) {
            return false;
        }
        Operario other = (Operario) object;
        if ((this.numeroDeDocumento == null && other.numeroDeDocumento != null) || (this.numeroDeDocumento != null && !this.numeroDeDocumento.equals(other.numeroDeDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.modulo.entities.Operario[ numeroDeDocumento=" + numeroDeDocumento + " ]";
    }

    public Operario(Integer codigoOperario) {
        this.codigoOperario = codigoOperario;
    }

    public Integer getCodigoOperario() {
        return codigoOperario;
    }

    public void setCodigoOperario(Integer codigoOperario) {
        this.codigoOperario = codigoOperario;
    }

    
    
}
