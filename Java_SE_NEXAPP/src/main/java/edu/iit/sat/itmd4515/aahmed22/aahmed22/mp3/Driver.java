/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.aahmed22.aahmed22.mp3;

import javax.persistence.*;

/**
 *
 * @author adeeb
 */
public class Driver {
    
    public static void main(String... args){
        Company target = new Company("Target", "A leader in retail, focusing on technology.");
        JobRecruiter targetRecruiter = new JobRecruiter("Lloyd", "Clausen", "Head intern recruiter at Target!", "Minniapolis, MN", "lloyd@target.com", "CS|CIS|ITM|CE|EE|ECE");
       
        //targetRecruiter.setCompany(target); //set one side of the relationsip
        //target.getRecruiters().add(targetRecruiter); //set otherside of relationship
        
        target.addJobRecruiter(targetRecruiter);//or create an awesome helper method to do both 
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aahmed22PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(targetRecruiter);
        em.persist(target);

        tx.commit();
        
        //Company foundCompany = em.find(Company.class, 1l);
        //System.out.println("I found: " + foundCompany.toString());
        System.out.println("Company: " + targetRecruiter.getCompany().getCompanyName());
        System.out.println("Recruiters: " + target.getRecruiters());
        em.close();
        
        emf.close();
    }
}
