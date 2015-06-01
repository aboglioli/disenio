/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.disenio.tp03.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author pablo
 */

@Embeddable
public class ReposicionArticuloId implements Serializable {
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Reposicion reposicion;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Articulo articulo;

    public Reposicion getReposicion() {
        return reposicion;
    }

    public void setReposicion(Reposicion reposicion) {
        this.reposicion = reposicion;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
}
