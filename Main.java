import java.util.*;

class BankAccount {
    int accNo;
    String name;
    double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> list = new ArrayList<>();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1 Create Account");
            System.out.println("2 View Accounts");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Search Account");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    list.add(new BankAccount(accNo, name, balance));
                    System.out.println(" Account Created");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("⚠ No Accounts Found");
                    } else {
                        System.out.println("\nAccNo\tName\tBalance");
                        for (BankAccount b : list) {
                            System.out.println(b.accNo + "\t" + b.name + "\t" + b.balance);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int dAcc = sc.nextInt();

                    boolean depFound = false;
                    for (BankAccount b : list) {
                        if (b.accNo == dAcc) {
                            System.out.print("Enter Amount: ");
                            double amt = sc.nextDouble();
                            b.balance += amt;
                            depFound = true;
                            System.out.println(" Deposit Successful");
                        }
                    }
                    if (!depFound)
                        System.out.println(" Account Not Found");
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int wAcc = sc.nextInt();

                    boolean witFound = false;
                    for (BankAccount b : list) {
                        if (b.accNo == wAcc) {
                            System.out.print("Enter Amount: ");
                            double amt = sc.nextDouble();

                            if (amt <= b.balance) {
                                b.balance -= amt;
                                System.out.println(" Withdrawal Successful");
                            } else {
                                System.out.println(" Insufficient Balance");
                            }
                            witFound = true;
                        }
                    }
                    if (!witFound)
                        System.out.println(" Account Not Found");
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int sAcc = sc.nextInt();

                    boolean sFound = false;
                    for (BankAccount b : list) {
                        if (b.accNo == sAcc) {
                            System.out.println("Found - " + b.accNo + " " + b.name + " Balance: " + b.balance);
                            sFound = true;
                        }
                    }
                    if (!sFound)
                        System.out.println(" Account Not Found");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
