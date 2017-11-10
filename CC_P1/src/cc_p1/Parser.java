/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import cc_p1.TokenDefinition.Keyword;
import cc_p1.TokenDefinition.Operator;
import java.util.List;

/**
 *
 * @author tim
 */
public class Parser {

    private final List<String> symbolTable;
    private final Lexer lexer;
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

        Node pkg = parsePackageClause();
        if (pkg == null) {
            throw new Exceptions.ParsingException(nextToken.getValue());
        }

        t.addNode(pkg);

        Node imprt = parseImportDecl();
        if (imprt != null) {
            t.addNode(imprt);
        }

        return t;
    }

    private Node parsePackageClause() throws Exception {

        Node t = new Node("PackageClause");
        
        if (nextToken.getType() == Token.TokenType.KEYWORD) {
            
            if (String.valueOf(nextToken.getValue()).matches(Keyword.k_package)) {
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

    private Node parsePackageName() throws Exception {

        Node t = new Node("PackageName");
        
        switch (nextToken.getType()) {
            case IDENTIFIER:
                t.addNode(new Leaf(nextToken));
                nextToken = lexer.getToken();
                return t;
        }

        return null;
    }

    private Node parseImportDecl() throws Exception {
        
        Node t = new Node("ImportDecl");
        
        if(nextToken.getType() == Token.TokenType.KEYWORD && String.valueOf(nextToken.getValue()).matches(Keyword.k_import)) {
            nextToken = lexer.getToken();
            switch(nextToken.getType()) {
                case OPERATOR:
                    if(String.valueOf(nextToken.getValue()).matches(Operator.l_left_bracket)) {
                        t.addNode(new Leaf(nextToken));
                        nextToken = lexer.getToken();
                        Node importSpec = null;
                        while((importSpec = parseImportSpec()) != null) {
                            t.addNode(importSpec);
                            if(String.valueOf(nextToken.getValue()).matches(Operator.l_semicolon)) {
                                t.addNode(new Leaf(nextToken));
                                nextToken = lexer.getToken();
                            } else {
                                throw new Exceptions.ParsingException(nextToken.getValue());
                            }
                        }
                        if(String.valueOf(nextToken.getValue()).matches(Operator.l_right_bracket)) {
                            t.addNode(new Leaf(nextToken));
                            nextToken = lexer.getToken();
                        } else {
                            throw new Exceptions.ParsingException(nextToken.getValue());
                        }
                    }
            }
            //Node importSpec = 
        }
        return null;
    }
    
    private Node parseImportSpec() throws Exception {
        
        Node t = new Node("ImportSpec");
        
        switch(nextToken.getType()) {
            case OPERATOR:
                if(String.valueOf(nextToken.getValue()).matches(Operator.l_dot)) {      //Create leaf
                    t.addNode(new Leaf(nextToken));
                    nextToken = lexer.getToken();
                    Node packageName = parsePackageName();
                    
                    if(packageName != null) {
                        nextToken = lexer.getToken();
                        Node importPath = parseImportPath();
                        
                        if(importPath != null) {
                            t.addNode(packageName);
                            t.addNode(importPath);
                            nextToken = lexer.getToken();
                        } else {
                            packageName.setName("ImportPath");
                            t.addNode(packageName);
                        }
                        
                        return t;
                    }
                }
        }
        
        return null;
    }
    
    private Node parseImportPath() throws Exception {

        Node t = new Node("ImportPath");
        
        switch (nextToken.getType()) {
            case IDENTIFIER:
                t.addNode(new Leaf(nextToken));
                nextToken = lexer.getToken();
                return t;
        }

        return null;
    }
}
