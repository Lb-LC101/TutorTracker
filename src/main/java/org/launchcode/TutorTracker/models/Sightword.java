package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Sightword extends AbstractEntity {

    //variables
    @NotBlank
    @NotNull
    @Size(min=1, message = "Word is required")
    private String word;

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
}
