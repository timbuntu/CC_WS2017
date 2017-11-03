/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

/**
 *
 * @author tim
 */
public class Leaf extends Node {
    
    private Token value;
    
    public Leaf(Token value) {
        super("");
        this.value = value;
    }

    /**
     * @return the value
     */
    public Token getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Token value) {
        this.value = value;
    }
    
    public void print(int level) {
        
        for(int i = 0; i < level; i++)
            System.out.print("\t");
        
        System.out.println(value.getType().toString() + " " + value.getValue().toString());
    }
    
}
