package ru.sfedu.shop.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.shop.Main;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import static org.junit.Assert.assertNotNull;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;

public class DbAPISelectTest {
    
    private static Logger log = Logger.getLogger(DbAPISelectTest.class);
    @Test
    public void testSelectDelivery() throws Exception {
        System.out.println("Select Delivery");
        DbAPI instance = new DbAPI();
        Result result;
        result = instance.select(ClassType.DLV);
        //Iterator<BaseDto> it = result.iterator();
//        for (int i=0; i<result.size();i++){//Iterator<BaseDto> iterator = result.iterator(); iterator.hasNext();) {
//            log.trace(result.get(i));
//            
            assertEquals(StatusType.GOOD.toString(), result.getStatus());
            
        //}
    }
    
    @Test
    public void test() throws IOException, SQLException{
        String url  = "jdbc:mysql://localhost:3306/Shop";
        String user = "admin";
        String password = "admin";
        String query = "Select * from DLV;";
        Connection con =(Connection) DriverManager.getConnection(url, user, password);;
        Statement stmt= (Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        while (rs.next()) {
                log.info(rs.getString("method"));
        }
    }
}
