/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ubuntu
 */
public class ClientTest {
    private Client client;
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        client = new Client("Lamine");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Client.
     */
   
    @Test
    public void testNoAddress(){
        assertEquals(0, this.client.getAdresses().size());
    }
    
    @Test
    public void canAddAddresses(){
        Address address = new Address("San Antonio");
        this.client.getAdresses().add(address);
        this.client.getAdresses().add(new Address("Bejaia"));
        
        assertEquals(2, this.client.getAdresses().size());
        assertEquals(true,this.client.getAdresses().contains(address));
    }
    
}
