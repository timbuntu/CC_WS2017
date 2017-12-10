/***********************
 * Example of C++ in Bison (yacc)
 * Compare Bison Manual, Section 10.1.6 A Complete C++ Example
 * https://www.gnu.org/software/bison/manual/html_node/A-Complete-C_002b_002b-Example.html
 * The Makefile has been simplified radically, but otherwise
 * everything here comes from the Bison source code (see also).
 * (This comment added by Prof. R. C. Moore, fbi.h-da.de)
 *
 * This is the yacc (bison) file, i.e. grammar file.
 * See also calc++-scanner.ll for the lexical scanner 
 * (flex input).
 *
 ***********************/

%skeleton "lalr1.cc" /* -*- C++ -*- */
%require "3.0.2"
%defines
%define parser_class_name {calcxx_parser}

%define api.token.constructor
%define api.value.type variant
%define parse.assert

%code requires
{
class calcxx_driver;
# include <string>
# include "Node.h"
# include "Leaf.h"
}

// The parsing context.
%param { calcxx_driver& driver }

%locations
%initial-action
{
  // Initialize the initial location.
  @$.begin.filename = @$.end.filename = &driver.file;
};

%define parse.trace
%define parse.error verbose

%code
{
# include "calc++-driver.hh"
# include <string>
# include "Node.h"
# include "Leaf.h"
}

%define api.token.prefix {TOK_}
%token
  END  0  "end of file"
  ASSIGN  ":="
  MINUS   "-"
  PLUS    "+"
  STAR    "*"
  SLASH   "/"
  LPAREN  "("
  RPAREN  ")"
  LCURLY  "{"
  RCURLY  "}"
  SEMIC   ";"
  EQUAL   "="
  NEQUAL   "!="
  PACKAGE "package"
  IMPORT  "import"
  FUNC    "func"
  DOT     "."
;

%token <std::string> IDENTIFIER "identifier"
%token <std::string> STRING "string"
%token <int> NUMBER "number"
%type  <Node*> exp
%type  <Node*> SourceFile
%type  <Node*> PackageClause
%type  <Node*> PackageName
%type  <Node*> ImportDecl
%type  <Node*> ImportDeclS
%type  <Node*> ImportSpec
%type  <Node*> ImportSpecS
%type  <Node*> TopLevelDecl
%type  <Node*> TopLevelDeclS
%type  <Node*> FunctionDecl
%type  <Leaf*> FunctionName
%type  <Leaf*> ImportPath



/* %printer { yyoutput << $$; } <*>; */

%%
%start unit;
/* unit: SourceFile  { driver.result = $2; }; */
/* unit: { driver.rootNode = new Node("SourceFile"); } SourceFile; */
unit: SourceFile;

/* assignments: */
/*   %empty                 {} */
/* | assignments assignment {}; */

/* assignment: */
/*   "identifier" ":=" exp { driver.variables[$1] = $3; }; */

/* %left "+" "-"; */
/* %left "*" "/"; */
%right "func" "import";

SourceFile:
  PackageClause { driver.rootNode.addNode($1);} ImportDeclS { driver.rootNode.copyNodes($3);} TopLevelDeclS { driver.rootNode.copyNodes($5);}


PackageClause:
  "package" PackageName { Node* ret = new Node("PackageName"); ret->addNode($2); $$ = ret;}
PackageName:
  "identifier"   { $$ = new Leaf("PackageName", $1);}

ImportDeclS:
  %empty {$$ = new Node("Empty ImportDeclS");}
  |ImportDeclS ImportDecl {Node* ret = new Node("ImportDeclS"); ret->copyNodes($1); ret->addNode($2); $$ = ret;}
  | ImportDecl {Node* ret = new Node("ImportDeclS");ret->addNode($1); $$ = ret;}
ImportDecl:
  "import" "(" ImportSpecS ")" {Node* ret = new Node("ImportDecl"); ret->addNode(new Leaf("Keyword", "import")); ret->copyNodes($3); $$ = ret;}
  | "import" ImportSpec  {Node* ret = new Node("ImportDecl");  ret->addNode(new Leaf("Keyword", "import")); ret->addNode($2); $$ = ret;}
ImportSpecS:
  ImportSpecS ImportSpec ";"  {Node* ret = new Node("ImportSpecS"); ret->copyNodes($1); ret->addNode($2); $$ = ret;}
  | ImportSpec ";"  { Node* ret = new Node("ImportSpecS"); ret->addNode($1); $$ = ret; }
ImportSpec:
  "." ImportPath {Node* ret = new Node("ImportSpec"); ret->addNode($2); $$ = ret;}
  | PackageName ImportPath {Node* ret = new Node("ImportSpec"); ret->addNode($1); ret->addNode($2); $$ = ret;}
  | ImportPath {Node* ret = new Node("ImportSpec"); ret->addNode($1); $$ = ret;}
ImportPath:
  STRING { $$ = new Leaf("ImportPath", $1) ; }


TopLevelDeclS:
  %empty {$$ = new Node("Empty ImportDeclS");}
  |TopLevelDeclS TopLevelDecl {Node* ret = new Node("TopLevelDeclS"); ret->copyNodes($1); ret->addNode($2); $$ = ret;}
  | TopLevelDecl {Node* ret = new Node("TopLevelDeclS"); ret->addNode($1); $$ = ret;}
TopLevelDecl:
  FunctionDecl {Node* ret = new Node("TopLevelDecl"); ret->addNode($1); $$ = ret;}
FunctionDecl:
  "func" FunctionName {Node* ret = new Node("FunctionDecl"); ret->addNode(new Leaf("Keyword", "func")); ret->addNode($2); $$ = ret;}
FunctionName:
  "identifier" { $$ = new Leaf("FunctionName", $1); }

/* exp: */
/*   exp "+" exp   { $$ = $1 + $3; } */
/* | exp "-" exp   { $$ = $1 - $3; } */
/* | exp "*" exp   { $$ = $1 * $3; } */
/* | exp "/" exp   { $$ = $1 / $3; } */
/* | "(" exp ")"   { std::swap ($$, $2); } */
/* | "identifier"  { $$ = driver.variables[$1]; } */
/* | "number"      { std::swap ($$, $1); }; */
%%

void yy::calcxx_parser::error (const location_type& l, const std::string& m) {
  driver.error (l, m);
}
