#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct sym {
    char label[20];
    int addr;
};

struct sym table[50];
int size = 0;

int search(char l[]) {
    for(int i = 0; i < size; i++) {
        if(strcmp(table[i].label, l) == 0)
            return i;
    }
    return -1;
}

void insert() {
    char l[20];
    int addr;

    printf("Enter label: ");
    scanf("%s", l);

    if(search(l) != -1) {
        printf("Duplicate symbol!\n");
        return;
    }

    printf("Enter address: ");
    scanf("%d", &addr);

    strcpy(table[size].label, l);
    table[size].addr = addr;
    size++;

    printf("Inserted successfully\n");
}

void display() {
    printf("\nLABEL\tADDRESS\n");
    for(int i = 0; i < size; i++) {
        printf("%s\t%d\n", table[i].label, table[i].addr);
    }
}

void modify() {
    char l[20];
    int addr;

    printf("Enter label to modify: ");
    scanf("%s", l);

    int pos = search(l);
    if(pos == -1) {
        printf("Not found\n");
        return;
    }

    printf("Enter new address: ");
    scanf("%d", &addr);

    table[pos].addr = addr;
    printf("Updated successfully\n");
}

int main() {
    int choice;

    do {
        printf("\n1.Insert\n2.Display\n3.Search\n4.Modify\n5.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1: insert(); break;
            case 2: display(); break;
            case 3: {
                char l[20];
                printf("Enter label: ");
                scanf("%s", l);
                if(search(l) != -1)
                    printf("Found\n");
                else
                    printf("Not Found\n");
                break;
            }
            case 4: modify(); break;
        }
    } while(choice != 5);

    return 0;
}