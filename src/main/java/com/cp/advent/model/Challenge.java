package com.cp.advent.model;

import com.cp.advent.challenges.day1.Day1;

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
        System.out.println("# Solving day " + day);

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
        URL url = getClass().getClassLoader().getResource("inputs/day" + day + ".txt");
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
            is.close();
        } catch (IOException ignored) {}
    }

    public static Challenge ofDay(int day) {
        switch (day) {
            case 1: return new Day1();
            default: throw new NullPointerException();
        }
    }
}
