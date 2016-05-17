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
public class Event {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String location;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String audience;
    private String companylist;
    private String details;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Orginization ev;

    public Event(String name, String location, String audience, String companylist, String details) {
        this.name = name;
        this.location = location;
        this.audience = audience;
        this.companylist = companylist;
        this.details = details;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getCompanylist() {
        return companylist;
    }

    public void setCompanylist(String companylist) {
        this.companylist = companylist;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + ", location=" + location + ", time=" + date + ", audience=" + audience + ", companylist=" + companylist + ", details=" + details + '}';
    }
    
    public boolean equals(Event e){
        return name.equals(e.getName());
    }

    public Orginization getOrg() {
        return ev;
    }

    public void setOrg(Orginization org) {
        this.ev = org;
    }
}
