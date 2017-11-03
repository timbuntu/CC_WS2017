/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cc_p1.Exceptions.*;

/**
 *
 * @author matti
 */
public class LexerTest {

    public LexerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getToken method, of class Lexer.
     */
    @Test
    public void testGoodImportFile() throws Exception {
        System.out.println("getToken");
        String file = "/resources/good_import.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        while (lexer.getToken().getType() != Token.TokenType.EOF) {
        }
    }

    @Test(expected = UnknownLexemeException.class)
    public void testBadImportFile() throws Exception {
        System.out.println("getToken");
        String file = "/resources/bad_import.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        while (lexer.getToken().getType() != Token.TokenType.EOF) {
        }
    }

}
