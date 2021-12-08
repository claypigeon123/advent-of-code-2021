package com.cp.advent.challenges.day3;

import com.cp.advent.challenges.day3.model.BitCounter;
import com.cp.advent.model.Challenge;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day3 extends Challenge {

    public Day3() {
        super(3);
    }

    @Override
    protected void solveFirst() {
        Map<Integer, BitCounter> frequencies = findFrequencies(lines);
        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();

        for (int i = 0; i < frequencies.size(); i++) {
            BitCounter counter = frequencies.get(i);
            if (counter.getTrueCount() > counter.getFalseCount()) {
                gammaBuilder.append("1");
                epsilonBuilder.append("0");
            } else {
                gammaBuilder.append("0");
                epsilonBuilder.append("1");
            }
        }

        int gamma = Integer.parseInt(gammaBuilder.toString(), 2);
        int epsilon = Integer.parseInt(epsilonBuilder.toString(), 2);
        int product = gamma * epsilon;

        System.out.printf("With a gamma of %s and an epsilon of %s, their product (and the answer to the puzzle) is: %s\n", gamma, epsilon, product);
    }

    @Override
    protected void solveSecond() {
        List<String> remaining = new ArrayList<>(lines);
        AtomicInteger pos = new AtomicInteger(-1);
        do {
            pos.incrementAndGet();
            BitCounter counter = findFrequencyInPosition(remaining, pos.intValue());
            char winner = counter.getTrueCount() >= counter.getFalseCount() ? '1' : '0';
            remaining = remaining.stream()
                .filter(s -> s.charAt(pos.intValue()) == winner)
                .collect(Collectors.toList());
        } while (remaining.size() > 1);
        int oxygen = Integer.parseInt(remaining.stream().findFirst().orElseThrow(), 2);

        remaining = new ArrayList<>(lines);
        pos.set(-1);
        do {
            pos.incrementAndGet();
            BitCounter counter = findFrequencyInPosition(remaining, pos.intValue());
            char winner = counter.getTrueCount() >= counter.getFalseCount() ? '0' : '1';
            remaining = remaining.stream()
                .filter(s -> s.charAt(pos.intValue()) == winner)
                .collect(Collectors.toList());
        } while (remaining.size() > 1);
        int co2 = Integer.parseInt(remaining.stream().findFirst().orElseThrow(), 2);

        System.out.printf("With an oxygen generator rating of %s and a CO2 scrubber rating of %s, their product (and the answer to the puzzle) is: %s\n", oxygen, co2, oxygen * co2);
    }

    private Map<Integer, BitCounter> findFrequencies(List<String> input) {
        final int len = input.stream().findFirst().orElseThrow().length();
        Map<Integer, BitCounter> frequencies = new HashMap<>();

        for (int i = 0; i < len; i++) {
            BitCounter counter = findFrequencyInPosition(input, i);
            frequencies.put(i, counter);
        }
        return frequencies;
    }

    private BitCounter findFrequencyInPosition(List<String> input, int pos) {
        BitCounter counter = new BitCounter();
        for (String line : input) {
            char ch = line.charAt(pos);
            counter.processBit(ch);
        }
        return counter;
    }
}
