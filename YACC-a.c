%{
#include<stdio.h>
#define YYSTYPE double
%}

%token NUMBER
%left '+' '-'
%left '*' '/'

%%

expr:
      expr '+' expr { $$ = $1 + $3; }
    | expr '-' expr { $$ = $1 - $3; }
    | expr '*' expr { $$ = $1 * $3; }
    | expr '/' expr { $$ = $1 / $3; }
    | '(' expr ')'  { $$ = $2; }
    | NUMBER        { $$ = $1; }
    ;

%%

#include<ctype.h>

int yylex() {
    int c;
    while((c = getchar()) == ' ');

    if(isdigit(c)) {
        ungetc(c, stdin);
        scanf("%lf", &yylval);
        return NUMBER;
    }

    return c;
}

int main() {
    printf("Enter expression:\n");
    yyparse();
    return 0;
}

int yyerror() {
    printf("Invalid Expression\n");
    return 0;
}