package utn.disenio.tp06;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import utn.disenio.tp06.dao.IndireccionPersistencia;
import utn.disenio.tp06.domain.Articulo;
import utn.disenio.tp06.domain.Marca;
import utn.disenio.tp06.domain.TipoArticulo;

public class Main {
    private static final int PORT = 3000;

    public static void main(String[] args) {

        IndireccionPersistencia indireccion = IndireccionPersistencia.getInstance();

        Spark.port(PORT);
        Spark.staticFileLocation("/static");

        Spark.get("/articulo", (request, response) -> {
            List<Articulo> articulos = indireccion.getArticulos();

            return makeTemplate("articulos.html", "articulos", articulos);
        }, new MustacheTemplateEngine());
        
        Spark.get("/articulo/:codigo", (request, response) -> {
            List<Articulo> articulos = null;
            try {
                Integer codigo = Integer.valueOf(request.params("codigo"));
                articulos = indireccion.getArticuloByCodigo(codigo);                
            }
            catch(Exception exc) {
                System.out.println(exc);
            }
            
            return makeTemplate("articulos.html", "articulos", articulos);

        }, new MustacheTemplateEngine());
        
        Spark.get("/marca", (request, response) -> {
            List<Marca> marcas = indireccion.getMarcas();
            
            return makeTemplate("marcas.html", "marcas", marcas);
        }, new MustacheTemplateEngine());
        
        Spark.get("/marca/:codigo", (request, response) -> {
            List<Marca> marcas = null;
            try {
                Integer codigo = Integer.valueOf(request.params("codigo"));
                marcas = indireccion.getMarcaByCodigo(codigo);                
            }
            catch(Exception exc) {
                System.out.println(exc);
            }
            
            return makeTemplate("marcas.html", "marcas", marcas);
        }, new MustacheTemplateEngine());
        
        // TipoArticulo
        Spark.get("/tipo_articulo", (request, response) -> {
            List<TipoArticulo> tipoArticulos = indireccion.getTipoArticulos();            

            return makeTemplate("tipo_articulos.html", "tipoArticulos", tipoArticulos);

        }, new MustacheTemplateEngine());
        
        Spark.get("/tipo_articulo/:codigo", (request, response) -> {
            List<TipoArticulo> tipoArticulos = null;
            try {
                Integer codigo = Integer.valueOf(request.params("codigo"));
                tipoArticulos = indireccion.getTipoArticuloByCodigo(codigo);     
            }
            catch(Exception exc) {
                System.out.println(exc);
            }
            
            return makeTemplate("tipo_articulos.html", "tipoArticulos", tipoArticulos);
        }, new MustacheTemplateEngine());
        
        Spark.get("/articulo/:filtro/:codigo", (request, response) -> {
            List<Articulo> articulos = null;
            
            String filtro = request.params("filtro");
            try {
                Integer codigo = Integer.valueOf(request.params("codigo"));
                if(filtro.equals("tipoarticulo")) {
                    articulos = indireccion.getArticuloByTipoArticulo(codigo);
                }
                else if(filtro.equals("marca")) {
                    articulos = indireccion.getArticuloByMarca(codigo);
                }
            }
            catch(Exception exc) {
                System.out.println(exc);
            }
            
            return makeTemplate("articulos.html", "articulos", articulos);
        }, new MustacheTemplateEngine());

        System.out.println("Aplicacion iniciada en puerto " + PORT + "...");

    }
    
    private static ModelAndView makeTemplate(String htmlFile, String modelName, Object modelObject) {
        Map<String, Object> model = new HashMap<>();
        ModelAndView modelAndView = new ModelAndView(model, htmlFile);
        model.put(modelName, modelObject);

        return modelAndView;
    }
}
