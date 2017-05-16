/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.Alquiler.Controller;

import com.simae.mantenimiento.Controller.*;
import com.simae.modulo.entities.Contrato;
import com.simae.modulo.facade.ContratoFacadeLocal;
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
@Named(value = "listarContratoController")
@ViewScoped
public class ListarContratoController implements Serializable{

    @EJB
    private ContratoFacadeLocal cfl;
    private List<Contrato> contratos;
    private Contrato contratoSeleccionado;
    
    public ListarContratoController() {
    }
    @PostConstruct
    public void init(){
        recargarContratos();
    }
    
    public void recargarContratos(){
        contratos= cfl.findAll();
    }

    public Contrato getContratoSeleccionado() {
        return contratoSeleccionado;
    }

    public void setContratoSeleccionado(Contrato contratoSeleccionado) {
        this.contratoSeleccionado = contratoSeleccionado;
    }
    
    public List<Contrato> getContrato(){
        return contratos;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
    public void eliminarContrato(){
        cfl.remove(contratoSeleccionado);
    }
    
}
