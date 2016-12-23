/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.shop.model;

/**
 *
 * @author Эмма
 */
public enum StatusType {
    GOOD("Good"),
    WARNING("Warning"),
    ERROR("Error");
    
    String description;

    private StatusType() {
    }
    
    private  StatusType(String description){
        this.description=description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
