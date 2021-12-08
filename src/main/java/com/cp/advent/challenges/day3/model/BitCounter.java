package com.cp.advent.challenges.day3.model;

import lombok.Data;

@Data
public class BitCounter {
    private int trueCount;
    private int falseCount;

    public BitCounter() {
        trueCount = 0;
        falseCount = 0;
    }

    public void processBit(char bit) {
        if (bit == '1') trueCount++;
        else falseCount++;
    }
}
