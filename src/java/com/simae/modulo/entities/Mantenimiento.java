/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nena
 */
@Entity
@Table(name = "mantenimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByCodigoMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.codigoMantenimiento = :codigoMantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByFechaMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.fechaMantenimiento = :fechaMantenimiento")})
public class Mantenimiento implements Serializable {

    @Lob
    @Size(max = 16777215)
    @Column(name = "detallesRevision")
    private String detallesRevision;
    @JoinColumn(name = "codigoTipoMantenimiento", referencedColumnName = "codigoTipoMantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMatenimiento codigoTipoMantenimiento;
    @JoinColumn(name = "numeroDeDocumento", referencedColumnName = "numeroDeDocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario numeroDeDocumento;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoMantenimiento")
    private Integer codigoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaMantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMantenimiento;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "piezasCambiadas")
    private String piezasCambiadas;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observacionDeRevision")
    private String observacionDeRevision;
    @ManyToMany(mappedBy = "mantenimientoList", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;
    @JoinColumn(name = "tipoDeMantenimiento", referencedColumnName = "codigoTipoMantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposMatenimiento tipoDeMantenimiento;
    @JoinColumn(name = "documentoUsuario", referencedColumnName = "numeroDeDocumento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario documentoUsuario;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public Mantenimiento(Integer codigoMantenimiento, Date fechaMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Integer getCodigoMantenimiento() {
        return codigoMantenimiento;
    }

    public void setCodigoMantenimiento(Integer codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getPiezasCambiadas() {
        return piezasCambiadas;
    }

    public void setPiezasCambiadas(String piezasCambiadas) {
        this.piezasCambiadas = piezasCambiadas;
    }

    public String getObservacionDeRevision() {
        return observacionDeRevision;
    }

    public void setObservacionDeRevision(String observacionDeRevision) {
        this.observacionDeRevision = observacionDeRevision;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    public TiposMatenimiento getTipoDeMantenimiento() {
        return tipoDeMantenimiento;
    }

    public void setTipoDeMantenimiento(TiposMatenimiento tipoDeMantenimiento) {
        this.tipoDeMantenimiento = tipoDeMantenimiento;
    }

    public Usuario getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(Usuario documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMantenimiento != null ? codigoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.codigoMantenimiento == null && other.codigoMantenimiento != null) || (this.codigoMantenimiento != null && !this.codigoMantenimiento.equals(other.codigoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.modulo.entities.Mantenimiento[ codigoMantenimiento=" + codigoMantenimiento + " ]";
    }

    public String getDetallesRevision() {
        return detallesRevision;
    }

    public void setDetallesRevision(String detallesRevision) {
        this.detallesRevision = detallesRevision;
    }

    public TipoMatenimiento getCodigoTipoMantenimiento() {
        return codigoTipoMantenimiento;
    }

    public void setCodigoTipoMantenimiento(TipoMatenimiento codigoTipoMantenimiento) {
        this.codigoTipoMantenimiento = codigoTipoMantenimiento;
    }

    public Usuario getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(Usuario numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }
    
}
