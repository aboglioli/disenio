/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio.tp03.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author kiriost
 */

@Entity
public class EstadoReposicion {
    
    @Id
    private Integer codigo;

    private String nombre;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
