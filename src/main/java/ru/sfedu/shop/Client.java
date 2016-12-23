package ru.sfedu.shop;


import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;
import ru.sfedu.shop.dao.CsvAPI;
import ru.sfedu.shop.dto.ClassType;
import ru.sfedu.shop.model.ValueOfResult;



public class Client {
    private static Logger log = Logger.getLogger(Client.class);
  
    public Client() {
        log.debug("<Your constructor name>[0]: starting application.........");
    }

    private void logBasicSystemInfo() {
        log.info("Launching the application...");
        log.info(
        "Operating System: " + System.getProperty("os.name") + " "
        + System.getProperty("os.version")
        );
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }
    
    public static void main(String[] args) throws Exception{
//        Client client =  new Client();
//        client.logBasicSystemInfo();
        CsvAPI csvAPI = new CsvAPI();
        ValueOfResult valueOfResult= csvAPI.getObjectById(1482214406502L, ClassType.CUS);
        log.info(valueOfResult.getValue().toString());
        cli();
    }
    
    public static void cli() throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            ValueOfResult result = new ValueOfResult();
            CsvAPI  ca = new CsvAPI();
            String[] query;
            ClassType classType;
            query=divide(sc.nextLine());
            switch(query[1]){
                case "delivery" :   
                                    classType=ClassType.DLV;
                                    break;
                case "customer" : 
                                    classType=ClassType.CUS;
                                    break;
                case "order" : 
                                    classType=ClassType.ORD;
                                    break;
                case "payment" : 
                                    classType=ClassType.PAY;
                                    break;
                case "product" : 
                                    classType=ClassType.PRD;
                                    break;
                                    
                default:
                        log.info("incorect query");
                        throw new Exception();
            }
            switch(query[0]){
                case "select" : 
                                result=ca.select(classType);
                                break;
                default : 
                        log.info("incorect query");
                        throw new Exception();
            }
            for (int i = 0; i < 10; i++) {
                log.info(result.getValue().get(i));
            }
            if(!"exit".equals(query)){
                cli();
            }
        } catch (Exception e) {
            cli();
        }
    }
    
    
    private static String[] divide(String s) {
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;
        boolean f = false;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                if (j > i) {
                    tmp.add(s.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s.length()) {
            tmp.add(s.substring(i));
        }
        return tmp.toArray(new String[tmp.size()]);
    }
}
