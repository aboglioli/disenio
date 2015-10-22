/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp06.dao;

import java.util.ArrayList;
import java.util.List;
import utn.disenio.tp06.domain.Articulo;
import utn.disenio.tp06.domain.Marca;
import utn.disenio.tp06.domain.TipoArticulo;

/**
 *
 * @author kiriost
 */
public class IndireccionPersistencia {
    private static IndireccionPersistencia indireccionPersistencia = null;
    private ArticuloDAO articuloDAO;
    private TipoArticuloDAO tipoArticuloDAO;
    private MarcaDAO marcaDAO;
    
    public static IndireccionPersistencia getInstance() {
        if(indireccionPersistencia == null) {
            indireccionPersistencia = new IndireccionPersistencia();
        }
        return indireccionPersistencia;
    }
    
    public IndireccionPersistencia() {
        articuloDAO = new ArticuloDAO();
        tipoArticuloDAO = new TipoArticuloDAO();
        marcaDAO = new MarcaDAO();
    }
    
    public List<Articulo> getArticulos() {
        return articuloDAO.getAll();
    }
    
    public List<Articulo> getArticuloByCodigo(Integer codigo) {
        return articuloDAO.getByCodigo(codigo);
    }
    
    public List<Articulo> getArticuloByTipoArticulo(Integer codigo) {
        return articuloDAO.getByTipoArticulo(codigo);
    }
    
    public List<Articulo> getArticuloByMarca(Integer codigo) {
        return articuloDAO.getByMarca(codigo);
    }
    
    public List<TipoArticulo> getTipoArticulos() {
        return tipoArticuloDAO.getAll();
    }
    
    public List<TipoArticulo> getTipoArticuloByCodigo(Integer codigo) {
        return tipoArticuloDAO.getByCodigo(codigo);
    }
    
    public List<Marca> getMarcas() {
        return marcaDAO.getAll();
    }
    
    public List<Marca> getMarcaByCodigo(Integer codigo) {
        return marcaDAO.getByCodigo(codigo);
    }
}