/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.TiposEquipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nena
 */
@Stateless
public class TiposEquipoFacade extends AbstractFacade<TiposEquipo> implements TiposEquipoFacadeLocal {

    @PersistenceContext(unitName = "simaePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposEquipoFacade() {
        super(TiposEquipo.class);
    }
    
}
