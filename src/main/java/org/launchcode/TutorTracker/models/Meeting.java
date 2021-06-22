package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Meeting extends AbstractEntity{

    //variables
    private String meetingDate;
    private String meetingNote;

    @ManyToOne
    private Student student;

    //constructors

    public Meeting(String meetingDate, String meetingNote, Student student){
        this.meetingDate = meetingDate;
        this.meetingNote = meetingNote;
        this.student = student;
    }

    public Meeting() {
    }

    //getters and setters

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingNote() {
        return meetingNote;
    }

    public void setMeetingNote(String meetingNote) {
        this.meetingNote = meetingNote;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
