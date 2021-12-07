package com.cp.advent;

import com.cp.advent.model.Challenge;

import java.util.Scanner;

public class Entrypoint {
    public static void main(String[] args) {
        System.out.println("#  # # # # # # # # # # # # # # # # #");
        System.out.println("#       Advent of Code 2021        #");
        System.out.println("#           Zoltan Nagy            #");
        System.out.println("# https://github.com/claypigeon123 #");
        System.out.println("# # # # # # # # # # # # # # # # #  #");

        Scanner scan = new Scanner(System.in);

        System.out.print("\n# Choose a day to execute: ");
        int selection = scan.nextInt();
        scan.close();

        Challenge.ofDay(selection).solve();
    }
}
