/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.TiposMatenimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nena
 */
@Local
public interface TiposMatenimientoFacadeLocal {

    void create(TiposMatenimiento tiposMatenimiento);

    void edit(TiposMatenimiento tiposMatenimiento);

    void remove(TiposMatenimiento tiposMatenimiento);

    TiposMatenimiento find(Object id);

    List<TiposMatenimiento> findAll();

    List<TiposMatenimiento> findRange(int[] range);

    int count();
    
}
