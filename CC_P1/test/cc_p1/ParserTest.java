/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tim
 */
public class ParserTest {

    public ParserTest() {
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
    public void testGoodPackageFile() throws Exception {
        System.out.println("testGoodPackageFile");
        String file = "/resources/good_package.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }

    @Test(expected = Exception.class)
    public void testBadPackageFile() throws Exception {
        System.out.println("testBadPackageFile");
        String file = "/resources/bad_package.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }

    @Test
    public void testGoodImportFile() throws Exception {
        System.out.println("testGoodImportFile");
        String file = "/resources/good_import.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }

    @Test
    public void testGoodImportFile2() throws Exception {
        System.out.println("testGoodImportFile2");
        String file = "/resources/good_import_package.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }

    @Test
    public void testGoodImportFile3() throws Exception {
        System.out.println("testGoodImportFile3");
        String file = "/resources/good_import_punctation.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }
    
    @Test(expected = Exceptions.ParsingException.class)
    public void testBadImportFile2() throws Exception {
        System.out.println("testBadImportFile2");
        String file = "/resources/bad_import_2.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }
    
    @Test(expected = Exceptions.ParsingException.class)
    public void testBadImportFile3() throws Exception {
        System.out.println("testBadImportFile3");
        String file = "/resources/bad_import_3.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }
    
    @Test(expected = Exceptions.ParsingException.class)
    public void testBadImportFile4() throws Exception {
        System.out.println("testBadImportFile4");
        String file = "/resources/bad_import_4.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }
    
    @Test(expected = Exceptions.ParsingException.class)
    public void testBadImportFile5() throws Exception {
        System.out.println("testBadImportFile5");
        String file = "/resources/bad_import_5.go";
        List<String> symbolTable = new ArrayList<>();

        InputStream fileStream = this.getClass().getResourceAsStream(file);
        Lexer lexer = new Lexer(fileStream, symbolTable);

        Parser parser = new Parser(lexer, symbolTable);
        parser.parse();
    }
}
