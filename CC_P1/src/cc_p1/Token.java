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
public class Token {
    
    private TokenType type;
    private Object value;
        
    public Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }

    /**
     * @return the type
     */
    public TokenType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TokenType type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    
    
    public enum TokenType {
        
        IDENTIFIER(Integer.class),
        KEYWORD(String.class),
        STRING_LITERAL(String.class),
        INT_LITERAL(Integer.class),
        FLOAT_LITERAL(Float.class),
        OPERATOR(String.class),
        EOF(Boolean.class);

        private Class type;
        
        private TokenType(Class type) {
            this.type = type;
        }
        
        public Class getType() {
            return type;
        }
        
    }
}
