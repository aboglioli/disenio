/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.disenio.tp03;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author kiriost
 */
public class DBUtils {
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        
        Configuration configuration = new Configuration();
        configuration.configure();
        
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties()).build();
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory(serviceRegistry);

        return sf;
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    } 
    
    public static void closeSessionFactory(SessionFactory sessionFactory1) {
        if(sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }  
    
}
