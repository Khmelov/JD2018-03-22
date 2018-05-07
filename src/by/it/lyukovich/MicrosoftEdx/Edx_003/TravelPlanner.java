package by.it.lyukovich.MicrosoftEdx.Edx_003;

import java.sql.Time;
import java.util.Date;
import static java.lang.Math.*;
import java.util.Scanner;

public class TravelPlanner {
    public static String name;
    private static String destname;
    private static int spendtime;
    private static int spendmoney;
    private static String currency;
    private static double exchange;
    private static int timediff;
    private static double destarea;
    private static double lgt;
    private static double ltd;
    private static double lgt1;
    private static double ltd1;
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    greetings();
    budgetIn();
    budgetCount();
    timeDiff();
    sqArea();
    distance();
    }
    private static void greetings(){
        System.out.print("Welcome to Vacation Planner!\nWhat is your name? ");
        name = sc.next();
        System.out.print("Nice to meet you " + name + ", where are you traveling to? ");
        destname = sc.next();
        System.out.print("Great! " + destname + " sounds like a great trip!\n***********\n");
        System.out.println();
    }
    private static void budgetIn(){
        System.out.print("How many days are you going to spend travelling? ");
        spendtime = sc.nextInt();
        System.out.print("What is their total budget for the trip in USD? ");
        spendmoney = sc.nextInt();
        System.out.print("What is the currency symbol for their destination? ");
        currency=sc.next();
        System.out.print("How many " + currency + " in 1 USD? ");
        exchange=sc.nextDouble();
        System.out.println();
        }
    private static void budgetCount(){
            System.out.println("If you are traveling for " +spendtime+ "days that is the same as " +(spendtime*24)+ " hours or " +
                    (spendtime*24*60)+ " minutes");
            System.out.println("If you are going to spend " + spendmoney + " USD, that means per day you can spend up to " +
                    (spendmoney/spendtime) + " USD, or per hour up to " + (spendmoney/spendtime/24) + " USD");
            System.out.printf("Your total budget in %s is %.2f %s, which per day is %.2f %s\n***********\n", currency, (spendmoney*exchange),
            currency, (spendmoney*exchange/24), currency);
        }
    private static void timeDiff(){
            System.out.print("What is the time difference, between your home and your destination? ");
            timediff=sc.nextInt();
            int a;
            int b;
            if (timediff<0){
                a=24+timediff;
                b=12+timediff;

            }
            else {
                a = 24 - timediff;
                b = 12 - timediff;
            }
            System.out.printf("That means that when it is midnight at home, it will be %s in your travel destination\n" +
                    "and when it is noon at home it will be %s\n", (a+":00"), (b+":00"));
        }
    private static void sqArea(){
            System.out.printf("What is the square area of %s in km2? ", destname);
            destarea=sc.nextDouble();
            System.out.println("In miles that is " + (int)(destarea/1.6));
            System.out.println("***********");
        }
    private static void distance(){
            System.out.println("Enter the longitude of you location");
            lgt=sc.nextDouble();
            System.out.println("Enter the latitude of you location");
            ltd=sc.nextDouble();
            System.out.println("Enter the longitude of you destination");
            lgt1=sc.nextDouble();
            System.out.println("Enter the latitude of you destination");
            ltd1=sc.nextDouble();
            System.out.printf("The distance between you and your destination country is %.2f km\n", findDistance(ltd, ltd1, lgt, lgt1));
        }
        /*
        Method finds a distance between 2 coordinates
        */
        private static double findDistance(double x1, double x2, double x3, double x4){
        double spherer=6371e3; //Earth radius
        double deltalat=toRadians(x2-x1); //Find latitude delta
        double deltalon=toRadians(x4-x3); //Find longitude delta
        double a = sin(deltalat/2) * sin(deltalat/2) + cos(toRadians(x1)) * cos(toRadians(x2)) *
                sin(deltalon/2) *sin(deltalon/2);
        double c = 2* atan2(sqrt(a), sqrt(1-a));
        double d= spherer*c;
        return d/1000; // in kms
        }

}
