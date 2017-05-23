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
@Table(name = "estadosequipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEquipo.findAll", query = "SELECT e FROM EstadoEquipo e")
    , @NamedQuery(name = "EstadoEquipo.findByCodEstado", query = "SELECT e FROM EstadoEquipo e WHERE e.codEstado = :codEstado")
    , @NamedQuery(name = "EstadoEquipo.findByEstadoEquipo", query = "SELECT e FROM EstadoEquipo e WHERE e.estadoEquipo = :estadoEquipo")})
public class EstadoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codEstado")
    private Integer codEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estadoEquipo")
    private String estadoEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstado", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;

    public EstadoEquipo() {
    }

    public EstadoEquipo(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public EstadoEquipo(Integer codEstado, String estadoEquipo) {
        this.codEstado = codEstado;
        this.estadoEquipo = estadoEquipo;
    }

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
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
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEquipo)) {
            return false;
        }
        EstadoEquipo other = (EstadoEquipo) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simae.modulo.entities.EstadoEquipo[ codEstado=" + codEstado + " ]";
    }
    
}
