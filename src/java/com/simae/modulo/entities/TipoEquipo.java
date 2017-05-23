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
@Table(name = "tiposequipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipo.findAll", query = "SELECT t FROM TipoEquipo t")
    , @NamedQuery(name = "TipoEquipo.findByCodigoTipoEquipo", query = "SELECT t FROM TipoEquipo t WHERE t.codigoTipoEquipo = :codigoTipoEquipo")
    , @NamedQuery(name = "TipoEquipo.findByNombreTipoDeEquipo", query = "SELECT t FROM TipoEquipo t WHERE t.nombreTipoDeEquipo = :nombreTipoDeEquipo")})
public class TipoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoTipoEquipo")
    private Integer codigoTipoEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreTipoDeEquipo")
    private String nombreTipoDeEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoEquipo", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;

    public TipoEquipo() {
    }

    public TipoEquipo(Integer codigoTipoEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
    }

    public TipoEquipo(Integer codigoTipoEquipo, String nombreTipoDeEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
        this.nombreTipoDeEquipo = nombreTipoDeEquipo;
    }

    public Integer getCodigoTipoEquipo() {
        return codigoTipoEquipo;
    }

    public void setCodigoTipoEquipo(Integer codigoTipoEquipo) {
        this.codigoTipoEquipo = codigoTipoEquipo;
    }

    public String getNombreTipoDeEquipo() {
        return nombreTipoDeEquipo;
    }

    public void setNombreTipoDeEquipo(String nombreTipoDeEquipo) {
        this.nombreTipoDeEquipo = nombreTipoDeEquipo;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoEquipo != null ? codigoTipoEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipo)) {
            return false;
        }
        TipoEquipo other = (TipoEquipo) object;
        if ((this.codigoTipoEquipo == null && other.codigoTipoEquipo != null) || (this.codigoTipoEquipo != null && !this.codigoTipoEquipo.equals(other.codigoTipoEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.modulo.entities.TipoEquipo[ codigoTipoEquipo=" + codigoTipoEquipo + " ]";
    }
    
}
