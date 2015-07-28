package com.example.leaderboardApp.pages;

import java.util.*;

import com.example.leaderboardApp.utility.Competitor;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.apache.tapestry5.annotations.Property;



public class Index {
    @Property
    private Competitor competitor;

    @Inject
    private Session session;
    public Collection<Competitor> getCompetitors()
    {
        return session.createCriteria(Competitor.class).list();
    }

}