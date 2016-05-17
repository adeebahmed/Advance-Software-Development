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
public class JobSeekerTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    JobSeeker js = new JobSeeker("Adeeb", "Ahmed", "Student at Illinois Institute of Technology", 
            "Chicago, IL", "Computer Science", "Internet Application Development", 3.29, 
            "aahmed22@hawk.iit.edu");     
    
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
        em.persist(js);
        tx.commit();
        assertNotNull("ID should not be null", js.getId()); //if there is a is then a jobseeker has been created in the database
        System.out.println("JobSeeker 'Create' test passed;");
    }
   
    @Test 
    public void readCompany() throws Exception{ 
        js = em.find(JobSeeker.class, 1l);
        //reading via tostring to see user accessible fields
        assertEquals(js.toString(), "JobSeeker{id=1, firstname=Adeeb, lastname=Ahmed, "
                + "headline=Student at Illinois Institute of Technology, location=Chicago, IL, "
                + "major=Computer Science, minor=Internet Application Development, gpa=3.29, "
                + "email=adeeb.ahmed1005@gmail.com, lastLogin=null}");  //if the tostring matches expected output then read success
        
        System.out.println("JobSeeker 'Read' test passed;");
    }
    
     
    @Test
    public void updateCompany() throws Exception{
        js = em.find(JobSeeker.class, 1l); //old info
        js.setEmail("adeeb.ahmed1005@gmail.com"); //new update info
        
        tx.begin();
        em.merge(js);
        tx.commit();

        //check to see if email updated
        assertEquals(js.getEmail(), "adeeb.ahmed1005@gmail.com");
        System.out.println("JobSeeker 'Update' test passed;");
    }
   
    @Test 
    public void deleteCompany() throws Exception{
        js = em.find(JobSeeker.class, 1l);
        tx.begin();
        em.remove(js);
        tx.commit();
        js = em.find(JobSeeker.class, 1l);
        assertEquals(null, js); //if null then entity was sucessfully deleted
        System.out.println("JobRecruiter 'Delete' test passed;");
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
