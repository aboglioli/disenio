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
import utn.disenio.tp06.domain.Marca;

/**
 *
 * @author kiriost
 */
public class MarcaDAO implements GenericDAO<Marca> {
    private static final String sqlAll = "SELECT codigo, nombre FROM Marca";
    private static final String sqlCodigo = sqlAll + " WHERE codigo = ?";
    
    @Override
    public List<Marca> getAll() {
        return this.query(sqlAll, new Object[]{});
    }
    
    @Override
    public List<Marca> getByCodigo(Integer codigo) {
        return this.query(sqlCodigo, new Object[]{codigo});
    }
    
    private List<Marca> query(String sqlQuery, Object args[]) {
        List<Marca> marcas = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            for(int i=0; i<args.length; i++) {
                stmt.setObject(i+1, args[i]);
            }
            ResultSet res = stmt.executeQuery();
            while(res.next()) {
                Marca marca = new Marca();
                marca.setCodigo(res.getInt("codigo"));
                marca.setNombre(res.getString("nombre"));
                
                marcas.add(marca);
            }
            res.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException exc) {
            System.out.println(exc);
        }
        return marcas;
    }
}
