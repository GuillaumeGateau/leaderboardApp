package com.example.leaderboardApp.utility;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;


import com.example.leaderboardApp.pages.Index;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;


@Entity
@Table(name="records")
public class Record {
    @Id
    @Column(name = "competitor_id", unique = true, nullable = false)
    public int hipchat_id;

    @Column(name = "count", nullable = false)
    public int dips;

    @Column(name = "date")
    public Date date = new Date();

    @Column(name = "time")
    public java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());



    public Record(){}

    public Record(int hipchat_id, int dips) {
        this.hipchat_id = hipchat_id;
        this.dips = dips;
    }
}
