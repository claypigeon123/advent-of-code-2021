package com.cp.advent.challenges.day3.model;

public enum Diagnostic {
    OXYGEN_GENERATOR_RATING('1', '0'),
    CO2_SCRUBBER_RATING('0', '1');

    private final char prevailingBit;
    private final char fallbackBit;

    Diagnostic(char prevailingBit, char fallbackBit) {
        this.prevailingBit = prevailingBit;
        this.fallbackBit = fallbackBit;
    }

    public char getPrevailingBit() {
        return prevailingBit;
    }

    public char getFallbackBit() {
        return fallbackBit;
    }
}
