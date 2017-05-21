/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.Alquiler.Controller;

import com.simae.Messages.MessageUtil;
import com.simae.modulo.entities.Contrato;
import com.simae.modulo.facade.ContratoFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Nena
 */
@Named(value = "modificarContratoControler")
@SessionScoped
public class ModificarContratoController implements Serializable{
    
    @EJB
    private ContratoFacadeLocal cfl;
    private Contrato contratoSeleccionado;

    public ModificarContratoController() {
    }

    public Contrato getContratoSeleccionado() {
        return contratoSeleccionado;
    }

    public void setContratoSeleccionado(Contrato contratoSeleccionado) {
        this.contratoSeleccionado = contratoSeleccionado;
    }
    
    public void editarContrato(){
        try {
            cfl.edit(contratoSeleccionado);
            MessageUtil.enviarMensajeInformacion("form-editar", "Actualización","Los datos del contrato se han actualizado correctamente.");
        } catch (Exception e) {
            MessageUtil.enviarMensajeErrorGlobal("Error al edicar los datos del contrato", e.getStackTrace().toString());
        }
    } 
    
    public String preEditar(Contrato c){
        setContratoSeleccionado(c);
        return "/app/contratos/editarContrato.xhtml?faces-redirect=true";
    } 
    
    public void cambioEstado(Contrato c){
        try {

                /*if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 1) {
            c.getCodigoEstadoContrato().setCodigoEstadoContrato(2);
            }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 2) {
            c.getCodigoEstadoContrato().setCodigoEstadoContrato(3);
            }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 3) {
            c.getCodigoEstadoContrato().setCodigoEstadoContrato(4);
            }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 4) {
            c.getCodigoEstadoContrato().setCodigoEstadoContrato(5);
            }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 5) {
            c.getCodigoEstadoContrato().setCodigoEstadoContrato(1);
            }*/ 
            if (null != c.getCodigoEstadoContrato().getCodigoEstadoContrato())
                switch (c.getCodigoEstadoContrato().getCodigoEstadoContrato()) {
                case 1:
                    c.getCodigoEstadoContrato().setCodigoEstadoContrato(2);
                    break;
                case 2:
                    c.getCodigoEstadoContrato().setCodigoEstadoContrato(3);
                    break;
                case 3:
                    c.getCodigoEstadoContrato().setCodigoEstadoContrato(4);
                    break;
                case 4:
                    c.getCodigoEstadoContrato().setCodigoEstadoContrato(5);
                    break;
                case 5:
                    c.getCodigoEstadoContrato().setCodigoEstadoContrato(1);
                    break;
                default:
                    break;
            }
            cfl.edit(c);
            MessageUtil.enviarMensajeInformacion(" ", "Actualización.", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeErrorGlobal("Error al actualizar el estado del contrato.", e.getStackTrace().toString());
        }
    }
    
    public String getIconEstadoContrato(Contrato c){
        String icono = "";

        if (null != c.getCodigoEstadoContrato().getCodigoEstadoContrato()) /*if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 1) {
        }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 2) {
        icono = "refresh";
        }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 3) {
        icono = "stop-circle-o";
        }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 4) {
        icono = "check-square-o";
        }else if (c.getCodigoEstadoContrato().getCodigoEstadoContrato() == 5) {
        icono = "ban";
        }
        return icono;*/
            switch (c.getCodigoEstadoContrato().getCodigoEstadoContrato()) {
            case 1:
                break;
            case 2:
                icono = "refresh";
                break;
            case 3:
                icono = "stop-circle-o";
                break;
            case 4:
                icono = "check-square-o";
                break;
            case 5:
                icono = "ban";
                break;
            default:
                break;
        }
        return icono;
    }
    
}
