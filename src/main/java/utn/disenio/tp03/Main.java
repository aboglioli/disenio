package utn.disenio.tp03;

import java.util.HashMap;
import utn.disenio.tp03.dao.ArticuloDAO;
import utn.disenio.tp03.dao.ReposicionDAO;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;
import utn.disenio.tp03.domain.Articulo;
import utn.disenio.tp03.domain.Reposicion;
import utn.disenio.tp03.domain.ReposicionArticulo;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = DBUtils.getSessionFactory();
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ReposicionDAO reposicionDAO = new ReposicionDAO();
        articuloDAO.setSessionFactory(sessionFactory);
        reposicionDAO.setSessionFactory(sessionFactory);

        Spark.port(8080);
        Spark.staticFileLocation("/static");
        
        Spark.get("/articulos", (request, response) -> {
            
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "articulos.html");
            
            List<Articulo> articulos = articuloDAO.getAll();
            model.put("articulos", articulos);
            
            return modelAndView;
            
        }, new MustacheTemplateEngine());
        
        Spark.get("/reposiciones", (request, response) -> { 
        
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "reposiciones.html");
            
            List<Reposicion> reposiciones = reposicionDAO.getAll();
            model.put("reposiciones", reposiciones);
            
            return modelAndView;
            
        }, new MustacheTemplateEngine());
        
        Spark.get("/reposiciones/:codigo", (request, response) -> { 
        
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "reposiciones.html");
            Integer codigo = Integer.valueOf(request.params("codigo"));
            
            List<Reposicion> reposiciones = reposicionDAO.getAll();
            List<ReposicionArticulo> reposicionArticulos = reposicionDAO.obtenerReposicionArticulo(codigo);                        
            model.put("reposiciones", reposiciones);
            model.put("reposicionArticulos", reposicionArticulos);
            
            return modelAndView;
            
        }, new MustacheTemplateEngine());
        
        System.out.println("Aplicacion iniciada en puerto 8080...");

    }
}
