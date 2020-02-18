package com.company;

public class GameResult {
    private String name;
    private int triesCount;
    private long gameTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTriesCount() {
        return triesCount;
    }

    public void setTriesCount(int triesCount) {
        this.triesCount = triesCount;
    }

    public long getGameTime() {
        return gameTime;
    }

    public void setGameTime(long gameTime) {
        this.gameTime = gameTime;
    }
}
