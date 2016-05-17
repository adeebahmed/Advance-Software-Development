/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.aahmed22.aahmed22.mp3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author adeeb
 */
@Entity
public class Orginization {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String location;
    private String details;
    
    @OneToMany(mappedBy="ev") //one orginization can have many events
    private List<Event> events = new ArrayList<>();
    

    public Orginization() {
    }

    public Orginization(String name, String location, String details) {
        this.name = name;
        this.location = location;
        this.details = details;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Orginization{" + "id=" + id + ", name=" + name + ", location=" + location + ", details=" + details + '}';
    }
    
    public boolean equals(Orginization o){
        return name.equals(o.getName());
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    public void addEvents(Event ev){
        if(! events.contains(ev)){
            events.add(ev);
        }
        ev.setOrg(this);
    }
}
