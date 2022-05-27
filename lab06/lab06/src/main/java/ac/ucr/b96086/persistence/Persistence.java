/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.persistence;

import java.util.List;

/**
 *
 * @author viviana
 */
public interface Persistence<E> {

    E save(E value);

    List<E> findAll();
}
