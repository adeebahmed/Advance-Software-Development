/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.aahmed22.aahmed22.mp3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author adeeb
 */
public class ResumeTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    Resume r = new Resume("/resumes/thisResume.pdf", "/cv/thisCv.pdf", new JobSeeker("Adeeb", "Ahmed", "Student at Illinois Institute of Technology", 
            "Chicago, IL", "Computer Science", "Internet Application Development", 3.29, 
            "aahmed22@hawk.iit.edu"));     
    
    @BeforeClass 
    public static void beforeEachClass(){
        emf = Persistence.createEntityManagerFactory("aahmed22PU");
    }
    @Before 
    public void beforeEachTestMethod(){
        em = emf.createEntityManager(); 
        tx = em.getTransaction();
    }
    
    @Test 
    public void createCompany() throws Exception{
        tx.begin();
        em.persist(r);
        tx.commit();
        assertNotNull("ID should not be null", r.getId()); //if there is an id then a Resume has been created in the database
        System.out.println("Resume 'Create' test passed;");
    }
   
    @Test 
    public void readCompany() throws Exception{ 
        r = em.find(Resume.class, 1l);
        //reading via tostring to see user accessible fields
        assertEquals(r.toString(), "Resume{id=1, resumefilepath=/resumes/newResume.pdf, cvfilepath=/cv/thisCv.pdf, date=null, "
                + "js=JobSeeker{id=1, firstname=Adeeb, lastname=Ahmed, headline=Student at Illinois Institute of Technology, "
                + "location=Chicago, IL, major=Computer Science, minor=Internet Application Development, gpa=3.29, "
                + "email=aahmed22@hawk.iit.edu, lastLogin=null}}");  //if the tostring matches expected output then read success.
        
        System.out.println("Resume 'Read' test passed;");
    }
    
     
    @Test
    public void updateCompany() throws Exception{
        r = em.find(Resume.class, 1l); //old info
        r.setResumefilepath("/resumes/newResume.pdf"); //new update info
        
        tx.begin();
        em.merge(r);
        tx.commit();

        //check to see if email updated
        assertEquals(r.getResumefilepath(), "/resumes/newResume.pdf");
        System.out.println("Resume 'Update' test passed;");
    }
   
    @Test 
    public void deleteCompany() throws Exception{
        r = em.find(Resume.class, 1l);
        tx.begin();
        em.remove(r);
        tx.commit();
        r = em.find(Resume.class, 1l);
        assertEquals(null, r); //if null then entity was sucessfully deleted
        System.out.println("Resume 'Delete' test passed;");
    }
    
    @After 
    public void afterEachTestMethod(){
        em.close();
    }
    
    @AfterClass 
    public static void afterEachClass() {
        emf.close();
    }
}
