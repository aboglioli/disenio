/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio.tp03.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author kiriost
 */
public class GenericDAO<T> {
    
    private final Class<T> classType;
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public GenericDAO(Class<T> classType) {
        this.classType = classType;
    }
    
    public List<T> getAll() {
        List<T> result;
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        result = session.createCriteria(classType).list();
        transaction.commit();
        return result;
    }
    
    public T get(Integer id) {
        T result;
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        result = (T) session.get(classType, id);
        transaction.commit();
        return result;
    }
}
