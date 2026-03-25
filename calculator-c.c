/* LEX FILE */
%{
#include "y.tab.h"
#include<stdlib.h>
%}

%%
[0-9]+ { yylval = atoi(yytext); return NUMBER; }
[+\-*/] { return yytext[0]; }
\n { return 0; }
%%

/* YACC FILE */
%{
#include<stdio.h>
%}

%token NUMBER

%%

E : E '+' E { printf("Result = %d\n", $1 + $3); }
  | E '*' E { printf("Result = %d\n", $1 * $3); }
  | NUMBER
  ;

%%

int main() {
    printf("Enter expression:\n");
    yyparse();
    return 0;
}