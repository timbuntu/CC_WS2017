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
public class Parser {

    private List<String> symbolTable;
    private Lexer lexer;
    private Token nextToken;

    public Parser(Lexer lex, List<String> symbolTable) {
        this.symbolTable = symbolTable;
        this.lexer = lex;
    }

    public Node parse() throws Exception {

        nextToken = lexer.getToken();
        Node ast = parseSourceFile();

        return ast;
    }

    private Node parseSourceFile() throws Exception {

        Node t = new Node("SourceFile");

        Node pkg = parsePackage();
        if (pkg == null) {
            throw new Exception();
        }

        t.addNode(pkg);

        Node imprt = parseImport();
        if (imprt != null) {
            t.addNode(imprt);
        }

        return t;
    }

    private Node parsePackage() throws Exceptions.UnknownLexemeException {

        Node t = new Node("Package");
        
        if (nextToken.getType().toString().equals(Token.TokenType.KEYWORD.toString())) {
            
            if (String.valueOf(nextToken.getValue()).equals("package")) {
                t.addNode(new Leaf(nextToken));
                
                nextToken = lexer.getToken();
                Node pkgName = parsePackageName();
                if (pkgName == null) {
                    return null;
                } else {
                    t.addNode(pkgName);
                    return t;
                }

            }
        }

        return null;
    }

    private Node parsePackageName() throws Exceptions.UnknownLexemeException {

        Node t = new Node("PackageName");
        
        switch (nextToken.getType()) {
            case IDENTIFIER:
                t.addNode(new Leaf(nextToken));
                nextToken = lexer.getToken();
                return t;
        }

        return null;
    }

    private Node parseImport() {

        return null;
    }
}
