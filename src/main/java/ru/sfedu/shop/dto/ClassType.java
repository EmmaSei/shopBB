/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.shop.dto;

import ru.sfedu.shop.Const;
import static ru.sfedu.shop.Const.*;

/**
 *
 * @author Эмма
 */
public enum ClassType {

    
    CUS(COLUMNS_CUS),
    ORD(COLUMNS_ORD),
    PAY(COLUMNS_PAY),
    PRD(COLUMNS_PRD),
    DLV(COLUMNS_DLV);
    
    
    private String[] description;

    private ClassType() {
    }
    
    private ClassType(String[] description) { 
        this.description = description; 
    } 

    @Override
    public String toString() {
        return super.toString();
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

  
}
