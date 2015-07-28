package com.example.leaderboardApp.utility;

import javax.persistence.*;

import org.apache.tapestry5.beaneditor.Validate;
import com.example.leaderboardApp.pages.Index;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;


@Entity
@Table(name="competitors")
public class Competitor {
    @Id
    @Column(name="hipchat_id", unique=true, nullable=false)
    public int hipchat_id;

    @Column(name="name")
    @Validate("required")
    private String name;

    @Column(name="score")
    private int score;

    @Column(name="goal")
    private int goal = 14000;

    @Column(name="progress")
    private int progress = score/goal;

    public Competitor(){}

    public Competitor(int hipchat_id, String name, int dips) {
        this.hipchat_id = hipchat_id;
        this.name = name;
        this.score += dips;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public int getProgress() {
        return this.progress;
    }

    public void addReps(int repetitions) {
        this.score += repetitions;
    }


}
