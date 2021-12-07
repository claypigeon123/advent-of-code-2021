package com.cp.advent.challenges.day2.model.processing;

import lombok.Data;

@Data
public class Instruction {
    private final Command command;
    private final int value;

    public Instruction(String line) {
        String[] split = line.split(" ");
        command = Command.valueOf(split[0].toUpperCase());
        value = Integer.parseInt(split[1]);
    }
}
