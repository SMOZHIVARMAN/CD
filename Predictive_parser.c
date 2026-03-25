#include <stdio.h>
#include <string.h>

char stack[50];
int top = -1;

void push(char c) {
    stack[++top] = c;
}

char pop() {
    return stack[top--];
}

int main() {
    char input[50];
    int i = 0;

    printf("Enter input string (end with $): ");
    scanf("%s", input);

    push('$');
    push('S'); // Start symbol

    while(top != -1) {
        char stackTop = stack[top];
        char current = input[i];

        // If match
        if(stackTop == current) {
            pop();
            i++;
        }
        // Example grammar: S → aSb | ε
        else if(stackTop == 'S' && current == 'a') {
            pop();
            push('b');
            push('S');
            push('a');
        }
        else if(stackTop == 'S' && current == 'b') {
            pop(); // ε production
        }
        else if(stackTop == '$' && current == '$') {
            printf("String Accepted\n");
            return 0;
        }
        else {
            printf("String Rejected\n");
            return 0;
        }
    }

    return 0;
}