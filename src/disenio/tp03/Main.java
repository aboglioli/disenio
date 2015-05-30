package disenio.tp03;

import disenio.tp03.dao.ArticuloDAO;
import disenio.tp03.dao.ReposicionDAO;
import disenio.tp03.domain.Reposicion;
import java.util.List;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = DBUtils.getSessionFactory();
        
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ReposicionDAO reposicionDAO = new ReposicionDAO();
        articuloDAO.setSessionFactory(sessionFactory);
        reposicionDAO.setSessionFactory(sessionFactory);
        
        
        List<Reposicion> reposiciones = reposicionDAO.getAll();
        for(Reposicion rep : reposiciones) {
            System.out.println(rep.getNumero());
            System.out.println(rep.getEstadoReposicion().getNombre());
            System.out.println("-------");
        }
        
        DBUtils.closeSessionFactory(sessionFactory);
        
    }    
}
