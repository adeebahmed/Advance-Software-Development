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
public class Resume {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resumefilepath;
    private String cvfilepath;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, unique = true)
    private JobSeeker js;

    public Resume() {
    }

    public Resume(String resumefilepath, String cvfilepath, JobSeeker js) {
        this.resumefilepath = resumefilepath;
        this.cvfilepath = cvfilepath;
        this.js = js;
    }

    public Resume(String resumefilepath) {
        this.resumefilepath = resumefilepath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumefilepath() {
        return resumefilepath;
    }

    public void setResumefilepath(String resumefilepath) {
        this.resumefilepath = resumefilepath;
    }

    public String getCvfilepath() {
        return cvfilepath;
    }

    public void setCvfilepath(String cvfilepath) {
        this.cvfilepath = cvfilepath;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Resume{" + "id=" + id + ", resumefilepath=" + resumefilepath + ", cvfilepath=" + cvfilepath + ", date=" + date + ", js=" + js + '}';
    }
    
    public boolean equals(JobSeeker j){
        String thisSeeker = js.getEmail();
        return thisSeeker.equals(j.getEmail());
    }
    
    public JobSeeker getJs() {
        return js;
    }

    public void setJs(JobSeeker js) {
        this.js = js;
    }
}
