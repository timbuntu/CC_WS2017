/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim
 */
public class Lexer {
    private InputStream inStream;
    private List<SymbolTableEntry> symbolTable;

    public Lexer(InputStream inStream) {
        this.inStream = inStream;
        this.symbolTable = new ArrayList<>();
    }
    
    //public SymbolTableEntry getToken() {
        
    //}
    
}
