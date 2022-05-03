package pckg;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AUX_CLS {


    static Scanner scanner = new Scanner(System.in);
    static int guessTries = 0;
    static int correctAnswers = 0;
    static double correctPercentage = 0;
    static int gamesPlayed = 0;

    public static String[] countries = {"Albania", "Australia", "Argentina", "Bahamas", "Belgium", "BiH", "Brazil",
            "Bulgaria", "Chile", "Croatia", "Canada", "Colombia", "Cuba", "Cyprus", "Denmark", "Dominican Republic",
            "Egypt", "Ecuador", "Estonia", "Finland", "France", "Germany", "Ghana", "Greece", "Hungary", "India",
            "Iran", "Jordan", "Kenya", "Latvia", "Luxembourg", "Madagascar", "Malta", "Mexico", "Montenegro",
            "Morocco", "Nepal", "Netherlands", "New Zealand", "North Korea", "Norway", "Panama", "Pakistan",
            "Paraguay", "Qatar", "Romania", "San Marino", "Samoa", "Singapore", "Sudan", "Tanzania", "Uganda",
            "Venezuela", "Vietnam", "Slovenia", "Poland", "Slovakia", "United States of America", "United Kingdom",
            "Senegal", "Uganda", "Yemen", "Laos", "Papua New Guinea"};

    public static String getRandomCountry() {
        int index = ThreadLocalRandom.current().nextInt(0, 63);
        String rndCntry = countries[index];
        //System.out.println("Random country is: " + rndCntry);
        return rndCntry;
    }

    public static String printGuessFields() {
        String cntry = getRandomCountry();
        String[] separate = cntry.split("");
        int k = ThreadLocalRandom.current().nextInt(1, 5);
        System.out.println("What country is this?");
        for (String slovo : separate) {
            if (slovo.contains(" ")) {
                System.out.print("% ");
            } else {
                if (k < 3) {
                    System.out.print(slovo + " ");
                } else {
                    System.out.print("_ ");
                }
                k = ThreadLocalRandom.current().nextInt(1, 5);
            }
        }
        //System.out.println(cntry);
        System.out.println("\n" + "Your answer: ");
        String answer = scanner.nextLine();
        while (answer.equals(cntry) == false) {
            //System.out.println(answer);
            System.out.println("Please try again.");
            System.out.println("Your answer: ");
            answer = scanner.nextLine();
            guessTries += 1;
        }
        guessTries +=1;
        System.out.println("Congratulations!!! Your answer is correct!");
        gamesPlayed +=1;
        correctAnswers +=1;
        correctPercentage = (double) (((double)correctAnswers) / ((double)guessTries)) * 100;
        System.out.println("You had " + correctAnswers + " correct answers in " + guessTries + " tries.");
        System.out.println("That is " + correctPercentage + "% accuracy.");
        System.out.println("Games played: " + gamesPlayed);
        return null;
    }

    public static void playGuessGame() {
        printGuessFields();
        System.out.println("To continue please enter Y, to quit game please enter N: ");
        String nastavak = scanner.nextLine();
        while (nastavak.equals("Y") == true) {
            printGuessFields();
            System.out.println("To continue please enter Y, to quit game please enter N: ");
            nastavak = scanner.nextLine();
        } if (nastavak.equals("N") == true) {
            System.out.println("You have quited the game!");
        }
    }
}

