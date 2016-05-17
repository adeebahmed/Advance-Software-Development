/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.aahmed22.aahmed22.mp3;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author adeeb
 */
@Entity
public class JobSeeker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String headline;
    private String location;
    private String major;
    private String minor;
    private double gpa;
    @Column(nullable = false, unique = true)
    private String email;
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    
    @OneToOne(mappedBy="js")
    private Resume resume;

    public JobSeeker(String firstname, String lastname, String headline, String location, String major, String minor, double gpa, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.headline = headline;
        this.location = location;
        this.major = major;
        this.minor = minor;
        this.gpa = gpa;
        this.email = email;
    }

    public JobSeeker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "JobSeeker{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", headline=" + headline + ", location=" + location + ", major=" + major + ", minor=" + minor + ", gpa=" + gpa + ", email=" + email + ", lastLogin=" + lastLogin + '}';
    }
    
    public boolean equals(JobSeeker js){
        return email.equals(js.getEmail());
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
