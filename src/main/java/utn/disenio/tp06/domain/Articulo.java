/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp06.domain;

import java.io.Serializable;

/**
 *
 * @author kiriost
 */

public class Articulo implements Serializable {
    private Integer codigo;
    private String nombre;
    private Integer cantidadPallet;
    private Boolean habilitar;
    private TipoArticulo tipoArticulo;
    private Marca marca;

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

    public Integer getCantidadPallet() {
        return cantidadPallet;
    }

    public void setCantidadPallet(Integer cantidadPallet) {
        this.cantidadPallet = cantidadPallet;
    }
    
    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
