package com.company;
import org.w3c.dom.ls.LSOutput;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in); // глобальный скан

    public static void main(String[] args) {
        Random rand = new Random(); // локальная переменная
        ArrayList<GameResult> leaders = new ArrayList<>(); //" ящик для лидеров, т.е. тех, кто победил и количество его попыток"
        boolean answer;

        do {
            System.out.println("What is your name?");
            String name = scan.next();
            long t1 = System.currentTimeMillis();
            System.out.println("Hello, " + name);

            int myNum = rand.nextInt(100) + 1;
            System.out.println("Cheat: " + myNum);
            for (int i = 0; i < 10; i++) {
                int userNum = askGuess();// локальная переменная

                if (userNum == myNum) {
                    long t2 = System.currentTimeMillis();
                    GameResult r = new GameResult();
                    r.name = name;
                    r.triesCount = i + 1;
                    r.gameTime = t2 -  t1;
                    leaders.add(r); //отправляет данные в "ящик"( кладем тот обьект который находился в переменной r.)
                    System.out.println("You WIN! Congratulations!");
                    break;
                }
                if (i == 9) {
                    System.out.println("You lost!");
                    break;
                }
                if (myNum < userNum) {
                    System.out.println("My num is less then yours!");
                } else {
                    System.out.println("My num is greater then yours!");
                }
            }
        } while (askAnotherGame()); // убрали лишнюю переменную методом boolean (см. пред. код!)
        for (GameResult r : leaders) {
            System.out.printf("%-10s %2d %8.1f sec %n" , r.name, r.triesCount, r.gameTime/1000.0);
        }
        System.out.println("Good bye!");
    }
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
}
