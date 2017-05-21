/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.Alquiler.Controller;

import com.simae.modulo.entities.EstadoContrato;
import com.simae.modulo.facade.EstadoContratoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Nena
 */
@Named(value = "estadoContratoController")
@RequestScoped
public class EstadoContratoController {
    
    @EJB
    private EstadoContratoFacadeLocal ecfl;
    
    private List<EstadoContrato> estadoscontrato;
    
    public EstadoContratoController(){
        
    }
    @PostConstruct
    public void init(){
        estadoscontrato = ecfl.findAll();
    }
    public List<EstadoContrato> getEstadoContrato(){
        return estadoscontrato;
    }
}
