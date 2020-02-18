package com.company;

import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<GameResult> leaders = new ArrayList<>(); //" ящик для лидеров, т.е. тех, кто победил и количество его попыток"

    public void addLeader(GameResult gr) {
        leaders.add(gr);
    }
    public void printResults() {
        int maxLen = 0;
        for (GameResult r : leaders) {
            if (r.name.length() > maxLen) {
                maxLen = r.name.length();
            }
        }
        for (GameResult r : leaders) {
            System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.name, r.triesCount, r.gameTime / 1000.0);
        }
    }
}
