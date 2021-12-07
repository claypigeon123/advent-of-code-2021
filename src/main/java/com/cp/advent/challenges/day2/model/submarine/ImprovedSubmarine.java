package com.cp.advent.challenges.day2.model.submarine;

import com.cp.advent.challenges.day2.model.processing.Instruction;
import lombok.Data;

@Data
public class ImprovedSubmarine implements Submarine {
    private int horizontalPosition;
    private int depth;
    private int aim;

    public ImprovedSubmarine() {
        horizontalPosition = 0;
        depth = 0;
        aim = 0;
    }

    @Override
    public void execute(Instruction ins) {
        switch (ins.getCommand()) {
            case FORWARD:
                horizontalPosition += ins.getValue();
                depth += aim * ins.getValue();
                break;
            case UP:
                aim -= ins.getValue();
                break;
            case DOWN:
                aim += ins.getValue();
                break;
            default:
                break;
        }
    }
}
