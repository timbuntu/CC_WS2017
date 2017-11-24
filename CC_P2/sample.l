%{
#include <iostream>
#include <string>
using namespace std;
// global value for int tokens
int yylval = 0;
string yystring = "";

typedef enum {
    EQ=0, NE, PLUS, MINUS, SEMICOLON, L_PAREN, R_PAREN, L_CURLY, R_CURLY,
    PACKAGE=100, IMPORT, IDENT, FUNC,
    NUMBER=200, STRING_LIT,
    UNKNOWN=999, FINISHED=999999 } tokenType;
%}
digit       [0-9]
letter      [a-zA-Z]
string_lit  ^[\"`][^\"']*[\"`]$


%%
"!="        { return NE; }
"="     { return EQ; }
"+"     { return PLUS; }
"-"     { return MINUS; }
";"     { return SEMICOLON; }
"("     { return L_PAREN; }
")"     { return R_PAREN; }
"{"     { return L_CURLY; }
"}"     { return R_CURLY; }
"package"       { return PACKAGE; }
"import"        { return IMPORT; }
"func"          { return FUNC; }
{letter}({letter}|{digit})* { return IDENT; }
{digit}+            { yylval = atoi(yytext); return NUMBER; }
{string_lit}    { return STRING_LIT; } 
[ \t\n\r]           /* skip whitespace */
.               { cout << "Unknown character [" << yytext[0] << "]\n" ; return UNKNOWN; }
<<EOF>>             { return FINISHED; }
%%

int yywrap(void) { return 1; }
int main( int argc, char *argv[] ) {
    yyin = ( ( 2 == argc ) ? fopen( argv[1], "r" ) : stdin );
    /* Call the lexer, then quit. */
    int tok = -1;
    while ( tok != FINISHED ) {
        tok = yylex();
        cout << "Token = " << tok<< ",\t last value of yylval = " << yylval
        << endl;
    };
    return 0;
}
