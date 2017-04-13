/* This class is responsible for starting the program.
It defines options available for user > searching letter or whole word */

import db.MyFileWriter;
import models.Capital;
import models.User;
import operators.Converter;
import operators.Validator;
import userInterface.Printer;
import userInterface.Ui;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Capital cap = new Capital(); //creates object which stores searched values
        System.out.println("Enter your name : ");
        String name = Ui.getInput();
        User user = new User(name); //creates user object
        Integer level = Ui.chooseLevel(); // prints levels options and chooseLevel
        TreeMap<String, String> capitals = cap.createMap(); //loads capitols from a file
        Boolean game = true;
        while (game) {

            //set value of player lifes according to choosen difficulty
            if (level == 34) {
                user.setLifes(12);
            } else if (level == 110) {
                user.setLifes(10);
            } else if (level == 183) {
                user.setLifes(6);

            }
            Integer lifes = user.getLifes();
            String country = cap.getRandomCountry(capitals, level);
            cap.setCountry(country);
            String randomCapitalToFind = cap.getRandomCapital(country, capitals);
            cap.setSearchedCapital(randomCapitalToFind);

            System.out.println(user.getName() + ", whats the capital of "+country+" ?");

            String hiddenCap = Converter.convertToDashes(randomCapitalToFind);//hide answer in dashes

            // get random capitol and change to uppercase
            Boolean win = false;
            ArrayList<String> wrongLetters = new ArrayList<>();
            Long startTime = System.nanoTime(); //start counting time
            while (lifes > 0 && !win) {

                System.out.println(hiddenCap);
                Ui.printEmpty(); //print empty lines for better visability
                Ui.printMenu(); // print menu options
                String option = Ui.getInput();

                //section with guessing whole word at once
                if (option.length()>1) {
                    System.out.println("Provide capital of: "+country);
                    String userTry = Converter.converterToUp(option); //change to uppercase
                    if (Validator.validateWord(userTry, randomCapitalToFind)) {
                        Ui.printEmpty();
                        win = true;
                        Long elipsedTime = Ui.measureTime(startTime);
                        Long score = Ui.printResult(randomCapitalToFind, country, elipsedTime);
                        MyFileWriter.writeToFile(user.getName(), elipsedTime);
                        game = Ui.playAgain();
                    } else {
                        lifes-=2;
                        Printer.printHangman(lifes);
                        if (lifes>0) {
                            System.out.println("Nope. Your've got "+ lifes +" left.");
                        }   else {
                            System.out.println("You've lost. We were looking for " +
                            randomCapitalToFind.substring(0, 1).toUpperCase() +
                            randomCapitalToFind.substring(1).toLowerCase()+".");

                            game = Ui.playAgain();
                        }
                    }
                //section when user guess just one letter
            } else if (option.length() == 1 && (!option.equals("0"))) {
                    System.out.println("Wrong letters >>> " + wrongLetters);
                    System.out.println("Guess by letter:");
                    Character letter = Converter.convertCharacterToUp(option.charAt(0));
                    //get one letter from user input and change to uppercase

                    if (Validator.validateChar(letter, randomCapitalToFind)) {
                        hiddenCap = Validator.findChar(letter, hiddenCap, randomCapitalToFind);
                        if (!hiddenCap.contains("_")) {
                            Ui.printEmpty();
                            win = true;
                            Long elipsedTime = Ui.measureTime(startTime);
                            Long score = Ui.printResult(randomCapitalToFind, country, elipsedTime);
                            MyFileWriter.writeToFile(user.getName(), elipsedTime);
                            game = Ui.playAgain();
                        }
                    } else {
                        wrongLetters.add(Character.toString(letter));
                        lifes-=1;
                        Ui.printEmpty();
                        Printer.printHangman(lifes);
                        System.out.println("Wrong letters >>> " + wrongLetters);
                        if (lifes>0) {
                            System.out.println("Nope. Your've got "+ lifes +" left.");

                        }   else {
                            System.out.println("You've lost. We were looking for " +
                            randomCapitalToFind.substring(0, 1).toUpperCase() +
                            randomCapitalToFind.substring(1).toLowerCase()+".");
                            game = Ui.playAgain();
                        }
                    }
                } else if (option.equals("0")) {System.exit(0);}
            }
        }
    }
}
