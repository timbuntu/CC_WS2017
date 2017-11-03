/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.util.List;

/**
 *
 * @author tim
 */
public class SymbolTableEntry {
    private String name;
    private String value;

    public SymbolTableEntry(String tokenName, String attributeValue) {
        this.name = tokenName;
        this.value = attributeValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
