/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.Alquiler.Controller;

import com.simae.mantenimiento.Controller.*;
import com.simae.modulo.entities.Contrato;
import com.simae.modulo.facade.ContratoFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Nena
 */
@Named(value = "contratoController")
@RequestScoped
public class VerContratoController {

    @EJB
    private ContratoFacadeLocal cfl;
    private Contrato contrato;
    
    public VerContratoController() {
    }
    @PostConstruct
    public void init(){
        
    }
    public Contrato getContrato(){
        return contrato;
    }

    public ContratoFacadeLocal getEfl() {
        return cfl;
    }

    public void setEfl(ContratoFacadeLocal efl) {
        this.cfl = cfl;
    }
    
    public String verContrato(Contrato c){
        this.contrato = c;
        return "app/Contratos/VerContrato.xhtml";
    }
    
    
    
}
