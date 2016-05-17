/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.aahmed22.aahmed22.mp3;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author adeeb
 */
@Entity
public class JobRecruiter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String headline;
    private String location;
    @Column(nullable = false, unique = true)
    private String email;
    private String lookingfor;
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    
    @ManyToOne(cascade = CascadeType.ALL) //job recruiter can only be working for one company
    private Company company;

    public JobRecruiter(String firstname, String lastname, String headline, String location, String email, String lookingfor) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.headline = headline;
        this.location = location;
        this.email = email;
        this.lookingfor = lookingfor;
    }

    public JobRecruiter() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLookingfor() {
        return lookingfor;
    }

    public void setLookingfor(String lookingfor) {
        this.lookingfor = lookingfor;
    }
    
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "JobRecruiter{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", headline=" + headline + ", location=" + location + ", email=" + email + ", lookingfor=" + lookingfor + ", lastLogin=" + lastLogin + '}';
    }
    
    public boolean equals(JobRecruiter jr){
        return email.equals(jr.getEmail());
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}
