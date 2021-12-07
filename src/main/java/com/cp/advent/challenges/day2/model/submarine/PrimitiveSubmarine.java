package com.cp.advent.challenges.day2.model.submarine;

import com.cp.advent.challenges.day2.model.processing.Instruction;
import lombok.Data;

@Data
public class PrimitiveSubmarine implements Submarine {
    private int horizontalPosition;
    private int depth;

    public PrimitiveSubmarine() {
        horizontalPosition = 0;
        depth = 0;
    }

    public void execute(Instruction ins) {
        switch (ins.getCommand()) {
            case FORWARD:
                horizontalPosition += ins.getValue();
                break;
            case UP:
                depth -= ins.getValue();
                break;
            case DOWN:
                depth += ins.getValue();
                break;
            default:
                break;
        }
    }
}
