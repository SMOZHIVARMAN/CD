import java.util.*;

class Symbol {
    String label;
    int address;

    Symbol(String l, int a) {
        label = l;
        address = a;
    }
}

public class SymbolTable {
    static ArrayList<Symbol> table = new ArrayList<>();

    static int search(String label) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).label.equals(label))
                return i;
        }
        return -1;
    }

    static void insert(Scanner sc) {
        System.out.print("Enter label: ");
        String label = sc.next();

        if (search(label) != -1) {
            System.out.println("Duplicate symbol!");
            return;
        }

        System.out.print("Enter address: ");
        int addr = sc.nextInt();

        table.add(new Symbol(label, addr));
        System.out.println("Inserted successfully");
    }

    static void display() {
        System.out.println("\nLABEL\tADDRESS");
        for (Symbol s : table) {
            System.out.println(s.label + "\t" + s.address);
        }
    }

    static void modify(Scanner sc) {
        System.out.print("Enter label to modify: ");
        String label = sc.next();

        int pos = search(label);
        if (pos == -1) {
            System.out.println("Not found");
            return;
        }

        System.out.print("Enter new address: ");
        int addr = sc.nextInt();

        table.get(pos).address = addr;
        System.out.println("Updated successfully");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Insert\n2.Display\n3.Search\n4.Modify\n5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insert(sc); break;
                case 2: display(); break;
                case 3:
                    System.out.print("Enter label: ");
                    String l = sc.next();
                    if (search(l) != -1)
                        System.out.println("Found");
                    else
                        System.out.println("Not Found");
                    break;
                case 4: modify(sc); break;
            }
        } while (choice != 5);

        sc.close();
    }
}