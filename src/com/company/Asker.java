package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asker {
    static Scanner scan = new Scanner(System.in); // глобальный скан

    static boolean askAnotherGame() {
        for (; ; ) {
            System.out.println("Do you want play again? y/n");
            String answer = scan.next();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("You have to enter 'y' or 'n'");
            }
        }
    }

    static int askGuess() {
        for (; ; ) {
            try {
                System.out.println("Enter your guess");
                int num = scan.nextInt();
                if (num >= 1 && num <= 100) { // если условие перед ретурном - не будет работать!
                    return num;
                } else {
                    System.out.println("Please enter a number from 1 to 100");
                }
            } catch (InputMismatchException e) {
                String str = scan.next();
                System.out.println(str + " isn't a number");   // тоесть, пользователю "скажем - то что ты ввел str+ не является чилом!))
            }
        }
    }

    public static String askUserName() {
        System.out.println("What is your name?");
        return scan.next();
    }
}
