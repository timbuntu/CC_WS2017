/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import cc_p1.Exceptions.*;
import cc_p1.TokenDefinition.*;

/**
 *
 * @author tim
 */
public class Lexer {
    private Scanner inStreamScanner;
    private List<String> symbolTable;

    public Lexer(InputStream inStream, List<String> symbolTable) {
        this.inStreamScanner = new Scanner(inStream);
        this.inStreamScanner.useDelimiter(Pattern.compile(" "));
        this.symbolTable = symbolTable;
    }
    
    public Token getToken() throws UnknownLexemeException {
        
        if(!inStreamScanner.hasNext())
            return new Token(Token.TokenType.EOF, true);
        
        String lexeme = inStreamScanner.next();
        Token.TokenType type = null;
        Object value = null;
        
        if(cc_p1.TokenDefinition.Identifier.match(lexeme)) {
            type = Token.TokenType.IDENTIFIER;
            int index = symbolTable.indexOf(lexeme);
            if(index == -1) {
                symbolTable.add(lexeme);
                index = symbolTable.size()-1;
            }
                
            value = index;
                
        } else if(StringLiteral.match(lexeme)) {
            type = Token.TokenType.STRING_LITERAL;
            value = lexeme;
            
        } else if(Keyword.match(lexeme)) {
            type = Token.TokenType.KEYWORD;
            value = lexeme;
            
        } else if(IntLiteral.match(lexeme)) {
            type = Token.TokenType.INT_LITERAL;
            value = Integer.valueOf(lexeme);
            
        } else if(FloatLiteral.match(lexeme)) {
            type = Token.TokenType.FLOAT_LITERAL;
            value = Float.valueOf(lexeme);
            
        } else if(Operator.match(lexeme)) {
            type = Token.TokenType.OPERATOR;
            value = lexeme;
            
        } else {
            throw new UnknownLexemeException();
        }
        
        return new Token(type, type.getType().cast(value));
        
    }
    
}
