package ru.sfedu.shop.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateDataProviderTest {
    private static final Logger log = Logger.getLogger(HibernateDataProviderTest.class);
    @Test
    public void testGetTables() {
        HibernateDataProvider hdp = new HibernateDataProvider();
        List list = hdp.getTables();
        list.forEach(action ->{
            System.out.println(action);
        });
    }
    
    @Test
    public void testGetUsers() {
        HibernateDataProvider hdp = new HibernateDataProvider();
        List<Object[]> list = hdp.getUsers();
        list.forEach(action ->{
            System.out.println(action[0]+" "+action[1]);
        });
    }
    
    @Test
    public void testGetDataLength() {
        HibernateDataProvider hdp = new HibernateDataProvider();
        List list = hdp.getDataLength();
        list.forEach(action ->{
            System.out.println("size: "+action);
        });
    }
    
    
}
