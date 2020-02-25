package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LeaderBoard {
    public static final File FILE = new File("tablo.txt");
    private ArrayList<GameResult> leaders = new ArrayList<>(); //" ящик для лидеров, т.е. тех, кто победил и количество его попыток"

    public void addLeader(GameResult gr) {
        leaders.add(gr);
    }

    public void printResults() {
        //1 вариант) int maxLen = 0;
        //for (GameResult r : leaders) {
          //  maxLen = Math.max(maxLen, r.getName().length());
        // }
        int maxLen = leaders.stream()
                .mapToInt(r -> r.getName().length())
                .max()
                .orElse(0);

        //2 вариант) leaders.sort(Comparator.comparing(GameResult::getTriesCount)//   меняет порядок элементов списка
                               // .thenComparing(GameResult::getGameTime));

        //3 вариант) int count = 0;
        //for (GameResult r : leaders) {
        //  System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getGameTime() / 1000.0);
        //  count++;
        //  if (count < 5) {
        //   break;
        //  }
        // }

        //4 вариант) for (int i = 0; i < Math.min(leaders.size(), 5); i++) {// Когда нужно установить не меньше чего то но не точно
          //  GameResult r = leaders.get(i);
            // System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getGameTime() / 1000.0);
        // }

        leaders.stream()
        .sorted(Comparator.comparing(GameResult::getTriesCount)
                .thenComparing(GameResult::getTime))
                .limit(5)
                .forEach(r -> System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getTime() / 1000.0));
                //   меняет порядок элементов списка
        //                               // .thenComparing(GameResult::getGameTime));

    }

   public void load() {
        File file = new File ("tablo.txt"); //свалится джава, ибо нет longa  1 колонке
            try (Scanner in = new Scanner(FILE)) {
            while (in.hasNext()) {
                long startTime = in.nextLong();
                String name = in.next();
                int triesCount = in.nextInt();
                long time = in.nextLong();
                // long t1 = in.nextLong(); ???????????

                GameResult r = new GameResult();
                r.setStartTime(startTime);
                r.setName(name);
                r.setTriesCount(triesCount);
                r.setTime(time);
                //r.setStartTime(t1); //19/02/2020   ????????????????

              //  leaders.add(r); сохранить нашу переменную -r- (первый вапиант)
                addLeader(r);
            }
        } catch (IOException e) {
                System.out.println("Cannot load leaderboard. Creating new.");
        }
    }
    public void save () {
        File file = new File("tablo.txt");
            try (PrintWriter out = new PrintWriter(FILE)) {
            for (GameResult r : leaders) {
                out.printf("%d %s %d %d%n", r.getStartTime(), r.getName(), r.getTriesCount(), r.getTime());            }
        } catch (IOException e) {
                System.out.println("Cannot save leaderboard. Your results may be lost.");
        }
    }
}
