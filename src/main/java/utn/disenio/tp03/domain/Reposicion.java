/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp03.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author kiriost
 */

@Entity
public class Reposicion implements Serializable {
    
    @Id
    private Integer numero;

    private Date fecha;

    @ManyToOne
    private EstadoReposicion estadoReposicion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.reposicion", cascade = CascadeType.ALL)
    private Set<ReposicionArticulo> reposicionArticulos;

    public Set<ReposicionArticulo> getReposicionArticulos() {
        return reposicionArticulos;
    }

    public void setReposicionArticulos(Set<ReposicionArticulo> reposicionArticulos) {
        this.reposicionArticulos = reposicionArticulos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public EstadoReposicion getEstadoReposicion() {
        return estadoReposicion;
    }

    public void setEstadoReposicion(EstadoReposicion estadoReposicion) {
        this.estadoReposicion = estadoReposicion;
    }
    
}
