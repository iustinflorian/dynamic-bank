package Main;

import Main.bankAcc;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<bankAcc> v = new ArrayList<>();
        boolean k = true;
        Scanner sc = new Scanner(System.in);

        while (k) {
            System.out.println("Do you want to add an account? (Y/N)");
            System.out.println("If you want to abort press X");
            char input = sc.next().charAt(0);
            
            if (input == 'X') {
                k = false;
            } else {
                int index = v.size();
                op(input, sc, index, v);
            }
        }
    }

    public static void op(char input, Scanner sc, int index, ArrayList<bankAcc> v) {
        switch (input) {
            case 'N':
                System.out.print("Select account to use by ID: ");
                int i = sc.nextInt();
                if (i >= 0 && i < v.size()) {
                    System.out.println("What operation would you like to complete? (1-4)");
                    System.out.println("1. Check balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer"); // not done
                    char input2 = sc.next().charAt(0);
                    switch (input2) {
                        case '1':
                            System.out.println("Account balance: " + v.get(i).getBalance());
                            break;
                        case '2':
                            System.out.println("Sum to deposit: ");
                            int i2 = sc.nextInt();
                            v.get(i).deposit(i2);
                            System.out.println("Deposit successful. New balance: " + v.get(i).getBalance());
                            break;
                        case '3':
                            System.out.println("Sum to withdraw: ");
                            int i3 = sc.nextInt();
                            if (i3 <= v.get(i).getBalance()) {
                                v.get(i).withdraw(i3);
                                System.out.println("Withdrawal successful. New balance: " + v.get(i).getBalance());
                            } else {
                                System.out.println("Insufficient funds.");
                            }
                            break;
                        case '4':
                            System.out.println("Specify receiver by ID: ");
                            int i4 = sc.nextInt();
                            System.out.println("Transfer: "+v.get(i).firstName+" "+v.get(i).lastName+" -> "+v.get(i4).firstName+" "+v.get(i4).lastName);
                            break;
                        default:
                            System.out.println("ERROR: Unrecognized operation");
                            break;
                    }
                } 
                else {
                    System.out.println("ERROR: Invalid account index");
                }
                break;
            case 'Y':
                System.out.println("Add credentials");
                System.out.print("Generated ID: ");
                System.out.println(index);
                System.out.println("First name: ");
                String firstName = sc.next();
                System.out.println("Last name: ");
                String lastName = sc.next();
                System.out.println("Initial balance: ");
                int balance = sc.nextInt();
                sc.nextLine();
                bankAcc obj = new bankAcc(firstName, lastName, index, balance);
                v.add(index, obj);
                break;
            default:
                System.out.println("ERROR: Unrecognized operation");
                break;
        }
    }
}