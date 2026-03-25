#include<stdio.h>

int main() {
    int a, b;

    printf("Enter two constants: ");
    scanf("%d %d", &a, &b);

    // Constant Folding
    int result = a + b;

    printf("\nBefore Optimization: a + b\n");
    printf("After Optimization: %d\n", result);

    return 0;
}