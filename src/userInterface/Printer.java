package userInterface;
public class Printer extends Ui {

    public static void printHangman(Integer lifes) {
        if (lifes <= 10) {
            System.out.println("  ___");
            System.out.println(" |   |");
        }
        if (lifes <= 6) {
            System.out.println(" |   o");
            System.out.println(" |  /|");
        }
        if (lifes <= 5) {
            System.out.println(" |   |");
            System.out.println(" |  /|");
        }
        if (lifes <= 3) {
            System.out.println(" |   ");
        }
        if (lifes <= 0) {
            System.out.println("/|   ");
            System.out.println("___   ");
        }
    }
}
