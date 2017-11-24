%{
#include <iostream>
using namespace std;
// global value for int tokens
int yylval = 0;
typedef enum {
	EQ=0, NE, PLUS, MINUS, SEMICOLON,
	PRINT=100, WHILE, IDENT,
	NUMBER=200, STRING,
	UNKNOWN=999, FINISHED=999999 } tokenType;
%}
digit		[0-9]
letter		[a-zA-Z]

%%
"!="		{ return NE; }
"="		{ return EQ; }
"+"		{ return PLUS; }
"-"		{ return MINUS; }
";"		{ return SEMICOLON; }
"print"		{ return PRINT; }
"while"		{ return WHILE; }
{letter}({letter}|{digit})*	{ return IDENT; }
{digit}+			{ yylval = atoi(yytext); return NUMBER; }
[ \t\n\r]			/* skip whitespace */
.				{ cout << "Unknown character [" << yytext[0] << "]\n" ; return UNKNOWN; }
<<EOF>>				{ return FINISHED; }
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
