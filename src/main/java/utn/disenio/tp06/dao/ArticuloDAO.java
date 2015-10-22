/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utn.disenio.tp06.domain.Articulo;
import utn.disenio.tp06.domain.Marca;
import utn.disenio.tp06.domain.TipoArticulo;

/**
 *
 * @author kiriost
 */
public class ArticuloDAO implements GenericDAO<Articulo> {
    private static final String sqlAll = "SELECT a.codigo, a.nombre, a.cantidad_pallet,"
            + " a.habilitar, a.codigo_tipoarticulo, a.codigo_marca,"
            + " ta.nombre nombre_tipoarticulo, m.nombre nombre_marca"
            + " FROM Articulo a"
            + " LEFT JOIN TipoArticulo ta ON a.codigo_tipoarticulo = ta.codigo"
            + " LEFT JOIN Marca m ON a.codigo_marca = m.codigo";
    private static final String sqlCodigo = sqlAll + " WHERE a.codigo = ?";
    private static final String sqlTipoArticulo = sqlAll + " WHERE ta.codigo = ?";
    private static final String sqlMarca = sqlAll + " WHERE m.codigo = ?";
    
    @Override
    public List<Articulo> getAll() {
        return this.query(sqlAll, new Object[]{});
    }
    
    @Override
    public List<Articulo> getByCodigo(Integer codigo) {
        return this.query(sqlCodigo, new Object[]{codigo});
    }
    
    public List<Articulo> getByTipoArticulo(Integer codigo_tipoarticulo) {
        return this.query(sqlTipoArticulo, new Object[]{codigo_tipoarticulo});
    }
    
    public List<Articulo> getByMarca(Integer codigo_marca) {
        return this.query(sqlMarca, new Object[]{codigo_marca});
    }
    
    private List<Articulo> query(String sqlQuery, Object args[]) {
        List<Articulo> articulos = new ArrayList();
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            for(int i=0; i<args.length; i++) {
                stmt.setObject(i+1, args[i]);
            }
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                TipoArticulo tipoArticulo = new TipoArticulo();
                tipoArticulo.setCodigo(res.getInt("codigo_tipoarticulo"));
                tipoArticulo.setNombre(res.getString("nombre_tipoarticulo"));
                
                Marca marca = new Marca();
                marca.setCodigo(res.getInt("codigo_marca"));
                marca.setNombre(res.getString(("nombre_marca")));
                
                Articulo articulo = new Articulo();
                articulo.setCodigo(res.getInt("codigo"));
                articulo.setNombre(res.getString("nombre"));
                articulo.setCantidadPallet(res.getInt("cantidad_pallet"));
                articulo.setHabilitar(res.getBoolean("habilitar"));
                
                articulo.setTipoArticulo(tipoArticulo);
                articulo.setMarca(marca);
                
                articulos.add(articulo);
            }
            res.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException exc) {
            System.out.println(exc);
        }
        return articulos;
    }
}
