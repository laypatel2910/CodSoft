package Task_1;

import java.util.Scanner;
import java.lang.Math;
public class NUMBER_GAME {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Number Game");
        String playAgain = " ";
        int totalRounds = 0,totalScore = 0;
        do {
            byte userNumber, Attempts = 10;
            totalRounds++;
            System.out.println("I'm thinking of a number between 1 and 100 : ");
            int numberToGuess = (int) (Math.random() * 100);
            System.out.println("Tell Me What Number I Guess");
            do {
                System.out.println("You have " + Attempts + " attempts to guess it.");
                userNumber = scanner.nextByte();
                Attempts--;
                if (numberToGuess == userNumber) {
                    System.out.println(userNumber + " is correct \nYou Won Rounds in " + (10 - Attempts) + " Attempts.");
                    totalScore++;
                    break;
                } else if (numberToGuess < userNumber)
                    System.out.println(userNumber + " is too high");
                else
                    System.out.println(userNumber + " is too low");
            } while (Attempts >= 0);
            if (Attempts == -1) {
                System.out.println("Game Over \nThe correct number was " + numberToGuess +".");
            }
            System.out.println("Do you want to play another round? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase().trim();
            while (!playAgain.equals("yes") && !playAgain.equals("no")){
                System.out.println("Enter only Yes or No: ");
                playAgain = scanner.nextLine().toLowerCase().trim();
            }
        }while (!playAgain.equals("no"));
        System.out.println("You played " + totalRounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);    }
}
