/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.disenio.tp03.domain;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */
@Entity
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.articulo", 
            joinColumns = @JoinColumn(name = "Articulo_codigo")),
    @AssociationOverride(name = "primaryKey.reposicion", 
            joinColumns = @JoinColumn(name = "Reposicion_codigo")) })
@Table(name = "ReposicionArticulo")
public class ReposicionArticulo implements Serializable {
    
    @EmbeddedId
    private ReposicionArticuloId primaryKey;
    
    @Column(name = "seleccionado")
    private Integer seleccionado;
   
    @Column(name = "cantidad_reposicion")
    private Integer cantidadReposicion;
    
    @Column(name = "promedio_venta")
    private Double promedioVenta;
    
    @Column(name = "total_pedido_pendiente")
    private Integer totalPedidoPendiente;
    
    @Column(name = "stock_disponible")
    private Integer stockDisponible;

    public ReposicionArticuloId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ReposicionArticuloId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getCantidadReposicion() {
        return cantidadReposicion;
    }

    public void setCantidadReposicion(Integer cantidadReposicion) {
        this.cantidadReposicion = cantidadReposicion;
    }

    public Double getPromedioVenta() {
        return promedioVenta;
    }

    public void setPromedioVenta(Double promedioVenta) {
        this.promedioVenta = promedioVenta;
    }

    public Integer getTotalPedidoPendiente() {
        return totalPedidoPendiente;
    }

    public void setTotalPedidoPendiente(Integer totalPedidoPendiente) {
        this.totalPedidoPendiente = totalPedidoPendiente;
    }

    public Integer getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public Integer getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Integer seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
    
}
