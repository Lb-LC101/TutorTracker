package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Session extends AbstractEntity{

    //variables
    //private Date sessionDate;
    private String sessionDate;
    private String sessionNote;

    //constructors

    public Session(String sessionDate, String sessionNote){
        this.sessionDate = sessionDate;
        this.sessionNote = sessionNote;
    }

    public Session() {
    }

    //getters and setters


    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionNote() {
        return sessionNote;
    }

    public void setSessionNote(String sessionNote) {
        this.sessionNote = sessionNote;
    }
}
