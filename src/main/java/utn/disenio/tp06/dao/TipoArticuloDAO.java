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
import utn.disenio.tp06.domain.TipoArticulo;

/**
 *
 * @author kiriost
 */
public class TipoArticuloDAO implements GenericDAO<TipoArticulo> {
    private static final String sqlAll = "SELECT codigo, nombre FROM TipoArticulo";
    private static final String sqlCodigo = sqlAll + " WHERE codigo = ?";
    
    @Override
    public List<TipoArticulo> getAll() {
        return this.query(sqlAll, new Object[]{});
    }
    
    @Override
    public List<TipoArticulo> getByCodigo(Integer codigo) {
        return this.query(sqlCodigo, new Object[]{codigo});
    }
    
    private List<TipoArticulo> query(String sqlQuery, Object args[]) {
        List<TipoArticulo> tipoArticulos = new ArrayList<>();
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
                tipoArticulo.setCodigo(res.getInt("codigo"));
                tipoArticulo.setNombre(res.getString("nombre"));
                
                tipoArticulos.add(tipoArticulo);
            }
            res.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException exc) {
            System.out.println(exc);
        }
        return tipoArticulos;
    }
}
