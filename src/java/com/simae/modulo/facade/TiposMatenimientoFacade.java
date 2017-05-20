/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.TiposMatenimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nena
 */
@Stateless
public class TiposMatenimientoFacade extends AbstractFacade<TiposMatenimiento> implements TiposMatenimientoFacadeLocal {

    @PersistenceContext(unitName = "simaePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposMatenimientoFacade() {
        super(TiposMatenimiento.class);
    }
    
}
