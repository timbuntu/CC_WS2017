/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import cc_p1.Exceptions.*;

/**
 *
 * @author matti
 */
public class CC_P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<String> symbolTable = new ArrayList<>();

        if (args.length < 1) {
            System.exit(1);
        }

        String file = args[0];
        System.out.println(System.getenv("PWD"));
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CC_P1.class.getName()).log(Level.SEVERE, null, ex);
        }

        Lexer lexer = new Lexer(fileStream, symbolTable);
        try {
            while (lexer.getToken().getType() != Token.TokenType.EOF) {
            }
        } catch (UnknownLexemeException ex) {
            Logger.getLogger(CC_P1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
