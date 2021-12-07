package com.cp.advent.challenges.day1;

import com.cp.advent.model.Challenge;

public class Day1 extends Challenge {

    private static final int PART_2_WINDOW_SIZE = 3;

    public Day1() {
        super(1);
    }

    @Override
    protected void solveFirst() {
        int increases = 0;
        int previous = Integer.parseInt(lines.get(0));

        for (int i = 1; i < lines.size(); i++) {
            int current = Integer.parseInt(lines.get(i));
            if (current > previous) {
                increases++;
            }

            previous = current;
        }

        System.out.printf("There are %s measurements that are larger than the previous measurement.\n", increases);
    }

    @Override
    protected void solveSecond() {
        int increases = 0;
        int previous = 0;
        for (int i = 0; i < PART_2_WINDOW_SIZE; i++) {
            previous += Integer.parseInt(lines.get(i));
        }

        for (int i = 1; i <= lines.size() - PART_2_WINDOW_SIZE; i++) {
            int current = 0;
            for (int k = i; k < i + PART_2_WINDOW_SIZE; k++) {
                current += Integer.parseInt(lines.get(k));
            }

            if (current > previous) {
                increases++;
            }

            previous = current;
        }

        System.out.printf("There are %s measurements in blocks of %s that are larger than the previous measurement.\n", increases, PART_2_WINDOW_SIZE);
    }
}
