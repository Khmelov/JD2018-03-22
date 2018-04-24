package by.it.lyukovich.MicrosoftEdx.Edx_002;
/*Methods*/

public class ControlFlow {
    public static void main(String[] args) {
        afBake();
        System.out.println("Step 1:\n");
        afCook();
        System.out.println("Step 2:\n");
        afTurnOnOwen();
        System.out.println("Step 3:\n");
        afTurnOffOwen();
        System.out.println();
        System.out.println("Your cookies are ready!");


    }
    private static void afBake(){
        System.out.println("Instructions to make cookies\n");

    }
    private static void afTurnOnOwen(){
        System.out.println("Turn on the owen at 240 degrees");
        System.out.println("Put your cookies in the owen");
        System.out.println("Cooking for 15 minutes\n");

    }
    private static void afTurnOffOwen(){
        System.out.println("Turn off the owen");
        System.out.println("Wait for 5 minutes");
        System.out.println("Put out your cookies\n");
    }

    private static void afCook(){
        System.out.println("Make a cookies");
        System.out.println("Add a topping\n");
    }
}
