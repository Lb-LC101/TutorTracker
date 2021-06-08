package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    //constructors
    public Book(String bookName, String bookDescription){
        this.bookName = bookName;
        this.bookDescription = bookDescription;
    }

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
}
