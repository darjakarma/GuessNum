package com.company;

public class GameResult { //Домашка: как начать запись когда началась игра (с каких миллисекунд. нигде не выводиться, только запись в файл).Время  должно запоминаться в табло каждого участника
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
