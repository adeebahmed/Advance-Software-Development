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
public class OrginizationTest {
    
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    Orginization org = new Orginization("IEEE", "Chicago, IL", "IEEE Annual networking seminar and social.");     
    
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
        em.persist(org);
        tx.commit();
        assertNotNull("ID should not be null", org.getId()); //if there is an id then an orginization has been created in the database
        System.out.println("Orginization 'Create' test passed;");
    }
   
    @Test 
    public void readCompany() throws Exception{ 
        org = em.find(Orginization.class, 1l);
        //reading via tostring to see user accessible fields
        assertEquals(org.toString(), "Orginization{id=1, name=IEEE, location=Chicago, IL, "
                + "details=IEEE Annual EOY Cocktail!}");  //if the tostring matches expected output then read success
        
        System.out.println("Orginization 'Read' test passed;");
    }
    
     
    @Test
    public void updateCompany() throws Exception{
        org = em.find(Orginization.class, 1l); //old company
        org.setDetails("IEEE Annual EOY Cocktail!"); //new update info
        
        tx.begin();
        em.merge(org);
        tx.commit();

        //check to see if details updated
        assertEquals(org.getDetails(), "IEEE Annual EOY Cocktail!");
        System.out.println("Orginization 'Update' test passed;");
    }
   
    @Test 
    public void deleteCompany() throws Exception{
        org = em.find(Orginization.class, 1l);
        tx.begin();
        em.remove(org);
        tx.commit();
        org = em.find(Orginization.class, 1l);
        assertEquals(null, org); //if null then entity was sucessfully deleted
        System.out.println("Orginization 'Delete' test passed;");
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
