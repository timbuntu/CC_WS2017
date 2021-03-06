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
public class Exceptions {
    public static class UnknownLexemeException extends Exception {
        
        public UnknownLexemeException(String lexeme) {
            super(" \""+ lexeme + "\"");
        }
        
    }
    
    public static class ParsingException extends Exception {
        
        public ParsingException(Token token) {
            super(" Unexpected token \""+ token.getValue().toString() + "\" of type \"" + token.getType().toString() + "\"");
        }
    }
}
