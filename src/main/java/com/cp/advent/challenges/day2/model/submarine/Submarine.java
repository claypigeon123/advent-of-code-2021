package com.cp.advent.challenges.day2.model.submarine;

import com.cp.advent.challenges.day2.model.processing.Instruction;


public interface Submarine {
    void execute(Instruction ins);

    int getHorizontalPosition();

    int getDepth();
}
