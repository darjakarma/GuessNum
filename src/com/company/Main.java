package com.company;


import java.util.Random;

public class Main {
static LeaderBoard leaderBoard = new LeaderBoard();

    public static void main(String[] args) {
        leaderBoard.load();
        Random rand = new Random(); // локальная переменная
        boolean answer;

        do {
            String name = Asker.askUserName();
            long t1 = System.currentTimeMillis();
            System.out.println("Hello, " + name);

            int myNum = rand.nextInt(100) + 1;
            System.out.println("Cheat: " + myNum);
            for (int i = 0; i < 10; i++) {
                int userNum = Asker.askGuess();// локальная переменная

                if (userNum == myNum) {
                    long t2 = System.currentTimeMillis();
                    GameResult r = new GameResult();
                    r.setName(name);
                    r.setTriesCount(i + 1);
                    r.setGameTime(t2 - t1);
                    //r.setStartTime (t1);
                    leaderBoard.addLeader(r);    //отправляет данные в "ящик"( кладем тот обьект который находился в переменной r.)
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
        } while (Asker.askAnotherGame());
//        for (GameResult r : leaders) {
//            System.out.printf("%-10s %2d %8.1f sec %n" , r.name, r.triesCount, r.gameTime/1000.0);
//        }

        leaderBoard.printResults();
        leaderBoard.save();
        System.out.println("Good bye!");
    }

}