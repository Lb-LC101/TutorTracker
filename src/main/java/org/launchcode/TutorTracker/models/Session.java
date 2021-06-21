package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Session extends AbstractEntity{

    //variables
    private String sessionDate;
    private String sessionNote;

    @ManyToOne
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
