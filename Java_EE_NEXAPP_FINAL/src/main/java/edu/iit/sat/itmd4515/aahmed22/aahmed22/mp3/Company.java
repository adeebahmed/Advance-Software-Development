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
public class Company {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String companyname;
    private String info;
    
    @OneToMany(mappedBy="company") //one company can have mutiple job recrutiers 
    private List<JobRecruiter> recruiters = new ArrayList<>();

    public Company() {
    }
    
    public Company(String name, String info) {
        this.companyname = name;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyname;
    }

    public String getInfo() {
        return info;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompanyName(String name) {
        this.companyname = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + companyname + ", info=" + info + '}';
    }
    
    public boolean equals(Company c){
        return companyname.equals(c.getCompanyName());
    }

    public List<JobRecruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(List<JobRecruiter> recruiters) {
        this.recruiters = recruiters;
    }
    
    public void addJobRecruiter(JobRecruiter jr){
        if(! recruiters.contains(jr)){
            recruiters.add(jr);
        }
       jr.setCompany(this);
    }
}
