#include<stdio.h>

int main() {
    char op;
    char a, b, c;

    printf("Enter TAC (example: t1=a+b): ");
    scanf("%*[^=]=%c%c%c", &a, &op, &b);

    printf("\nAssembly Code:\n");

    printf("MOV %c, R0\n", a);

    switch(op) {
        case '+':
            printf("ADD %c, R0\n", b);
            break;
        case '-':
            printf("SUB %c, R0\n", b);
            break;
        case '*':
            printf("MUL %c, R0\n", b);
            break;
        case '/':
            printf("DIV %c, R0\n", b);
            break;
    }

    printf("MOV R0, RESULT\n");

    return 0;
}