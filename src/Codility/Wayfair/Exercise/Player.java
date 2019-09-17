package Codility.Wayfair.Exercise;

import java.io.*;
import java.util.*;

public class Player {

    // Need to order scores...priority queue
    private List<Integer> scores;
    private Double average;

    public Player(List<Integer> scores) {
        this.scores = scores;
        average = 0.0;
    }

    // Add score to priority queue method
    public Double add_score(Integer score) {
        scores.add(score);
        average = calculateAverage();
        return average;
    }

    public Double calculateAverage() {
        average = 0.0;
        int size = scores.size();
        if (size == 0) {
            return average;
        }
        for (int i = 0; i < size; i++) {
            average += scores.get(i);
        }
        return average / size;
    }

    public Double getAverage() {
        return average;
    }

    // Reset...removes all scores
    public void reset() {
        scores.clear();
        average = 0.0;
    }
}
