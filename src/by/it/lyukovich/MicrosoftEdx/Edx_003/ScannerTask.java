package by.it.lyukovich.MicrosoftEdx.Edx_003;
import java.util.Scanner;

public class ScannerTask {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x;
        x=sc.nextInt();
        x*=2;
        System.out.println(x);

        String temp;
        String name;
        System.out.println("Hello!");
        temp=sc.nextLine();
        System.out.println("What is your name?");
        name = sc.nextLine();
        System.out.println("Nice to meet you " + name +"\nI don't have a name, how do you want to call me?");
        temp = sc.nextLine();
        while (temp.length()>5){
            System.out.println("It's too long name,pick me another one");
            temp = sc.nextLine();
        }
        System.out.println("Well, " + name +", now we're friends!");
        int age;
        System.out.println("How old are you?");
        System.out.printf("I'm " + sc.nextInt() + " years old");


    }
}
