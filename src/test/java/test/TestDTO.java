package test;

import entities.Frame;

public class TestDTO {
    Frame[] frames;
    int[] expectedResult;

    public TestDTO(Frame[] frames, int[] expectedResult) {
        this.frames = frames;
        this.expectedResult = expectedResult;
    }

    public Frame[] getFrames() {
        return frames;
    }

    public int[] getExpectedResult() {
        return expectedResult;
    }
}
