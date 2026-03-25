#include<stdio.h>

int main() {
    char a, b, c, d;

    printf("Enter expression (a=b+c*d): ");
    scanf("%c=%c+%c*%c", &a, &b, &c, &d);

    printf("\nThree Address Code:\n");

    printf("t1 = %c * %c\n", c, d);
    printf("t2 = %c + t1\n", b);
    printf("%c = t2\n", a);

    return 0;
}