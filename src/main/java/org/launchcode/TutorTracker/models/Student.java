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

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String birthdate;
    private String note;

    @OneToMany (mappedBy = "student")
    private final List<Meeting> meetings = new ArrayList<>();

    //constructors
    public Student(String firstName, String lastName, String address1, String address2, String city, String state, String zip, String phone, String email, String birthdate, String note){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.note = note;

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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
