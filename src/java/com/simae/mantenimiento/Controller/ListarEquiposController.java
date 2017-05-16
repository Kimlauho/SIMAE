/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.mantenimiento.Controller;


import com.simae.modulo.entities.Equipo;
import com.simae.modulo.facade.EquipoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Nena
 */
@Named(value = "listarEquipoController")
@ViewScoped
public class ListarEquiposController implements Serializable{

    @EJB
    private EquipoFacadeLocal efl;
    private List<Equipo> equipos;
    private Equipo equipoSeleccionado;
    
    public ListarEquiposController() {
    }
    
    @PostConstruct
    public void init(){
        recargarEquipos();
    }
    
    public void recargarEquipos(){
        equipos= efl.findAll();
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }
    
    public List<Equipo> getEquipo(){
        return equipos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public EquipoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EquipoFacadeLocal efl) {
        this.efl = efl;
    }
    
    
    public void eliminarEquipo(){
        System.out.println("Voy a eliminar el equipo: " + equipoSeleccionado.getMatricula());
        efl.remove(equipoSeleccionado);
        recargarEquipos();
    }
    
}
