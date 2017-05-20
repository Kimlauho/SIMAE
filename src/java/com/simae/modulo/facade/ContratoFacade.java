/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.Contrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nena
 */
@Stateless
public class ContratoFacade extends AbstractFacade<Contrato> implements ContratoFacadeLocal {

    @PersistenceContext(unitName = "simaePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratoFacade() {
        super(Contrato.class);
    }
    
}
