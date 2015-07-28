package com.example.leaderboardApp.pages;

import com.example.leaderboardApp.utility.Competitor;
import com.example.leaderboardApp.utility.Record;
import org.apache.tapestry5.annotations.RequestParameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.*;
import org.hibernate.sql.Select;


public class Ws {
    @ActivationRequestParameter("hipchat_id") private int hipchat_id;
    @ActivationRequestParameter("name") private String name;
    @ActivationRequestParameter("dips") private int dips;

    @Property
    private Competitor competitor;

    @Inject
    private Session session;

    @SetupRender
    @CommitAfter
    void appUpdate() {
        if (session.get(Competitor.class, hipchat_id) == null) {
            session.saveOrUpdate(new Competitor(hipchat_id, name, dips));
            session.save(new Record(hipchat_id, dips));
        } else {
            Competitor dbCompetitor = (Competitor) session.get(Competitor.class, hipchat_id);
            dbCompetitor.addReps(dips);
            session.saveOrUpdate(dbCompetitor);
            session.save(new Record(hipchat_id, dips));
        }
    }

}
