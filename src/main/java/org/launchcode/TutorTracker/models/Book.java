package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends AbstractEntity {

    //variables
    @NotBlank
    @NotNull
    @Size(min=1, message = "Book name is required")
    private String bookName;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Book description is required")
    private String bookDescription;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Lesson name is required")
    private String lessonName;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Lesson description is required")
    private String lessonDescription;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Procedure name is required")
    private String procedureName;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Procedure description is required")
    private String procedureDescription;

    @ManyToMany(mappedBy = "books")
    private final List<Meeting> meetings = new ArrayList<>();

    //constructors

    //This part apparently is unnecessary - delete later
//    public Book(String bookName, String bookDescription){
//        this.bookName = bookName;
//        this.bookDescription = bookDescription;
//        this.lessonName = lessonName;
//        this.lessonDescription = lessonDescription;
//        this.procedureName = procedureName;
//        this.procedureDescription = procedureDescription;
//    }

    public Book() {
    }

    //getters and setters

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }
}
