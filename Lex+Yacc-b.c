/* LEX FILE */
%{
#include "y.tab.h"
%}

%%
[a-zA-Z][a-zA-Z0-9]*   { return 1; }
.                      { return 0; }
%%

/* YACC FILE */
%{
#include<stdio.h>
%}

%%

S : ID { printf("Valid Variable\n"); }
  ;

%%

int main() {
    yyparse();
    return 0;
}

int yyerror() {
    printf("Invalid Variable\n");
    return 0;
}