package Task_3;

import java.util.Scanner;
class BankAccount {
    float balance;
    BankAccount(float balance){
        this.balance = balance;
    }
    public void saving_Account_Withdrawing(float withdrawing_Amount){
        if (withdrawing_Amount > 0 && withdrawing_Amount <= balance) {
            balance -= withdrawing_Amount;
            System.out.println("Successfully withdrew: $" + withdrawing_Amount);
        } else if (withdrawing_Amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void current_Account_Withdrawing(float withdrawing_Amount){
        if (withdrawing_Amount > 0 && withdrawing_Amount <= balance) {
            balance -= withdrawing_Amount;
            System.out.println("Successfully withdrew: $" + withdrawing_Amount);
        } else if (withdrawing_Amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void depositing_Account(float depositing_Amount){
        if (depositing_Amount > 0) {
            balance += depositing_Amount;
            System.out.println("Successfully deposited: $" + depositing_Amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void Check_Balance(){
        System.out.println("Your current balance is: $" + balance);
    }

}
public class ATM_INTERFACE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(20000);
        System.out.println("Welcome to Bank's ATM");
        float amount;
        byte Choice;
        do {
            System.out.println("What do you Want\n1 For Amount withdrawing\n2 For Amount depositing\n3 For Check Balance\n4 For Exit.");
            Choice = scanner.nextByte();
            switch (Choice) {
                case 1 :
                    System.out.println("Choose Account Type : \n1 for Saving Account \n2 for Current Account");
                    byte accountType = scanner.nextByte();
                    switch (accountType) {
                        case 1:
                            System.out.println("Enter a Amount : ");
                            amount = scanner.nextInt();
                            bankAccount.saving_Account_Withdrawing(amount);
                            break;
                        case 2:
                            System.out.println("Enter a Amount : ");
                            amount = scanner.nextInt();
                            bankAccount.current_Account_Withdrawing(amount);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter a Amount : ");
                    amount = scanner.nextInt();
                    bankAccount.depositing_Account(amount);
                    break;
                case 3:
                    bankAccount.Check_Balance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (Choice != 4);
    }
}
