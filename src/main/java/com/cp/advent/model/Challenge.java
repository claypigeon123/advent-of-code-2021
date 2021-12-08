package com.cp.advent.model;

import com.cp.advent.challenges.day1.Day1;
import com.cp.advent.challenges.day2.Day2;
import com.cp.advent.challenges.day3.Day3;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Challenge {
    protected final int day;
    protected List<String> lines;

    protected Challenge(int day) {
        this.day = day;
    }

    protected abstract void solveFirst();
    protected abstract void solveSecond();

    public void solve() {
        System.out.printf("# Solving day %s\n", day);

        System.out.println("\n# Part 1");
        loadInput();
        solveFirst();

        System.out.println("\n# Part 2");
        loadInput();
        solveSecond();

        System.out.println();
    }

    protected void loadInput() {
        lines = new ArrayList<>();
        URL url = getClass().getClassLoader().getResource(String.format("inputs/day%s.txt", day));
        if (url == null) {
            return;
        }

        InputStream is;
        try {
            is = url.openStream();
        } catch (IOException e) {
            return;
        }

        Scanner scan = new Scanner(is);
        while (scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }

        try {
            scan.close();
            is.close();
        } catch (IOException ignored) {}
    }

    public static Challenge ofDay(int day) {
        switch (day) {
            case 1: return new Day1();
            case 2: return new Day2();
            case 3: return new Day3();
            default: throw new NullPointerException();
        }
    }
}
