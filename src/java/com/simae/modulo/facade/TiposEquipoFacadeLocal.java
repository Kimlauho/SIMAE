/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.TiposEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nena
 */
@Local
public interface TiposEquipoFacadeLocal {

    void create(TiposEquipo tiposEquipo);

    void edit(TiposEquipo tiposEquipo);

    void remove(TiposEquipo tiposEquipo);

    TiposEquipo find(Object id);

    List<TiposEquipo> findAll();

    List<TiposEquipo> findRange(int[] range);

    int count();
    
}
