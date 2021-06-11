package org.launchcode.TutorTracker.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class SightWord extends AbstractEntity {

    //variables
    private String sightWord;

    //constructors

    public SightWord(String sightWord){
        this.sightWord = sightWord;

    }

    public SightWord() {
    }

    //getters and setters


    public String getSightWord() {
        return sightWord;
    }

    public void setSightWord(String sightWord) {
        this.sightWord = sightWord;
    }
}
