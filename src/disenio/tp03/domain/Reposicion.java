/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio.tp03.domain;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author kiriost
 */

@Entity
public class Reposicion {
    
    @Id
    private Integer numero;

    private Date fecha;

    @ManyToOne
    private EstadoReposicion estadoReposicion;

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
