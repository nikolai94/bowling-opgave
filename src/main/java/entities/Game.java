package entities;

import java.util.Arrays;

public class Game {
    private String token;
    private Frame[] frames;

    public Game(String token, Frame[] frames) {
        this.token = token;
        this.frames = frames;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    @Override
    public String toString() {
        return "Game{" +
                "token='" + token + '\'' +
                ", frames=" + Arrays.toString(frames) +
                '}';
    }
}
