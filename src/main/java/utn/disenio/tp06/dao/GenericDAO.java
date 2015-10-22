/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp06.dao;

import java.util.List;

/**
 *
 * @author kiriost
 */
public interface GenericDAO<T> {
    public List<T> getAll();
    public List<T> getByCodigo(Integer codigo);
}
