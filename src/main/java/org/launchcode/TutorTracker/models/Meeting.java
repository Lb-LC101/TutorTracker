package org.launchcode.TutorTracker.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meeting extends AbstractEntity{

    //variables
    @NotBlank(message = "Please select a date")
    @NotNull
    private String meetingDate;

    @Column(length = 65535, columnDefinition = "text")
    private String meetingNote;

    @ManyToOne
    private Student student;

    @ManyToMany
    private List<Book> books = new ArrayList<>();

    @ManyToMany
    //@ManyToMany(mappedBy = "meetings")
    private List<Sightword> sightwords = new ArrayList<>();

    //@ManyToMany(mappedBy = "meetings")
    @ManyToMany
    private List<Sightword> spellwords = new ArrayList<>();

    //constructors

    public Meeting(String meetingDate, String meetingNote, Student student, List<Book> books, List<Sightword> sightwords, List <Sightword> spellwords){
        this.meetingDate = meetingDate;
        this.meetingNote = meetingNote;
        this.student = student;
        this.books = books;
        this.sightwords = sightwords;
        this.spellwords = spellwords;
    }

    public Meeting() {
    }


    //methods

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void removeAllBooks(List<Book> books) {
        this.books.removeAll(books);
    }

    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }


    public void removeAllSightwords(List<Sightword> sightwords) {
        this.sightwords.removeAll(sightwords);
    }

    public void addSightwords(List<Sightword> sightwords) {
        this.sightwords.addAll(sightwords);
    }

    public void removeAllSpellwords(List<Sightword> spellwords) {
        this.spellwords.removeAll(spellwords);
    }

    public void addSpellwords(List<Sightword> spellwords) {
        this.spellwords.addAll(spellwords);
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Sightword> getSightwords() {
        return sightwords;
    }

    public void setSightwords(List<Sightword> sightwords) {
        this.sightwords = sightwords;
    }

    public List<Sightword> getSpellwords() {
        return spellwords;
    }

    public void setSpellwords(List<Sightword> spellwords) {
        this.spellwords = spellwords;
    }
}
