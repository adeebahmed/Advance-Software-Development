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
public class JobRecruiterTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    JobRecruiter jr = new JobRecruiter("Lloyd", "Clausean", "Head recruiter for Target Interns", "Minniapolis, MN", "lloyd@target.com", "CS|CIS|ITM|CE|EE|ECE");     
    
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
        em.persist(jr);
        tx.commit();
        assertNotNull("ID should not be null", jr.getId()); //if there is an id then a jobrecrutier has been created in the database
        System.out.println("JobRecruiter 'Create' test passed;");
    }
    
    @Test 
    public void readCompany() throws Exception{ 
        jr = em.find(JobRecruiter.class, 1l);
        //reading via tostring to see user accessible fields
        assertEquals(jr.toString(), "JobRecruiter{id=1, firstname=Lloyd, lastname=Clausean, "
                + "headline=Head recruiter for Target Interns, location=Minniapolis, MN, "
                + "email=lloyd@targetrecruiting.com, lookingfor=CS|CIS|ITM|CE|EE|ECE, "
                + "lastLogin=null}"); //if the tostring matches expected output then read success
        
        System.out.println("JobRecruiter 'Read' test passed;");
    }
    
    @Test
    public void updateCompany() throws Exception{
        jr = em.find(JobRecruiter.class, 1l); //old info
        jr.setEmail("lloyd@targetrecruiting.com"); //new update info
        
        tx.begin();
        em.merge(jr);
        tx.commit();

        //check to see if email updated
        assertEquals(jr.getEmail(), "lloyd@targetrecruiting.com");
        System.out.println("JobRecruiter 'Update' test passed;");
    }
   
    @Test 
    public void deleteCompany() throws Exception{
        jr = em.find(JobRecruiter.class, 1l);
        tx.begin();
        em.remove(jr);
        tx.commit();
        jr = em.find(JobRecruiter.class, 1l);
        assertEquals(null, jr); //if null then entity was sucessfully deleted
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
