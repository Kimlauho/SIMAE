/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Nena
 */
@Entity
@Table(name = "estadoscontrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoContrato.findAll", query = "SELECT e FROM EstadoContrato e")
    , @NamedQuery(name = "EstadoContrato.findByCodigoEstadoContrato", query = "SELECT e FROM EstadoContrato e WHERE e.codigoEstadoContrato = :codigoEstadoContrato")
    , @NamedQuery(name = "EstadoContrato.findByEstado", query = "SELECT e FROM EstadoContrato e WHERE e.estado = :estado")})
public class EstadoContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoEstadoContrato")
    private Integer codigoEstadoContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoContrato", fetch = FetchType.LAZY)
    private List<Contrato> contratoList;

    public EstadoContrato() {
    }

    public EstadoContrato(Integer codigoEstadoContrato) {
        this.codigoEstadoContrato = codigoEstadoContrato;
    }

    public EstadoContrato(Integer codigoEstadoContrato, String estado) {
        this.codigoEstadoContrato = codigoEstadoContrato;
        this.estado = estado;
    }

    public Integer getCodigoEstadoContrato() {
        return codigoEstadoContrato;
    }

    public void setCodigoEstadoContrato(Integer codigoEstadoContrato) {
        this.codigoEstadoContrato = codigoEstadoContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEstadoContrato != null ? codigoEstadoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoContrato)) {
            return false;
        }
        EstadoContrato other = (EstadoContrato) object;
        if ((this.codigoEstadoContrato == null && other.codigoEstadoContrato != null) || (this.codigoEstadoContrato != null && !this.codigoEstadoContrato.equals(other.codigoEstadoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.modulo.entities.EstadoContrato[ codigoEstadoContrato=" + codigoEstadoContrato + " ]";
    }
    
}
