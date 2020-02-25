package com.company;

public class GameResult { //Домашка: как начать запись когда началась игра (с каких миллисекунд. нигде не выводиться, только запись в файл).Время  должно запоминаться в табло каждого участника
    private long startTime;
    private String name;
    private int triesCount;
    private long time;
    //private long startTime;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getTriesCount() {
        return triesCount;
    }

    public void setTriesCount(int triesCount) {
        this.triesCount = triesCount;
    }

    public long getTime() { return time; }
    public void setTime(long time) { this.time = time; }

    public long getStartTime() { return startTime; }

    public void setStartTime(long startTime) { this.startTime = startTime; }

    //public long getStartTime() {  ???????????
     //   return startTime;
   // }

    //public void setStartTime(long startTime) {  ?????????????
     //   this.startTime = startTime;
   // }
}
