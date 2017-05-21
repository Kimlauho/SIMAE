/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.Alquiler.Controller;

import com.simae.Messages.MessageUtil;
import com.simae.modulo.entities.Contrato;
import com.simae.modulo.entities.Equipo;
import com.simae.modulo.entities.EstadoContrato;
import com.simae.modulo.facade.ContratoFacadeLocal;
import com.simae.modulo.facade.EquipoFacadeLocal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Nena
 */
@Named(value = "registrarContratoController")
@RequestScoped
public class RegistraContratoController {
    
    @EJB
    private ContratoFacadeLocal cfl;
    
    
    private Contrato nuevoContrato;

    public RegistraContratoController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoContrato = new Contrato();
    }
    
    public Contrato getNuevoContrato(){
        return nuevoContrato;
    }
    
    public void setNuevoContrato( Contrato nuevoContrato){
        this.nuevoContrato = nuevoContrato;
    }
    
    public void registrarContrato(){
        if (nuevoContrato != null) {
            cfl.create(nuevoContrato);
            MessageUtil.enviarMensajeInformacion(" ","Registro satisfactorio" ," El contrato ha sido registrado exitosamente.");
            init();
        } else{
            MessageUtil.enviarMensajeError(" ", "No se han diligenciado los campos", "");
        }
    }
}
