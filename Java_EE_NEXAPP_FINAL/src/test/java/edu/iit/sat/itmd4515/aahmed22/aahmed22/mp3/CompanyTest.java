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
public class CompanyTest {
    
           
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    Company c = new Company("Target", "A leader in retail, focusing on technology.");
     
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
        em.persist(c);
        tx.commit();
        assertNotNull("ID should not be null", c.getId()); //if there is an id then a company has been created in the database
        System.out.println("Company 'Create' test passed;");
    }
    
    @Test 
    public void readCompany() throws Exception{ 
        c = em.find(Company.class, 1l);
        assertEquals((c.getCompanyName() + " - " + c.getInfo()), "Alphabet - Google, YouTube, and more."); //if company name and info match, it's the correct company read.
        System.out.println("Company 'Read' test passed;");
    }
    
    @Test
    public void updateCompany() throws Exception{
        c = em.find(Company.class, 1l); //old company
        c.setCompanyName("Alphabet"); //new updated company
        c.setInfo("Google, YouTube, and more."); //new update info
        
        tx.begin();
        em.merge(c);
        tx.commit();

        assertEquals((c.getCompanyName() + " - " + c.getInfo()), "Alphabet - Google, YouTube, and more.");
        System.out.println("Company 'Update' test passed;");
    }
    
    @Test 
    public void deleteCompany() throws Exception{
        c = em.find(Company.class, 1l);
        tx.begin();
        em.remove(c);
        tx.commit();
        c = em.find(Company.class, 1l);
        assertEquals(null, c); //if null then entity was sucessfully deleted
        System.out.println("Company 'Delete' test passed;");
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
