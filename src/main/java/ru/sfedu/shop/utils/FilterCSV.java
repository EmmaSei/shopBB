
package ru.sfedu.shop.utils;

import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;
import org.apache.log4j.Logger;

/**
 *
 * @author Эмма
 */
public class FilterCSV implements CsvToBeanFilter{
    private static final Logger log = Logger.getLogger(FilterCSV.class);
    private final MappingStrategy strategy;
    private String arg;
    private String value;

    /**
     *
     * @param strategy
     */
    public FilterCSV(MappingStrategy strategy) {
 	this.strategy = strategy;
    }

    /**
     *
     * @param strategy
     * @param arg
     * @param value
     */
    public FilterCSV(MappingStrategy strategy, String arg, String value) {
        this.strategy = strategy;
        this.arg = arg;
        this.value = value;
    }
    
    /**
     *
     * @param line
     * @return
     */
    @Override
    public boolean allowLine(String[] line) {
        int index = strategy.getColumnIndex("id");
        String valueIndex = line[index];
        boolean result = !"id".equals(valueIndex);
        if(value!=null && arg!=null){
            int indexArg = strategy.getColumnIndex(arg);
            String valueIndexArg = line[indexArg];
            result &= value.equals(valueIndexArg);
        }
        return result;
    }
    
}