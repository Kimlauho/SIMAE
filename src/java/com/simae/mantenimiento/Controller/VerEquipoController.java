/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.mantenimiento.Controller;

import com.simae.modulo.entities.Equipo;
import com.simae.modulo.facade.EquipoFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Nena
 */
@Named(value = "equipoController")
@RequestScoped
public class VerEquipoController {

    private Equipo equipo;
    
    public VerEquipoController() {
    }
    @PostConstruct
    public void init(){
        
    }
    public Equipo getEquipo(){
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
    public String verEquipo(Equipo e){
        this.equipo = e;
        return "/app/Equipos/VerEquipo.xhtml";
    }
    
    
    
}
