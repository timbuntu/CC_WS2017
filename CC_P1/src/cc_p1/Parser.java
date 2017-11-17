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
            throw new Exceptions.ParsingException(nextToken);
        }

        t.addNode(pkg);
        
        //TODO: Put in while
        Node imprt = parseImportDecl();
        while (imprt != null) {
            t.addNode(imprt);
            imprt = parseImportDecl();
        }
        
        Node topLevelDecl = null;
        while((topLevelDecl = parseTopLevelDecl()) != null) {
            t.addNode(topLevelDecl);
        }
        
        if(nextToken.getType() != Token.TokenType.EOF)
            throw new Exceptions.ParsingException(nextToken);
        
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

        if (nextToken.getType() == Token.TokenType.KEYWORD && String.valueOf(nextToken.getValue()).matches(Keyword.k_import)) {
            nextToken = lexer.getToken();
            switch (nextToken.getType()) {
                case OPERATOR:
                    if (String.valueOf(nextToken.getValue()).matches(Operator.l_left_bracket)) {
                        t.addNode(new Leaf(nextToken));
                        nextToken = lexer.getToken();
                        Node importSpec = null;
                        while ((importSpec = parseImportSpec()) != null) {
                            t.addNode(importSpec);
                            if (String.valueOf(nextToken.getValue()).matches(Operator.l_semicolon)) {
                                t.addNode(new Leaf(nextToken));
                                nextToken = lexer.getToken();
                            } else {
                                throw new Exceptions.ParsingException(nextToken);
                            }
                        }
                        if (String.valueOf(nextToken.getValue()).matches(Operator.l_right_bracket)) {
                            t.addNode(new Leaf(nextToken));
                            nextToken = lexer.getToken();
                        } else {
                            throw new Exceptions.ParsingException(nextToken);
                        }
                    }
                    break;

                default:
                    Node importSpec = parseImportSpec();
                    if (importSpec == null) {
                        throw new Exceptions.ParsingException(nextToken);
                    }
                    t.addNode(importSpec);
                    nextToken = lexer.getToken();
            }

            return t;
        }
        return null;
    }

    private Node parseImportSpec() throws Exception {

        Node t = new Node("ImportSpec");

        switch (nextToken.getType()) {
            case OPERATOR:
                if (String.valueOf(nextToken.getValue()).matches(Operator.l_dot)) {
                    t.addNode(new Leaf(nextToken));
                    nextToken = lexer.getToken();

                    Node importPath = parseImportPath();

                    if (importPath != null) {
                        t.addNode(importPath);
                        return t;
                    } else {
                        throw new Exceptions.ParsingException(nextToken);
                    }
                }
                break;

            case IDENTIFIER:
                Node packageName = parsePackageName();
                if (packageName != null) {
                    t.addNode(packageName);
                }

                Node importPath = parseImportPath();

                if (importPath != null) {
                    t.addNode(importPath);
                    return t;
                } else {
                    throw new Exceptions.ParsingException(nextToken);
                }
        }

        Node importPath = parseImportPath();

        if (importPath != null) {
            t.addNode(importPath);
            return t;
        } else {
            return null;
        }
    }

    private Node parseImportPath() throws Exception {

        Node t = new Node("ImportPath");

        switch (nextToken.getType()) {
            case STRING_LITERAL:
                t.addNode(new Leaf(nextToken));
                nextToken = lexer.getToken();
                return t;
        }

        return null;
    }
    
    private Node parseTopLevelDecl() throws Exception {
        
        Node t = new Node("TopLevelDecl");
        
        //TODO: implement Declaration + MethodDecl
        Node functionDecl = null;
        if((functionDecl = parseFunctionDecl()) != null) {
            t.addNode(functionDecl);
            return t;
        }
        
        return null;
            
    }
    
    private Node parseFunctionDecl() throws Exception {
        
        Node t = new Node("FunctionDecl");
        
        if(nextToken.getType() == Token.TokenType.KEYWORD && String.valueOf(nextToken.getValue()).matches(Keyword.k_func)) {
            t.addNode(new Leaf(nextToken));
            nextToken = lexer.getToken();
            
            Node functionName = parseFunctionName();
            if(functionName == null) {
                throw new Exceptions.ParsingException(nextToken);
            } else {
                t.addNode(functionName);
                return t;
            }
        }
        
        return null;
    }
    
    private Node parseFunctionName() throws Exception {

        Node t = new Node("FunctionName");

        switch (nextToken.getType()) {
            case IDENTIFIER:
                t.addNode(new Leaf(nextToken));
                nextToken = lexer.getToken();
                return t;
        }

        return null;
    }
}
