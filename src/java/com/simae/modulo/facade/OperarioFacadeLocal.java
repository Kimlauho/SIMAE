/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simae.modulo.facade;

import com.simae.modulo.entities.Operario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nena
 */
@Local
public interface OperarioFacadeLocal {

    void create(Operario operario);

    void edit(Operario operario);

    void remove(Operario operario);

    Operario find(Object id);

    List<Operario> findAll();

    List<Operario> findRange(int[] range);

    int count();
    
}
