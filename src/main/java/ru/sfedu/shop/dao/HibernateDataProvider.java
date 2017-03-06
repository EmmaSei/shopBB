package ru.sfedu.shop.dao;

import java.util.List;
import org.hibernate.Session;

public class HibernateDataProvider {
    
    private static final String GET_TABLES_QUERY = "show tables;";
    private static final String GET_USERS_QUERY = "select user, host from mysql.user;";
    private static final String GET_DATA_LEGTH_QUERY = "select sum(data_length/1024/1024) from information_schema.tables;";
    
    public List getTables(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createNativeQuery(GET_TABLES_QUERY).getResultList();
    }
    
    public List<Object[]> getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createNativeQuery(GET_USERS_QUERY).getResultList();
    }
    public List getDataLength(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createNativeQuery(GET_DATA_LEGTH_QUERY).getResultList();
    }
}
