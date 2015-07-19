package com.example.leaderboardApp.components;

import java.util.ArrayList;

public class Competitor {
    private int hipchat_id;
    private String name;
    private ArrayList<Integer> reps = new ArrayList<Integer>();
    private int score;
    private int goal = 14000;
    private int progress = score/goal;

    public void create(int hipchat_id) {
        this.hipchat_id = hipchat_id;
    }

    public void create(int hipchat_id, String name) {
        this.hipchat_id = hipchat_id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addReps(int repetitions) {
        this.reps.add(repetitions);
        this.score += repetitions;
    }

    public int getScore() {
        return this.score;
    }

    public int getProgress() {
        return this.progress;
    }

    // public void writeToDB(){}
    // public void dbMatchesJava(){}
}
