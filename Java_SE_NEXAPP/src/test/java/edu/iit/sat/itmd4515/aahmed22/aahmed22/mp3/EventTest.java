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
public class EventTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    Event ev = new Event("IIT Career Fair", "Chicago, IL", "CS|CIS|ITM|CE|EE|ECE", "Target|Google|Microsoft|Goldman Sacchs", "Will be held in herman hall!");
    
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
        em.persist(ev);
        tx.commit();
        assertNotNull("ID should not be null", ev.getId()); //if there is an id then an orginization has been created in the database
        System.out.println("Event 'Create' test passed;");
    }
   
    @Test 
    public void readCompany() throws Exception{ 
        ev = em.find(Event.class, 1l);
        
        //reading via tostring to see user accessible fields
        assertEquals(ev.toString(), "Event{id=1, name=IIT Career Fair, location=Chicago, IL, time=null, "
                + "audience=CS|CIS|ITM|CE|EE|ECE, companylist=Target|Google|Microsoft|Goldman Sacchs, "
                + "details=Will be held in herman hall! From 12pm-5pm! Make sure to preregister!}");  //if the tostring matches expected output then read success
        
        System.out.println("Event 'Read' test passed;");
    }
    
    
    @Test
    public void updateCompany() throws Exception{
        ev = em.find(Event.class, 1l); //old company
        ev.setDetails("Will be held in herman hall! From 12pm-5pm! Make sure to preregister!"); //new update info
        
        tx.begin();
        em.merge(ev);
        tx.commit();

        //check to see if details updated
        assertEquals(ev.getDetails(), "Will be held in herman hall! From 12pm-5pm! Make sure to preregister!");
        System.out.println("Event 'Update' test passed;");
    }
   
    @Test 
    public void deleteCompany() throws Exception{
        ev = em.find(Event.class, 1l);
        tx.begin();
        em.remove(ev);
        tx.commit();
        ev = em.find(Event.class, 1l);
        assertEquals(null, ev); //if null then entity was sucessfully deleted
        System.out.println("Event 'Delete' test passed;");
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
