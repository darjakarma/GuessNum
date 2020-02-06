package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("Hello, " + name);

        int myNum = rand.nextInt(100) + 1;
        System.out.println("Cheat: " + myNum);

        for (int i = 0; i < 9; i++) {
            System.out.println("Enter your guess");
            int userNum = scan.nextInt();
        }

            if (myNum == userNum) {
                System.out.println("You WIN!");
            } break;
        }