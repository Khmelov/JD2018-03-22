package by.it.lyukovich.MicrosoftEdx.Edx_003;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class IfElse {
    public static void main(String[] args) {
           /*   Scanner sc = new Scanner(System.in);
        evenOrOdd();
        String one;
        String two;
        System.out.print("Player 1, enter your pick: ");
        one=sc.nextLine();
        System.out.print("Player 2, enter your pick: ");
        two=sc.nextLine();
        fingerGameVar2(one,two);*/
calend();
    }

    public static void evenOrOdd(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Type a number ");
        int x=sc.nextInt();
        if (x%2==0) {
            System.out.println("even");
        } else {System.out.println("odd");}
    }
    public static void fingerGame(String x, String y){
        if((x.contains("paper") || x.contains("rock") || x.contains("scissors")) && (y.contains("paper") || y.contains("scissors") || y.contains("rock"))){
        if (x.equals("rock")){
            if(y.equals("scissors")){
                System.out.println("Player 1 wins!");}
            else if(y.equals("paper")) {System.out.println("Player 2 wins!");}
            else System.out.println("Spare!");
        }else if (x.equals("paper")){
            if(y.equals("scissors")){
                System.out.println("Player 2 wins!");}
            else if(y.equals("rock")) {System.out.println("Player 1 wins!");}
            else System.out.println("Spare!");
        }else if (x.equals("scissors")){
            if(y.equals("paper")){
                System.out.println("Player 1 wins!");}
            else if(y.equals("rock")) {System.out.println("Player 2 wins!");}
            else System.out.println("Spare!");
        }}else {System.out.println("One of the player didn't pick anything");}
    }

    public static void fingerGameVar2(String x, String y){
        if((x.contains("paper") || x.contains("rock") || x.contains("scissors")) && (y.contains("paper")
                || y.contains("scissors") || y.contains("rock"))){
        if (x.equals(y)){System.out.println("Spare!");
        }else if ((x.equals("rock") && y.equals("paper")) || (x.equals("paper") && y.equals("scissors"))
                || (x.equals("scissors") && y.equals("rock"))){
            System.out.println("Player 2 wins!");
        }else {System.out.println("Player 1 wins!");}
        }else {System.out.println("One of the player didn't pick anything");}
    }
    public static void calend() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a month: ");
        int x;
        x = input.nextInt();

        while (x < 0 || x >12) {
            System.out.print("Enter a month: ");
            x = input.nextInt();
        }
        System.out.printf("There are %d days in month", daysInMonth(x));
    }
        private static int daysInMonth(int month) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                return 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                return 30;
            }else return 28;
        }

    }


