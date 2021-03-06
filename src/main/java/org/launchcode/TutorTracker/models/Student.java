package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends AbstractEntity {

    //variables
    @NotBlank
    @NotNull
    @Size(min=1, message = "First name is required")
    private String firstName;

    @NotBlank
    @NotNull
    @Size(min=1, message = "Last name is required")
    private String lastName;

    @OneToMany (mappedBy = "student")
    private final List<Meeting> meetings = new ArrayList<>();

    //constructors
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
