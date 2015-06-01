/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp03.dao;

import utn.disenio.tp03.domain.Reposicion;
import utn.disenio.tp03.domain.ReposicionArticulo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kiriost
 */
public class ReposicionDAO extends GenericDAO<Reposicion> {
    
    public ReposicionDAO() {
        super(Reposicion.class);
    }
    
    public List<ReposicionArticulo> obtenerReposicionArticulo(Integer idReposicion) {

        List<ReposicionArticulo> result = new ArrayList<>();
         Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        Reposicion reposicion = (Reposicion) session.get(Reposicion.class, idReposicion);
        Set<ReposicionArticulo> reposicionArticulos = reposicion.getReposicionArticulos();
        reposicionArticulos.stream().forEach((rep) -> {
            result.add(rep);
        });
        transaction.commit();
        return result;
    
    }
    
}
