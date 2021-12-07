package com.cp.advent.challenges.day2;

import com.cp.advent.challenges.day2.model.processing.Instruction;
import com.cp.advent.challenges.day2.model.submarine.ImprovedSubmarine;
import com.cp.advent.challenges.day2.model.submarine.PrimitiveSubmarine;
import com.cp.advent.challenges.day2.model.submarine.Submarine;
import com.cp.advent.model.Challenge;

public class Day2 extends Challenge {

    public Day2() {
        super(2);
    }

    @Override
    protected void solveFirst() {
        Submarine sub = new PrimitiveSubmarine();
        processInstructions(sub);
    }

    @Override
    protected void solveSecond() {
        Submarine sub = new ImprovedSubmarine();
        processInstructions(sub);
    }

    private void processInstructions(Submarine sub) {
        for (String line : lines) {
            Instruction ins = new Instruction(line);
            sub.execute(ins);
        }

        System.out.printf("The submarine ended up with a horizontal position of %s and a depth of %s.\n", sub.getHorizontalPosition(), sub.getDepth());
        System.out.printf("Their product is %s.\n", sub.getHorizontalPosition() * sub.getDepth());
    }
}
