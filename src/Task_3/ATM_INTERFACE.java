package Task_3;

import java.util.Scanner;
class ATM_Machine{
    int total_Amount;
    ATM_Machine(int total_Amount){
        this.total_Amount = total_Amount;
    }
    public void saving_Account_Withdrawing(int withdrawing_Amount){
        total_Amount -= withdrawing_Amount;
    }
    public void current_Account_Withdrawing(int withdrawing_Amount){
        total_Amount -= withdrawing_Amount;
    }
}
public class ATM_INTERFACE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM_Machine atm_machine = new ATM_Machine(20000);
        System.out.println("Welcome to Bank's ATM\nWhat do you Want\n1 For Amount withdrawing\n2 For Amount depositing\n3 For Check Balance\n4 For Exit.");
        byte Choice = scanner.nextByte();
        int amount;
        if (Choice == 1) {
            System.out.println("Choose Account Type : \n1 for Saving Account \n2 for Current Account");
            byte accountType = scanner.nextByte();
            switch (accountType) {
                case 1:
                    System.out.println("Enter a Amount : ");
                    amount = scanner.nextInt();
                    atm_machine.saving_Account_Withdrawing(amount);
                case 2:
                    System.out.println("Enter a Amount : ");
                    amount = scanner.nextInt();
                    atm_machine.current_Account_Withdrawing(amount);
            }
        }
    }
}
