/** This class is responsible for taking input from user
and prints in the console*/
package userInterface;
import java.util.Scanner;


public class Ui {


    public static Long printResult(String capital, String country, Long elipsedTime) {
        System.out.println("Hurra! Thats true");
        System.out.println(capital.substring(0, 1).toUpperCase() + capital.substring(1).toLowerCase() + " is capital of "+country+".");

        System.out.println("Time your attempt took " + elipsedTime + " sec");
        return elipsedTime;
    }

    public static String getInput() {
        Scanner scanner = getScanner();
        String toCheck = scanner.nextLine();
        return toCheck;
    }
    private static Scanner getScanner() {
        Scanner reader = new Scanner(System.in);
        return reader;
    }
    public static Character getChar() {
        Scanner scanner = getScanner();
        Character letter = scanner.next().charAt(0);
        return letter;
    }
    public static void printEmpty() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public static void printMenu() {
        Ui.printEmpty();
        System.out.println("Insert word to guess whole word at once ");
        System.out.println("Insert one letter to find capitol by letter ");
        System.out.println("0. For exit");
    }
    public static Integer chooseLevel() {
        Integer levelOption  = 0;
        System.out.println("For easy with A-C countries choose 1");
        System.out.println("For medium with A-M countries choose 2");
        System.out.println("For hard with A-Z countries choose 3");
        System.out.println("Press any other for exit");
        String level = Ui.getInput();
        if (level.equals("1")) {
            levelOption = 34; //number of line to get from countries file
        } else if (level.equals("2")) {
            levelOption = 110; //number of line to get from countries file
        } else if (level.equals("3")) {
            levelOption = 183;
        } else {System.exit(0);}
        return levelOption;
    }

    public static Long measureTime(Long startTime){
        Long elipsedTime = System.nanoTime() - startTime; // time players attempt took
        Double elipsedTimeInSec = elipsedTime.doubleValue() / 1000000000.0; // convert time in nanoseconds to seconds
        Long endTime = elipsedTimeInSec.longValue();
        return endTime;
    }

    public static Boolean playAgain(){
        Boolean again = false;
        System.out.println("Do you want to play again?");
        System.out.println("Press 'yes' for again, any other for exit");
        String playerWill = Ui.getInput();
        if (playerWill.equals("yes")) {
            again = true;
        }
        return again;
    }
}
