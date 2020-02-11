package com.company;


import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in); // глобальный скан

    public static void main(String[] args) {

        Random rand = new Random(); // локальная переменная
        String answer;

        do {
            System.out.println("What is your name?");
            String name = scan.next();
            System.out.println("Hello, " + name);

            int myNum = rand.nextInt(100) + 1;
            System.out.println("Cheat: " + myNum);

            for (int i = 0; i < 10; i++) {
                int userNum = askGuess();// локальная переменная


                if (myNum < userNum) {
                    System.out.println("My num is less then yours!");
                } else if (myNum > userNum) {
                    System.out.println("My num is greater then yours!");
                } else {
                    System.out.println("You WIN!");
                    break;
                }
            }
            System.out.println("DO you want play?");
            answer = scan.next();
        } while (answer.equals("yes"));
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
}