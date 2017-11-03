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
    private String tokenName;
    private String attributeValue;

    public SymbolTableEntry(String tokenName, String attributeValue) {
        this.tokenName = tokenName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }
    
    
}
