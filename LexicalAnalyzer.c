#include<stdio.h>
#include<ctype.h>
#include<string.h>

char keywords[10][10] = {
    "int","float","char","if","else",
    "while","for","return","void","printf"
};

int isKeyword(char str[]) {
    for(int i=0;i<10;i++) {
        if(strcmp(str, keywords[i])==0)
            return 1;
    }
    return 0;
}

int main() {
    char str[100];
    printf("Enter a line of code:\n");
    gets(str);

    int i=0;
    while(str[i] != '\0') {

        // Identifier or keyword
        if(isalpha(str[i])) {
            char temp[20];
            int j=0;

            while(isalnum(str[i])) {
                temp[j++] = str[i++];
            }
            temp[j]='\0';

            if(isKeyword(temp))
                printf("%s is Keyword\n", temp);
            else
                printf("%s is Identifier\n", temp);
        }

        // Number
        else if(isdigit(str[i])) {
            char temp[20];
            int j=0;

            while(isdigit(str[i])) {
                temp[j++] = str[i++];
            }
            temp[j]='\0';

            printf("%s is Constant\n", temp);
        }

        // Operator
        else if(strchr("+-*/=%", str[i])) {
            printf("%c is Operator\n", str[i]);
            i++;
        }

        // Special symbols
        else if(strchr("();{}", str[i])) {
            printf("%c is Special Symbol\n", str[i]);
            i++;
        }

        else {
            i++;
        }
    }

    return 0;
}