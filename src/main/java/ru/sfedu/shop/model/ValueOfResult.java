package ru.sfedu.shop.model;

import java.util.List;
import ru.sfedu.shop.dto.BaseDto;

public class ValueOfResult extends Result{
    private List<BaseDto> value;

    public ValueOfResult() {
    }

    public List<BaseDto> getValue() {
        return value;
    }

    public void setValue(List<BaseDto> value) {
        this.value = value;
    }
    
    
}
