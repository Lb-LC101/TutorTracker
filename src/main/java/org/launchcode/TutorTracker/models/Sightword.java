package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sightword extends AbstractEntity {

    //variables
    @NotBlank
    @NotNull
    @Size(min=1, message = "Word is required")
    private String word;

    @ManyToMany(mappedBy = "sightwords")
   // @ManyToMany
    private final List<Meeting> meetings = new ArrayList<>();


    //constructors

    public Sightword(String word){
       this.word = word;
    }
    public Sightword(){
    }

    //getters and setters


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
