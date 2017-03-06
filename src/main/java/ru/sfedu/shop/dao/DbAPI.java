package ru.sfedu.shop.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import static ru.sfedu.shop.Const.*;
import ru.sfedu.shop.dto.BaseDto;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.model.Result;
import ru.sfedu.shop.model.StatusType;
import ru.sfedu.shop.model.ValueOfResult;
import static ru.sfedu.shop.utils.ConfigurationUtil.getConfigurationEntry;


public class DbAPI implements IGeneric{
    
    private static final Logger log = Logger.getLogger(DbAPI.class);
    
    private final String url;
    private final String user;
    private final String password;
    
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public DbAPI() throws IOException {
        this.url  = "jdbc:mysql://localhost:3306/Shop";
        this.user = "admin";
        this.password = "admin";
    }
    
    @Override
    public Result insert(ArrayList<BaseDto> baseDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result update(BaseDto baseDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result delete(BaseDto baseDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ValueOfResult select(ClassType classType) throws Exception {
        ValueOfResult result= new ValueOfResult();
        String query = "select * from "+classType.toString();
        log.info(query);
        try{
            con = (Connection) DriverManager.getConnection(url, user, password);
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            log.info(rs);
            result.setStatus(StatusType.GOOD.toString());
            while (rs.next()) {
                log.info("----"+rs.getInt("id")+"  "+rs.getString("method")+"  "+rs.getInt("price"));
            }
            //result.setValue((List<BaseDto>) rs);
        }catch(SQLException sqlEx) {
            result.setStatus(StatusType.ERROR.toString());
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { log.debug(se); }
            try { stmt.close(); } catch(SQLException se) { log.debug(se); }
            try { rs.close(); } catch(SQLException se) { log.debug(se); }
        }
        return result;
    }

    @Override
    public Result select(ClassType classType, String arg, String value) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
