package Task_2;

import java.util.Scanner;

public class STUDENT_GRADE_CALCULATOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to  Student Grade Calculator");
        System.out.println("How many Subject You Have : ");
        int[] Subject_Marks_Array = new int [scanner.nextByte()];
        int Sum = 0;
        String Grade = "";
        boolean isFail = false;
        for (int i  = 0 ; i < Subject_Marks_Array.length ; i++){
            Subject_Marks_Array[i] = 0;
            do{
                System.out.println((Subject_Marks_Array[i] > 100)?"Please Enter Less then 100 Marks : ":"Enter a Subject " + (i + 1) + " Marks : ");
                Subject_Marks_Array[i] = scanner.nextInt();
            }while (Subject_Marks_Array[i] > 100);
            Sum += Subject_Marks_Array[i];
        }
        float Percentage = (float) Sum /Subject_Marks_Array.length;
        System.out.println("no.\tMarks\tGrade");
        for (int i = 0 ; i < Subject_Marks_Array.length;i++){
            if(Subject_Marks_Array[i] < 40){
                Grade = "F";
                isFail = true;
            } else if (Subject_Marks_Array[i] >= 40 && Subject_Marks_Array[i] <= 45) {
                Grade = "D";
            } else if (Subject_Marks_Array[i] >= 46 && Subject_Marks_Array[i] <= 50) {
                Grade = "C";
            }else if (Subject_Marks_Array[i] >= 51 && Subject_Marks_Array[i] <= 55) {
                Grade = "B";
            }else if (Subject_Marks_Array[i] >= 56 && Subject_Marks_Array[i] <= 60) {
                Grade = "B+";
            }else if (Subject_Marks_Array[i] >= 61 && Subject_Marks_Array[i] <= 70) {
                Grade = "A";
            }else if (Subject_Marks_Array[i] >= 71 && Subject_Marks_Array[i] <= 80) {
                Grade = "A+";
            }else {
                Grade = "O";
            }
            System.out.println((i + 1) + "\t" + Subject_Marks_Array[i]+"\t\t" + Grade);
        }
        if(isFail){
            System.out.println("Total Sum : " + Sum + "\nPercentage : " + Percentage + "\nGrade : " + "Fail");
        }
        else {
            if (Percentage >= 40 && Percentage <= 45) {
                Grade = "D";
            } else if (Percentage >= 46 && Percentage <= 50) {
                Grade = "C";
            }else if (Percentage >= 51 && Percentage <= 55) {
                Grade = "B";
            }else if (Percentage >= 56 && Percentage <= 60) {
                Grade = "B+";
            }else if (Percentage >= 61 && Percentage <= 70) {
                Grade = "A";
            }else if (Percentage >= 71 && Percentage <= 80) {
                Grade = "A+";
            }else {
                Grade = "O";
            }
            System.out.println("Total Sum : " + Sum + "\nPercentage : " + Percentage + "\nGrade : " + Grade);
        }
    }
}
