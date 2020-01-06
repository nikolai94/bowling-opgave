package DTO;

import java.util.Arrays;

public class DTOGet {
    int[][] points;
    String token;

    public DTOGet(int[][] points, String token) {
        this.points = points;
        this.token = token;
    }

    public DTOGet() {
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints(int[][] points) {
        this.points = points;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DTOGet{" +
                "points=" + Arrays.toString(points) +
                ", token='" + token + '\'' +
                '}';
    }
}
