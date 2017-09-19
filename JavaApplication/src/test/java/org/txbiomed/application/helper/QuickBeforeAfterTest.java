/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lkacimi
 */
public class QuickBeforeAfterTest {
    public static List<Integer> listIntegers = new ArrayList<Integer>();
    public QuickBeforeAfterTest() {
    }
    
    @BeforeClass //These must be declared static
    public static void setUpClass() {
        System.out.println("Once for every unit test class");
    }
    
    @AfterClass //These must be declared static
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        listIntegers.add(5);
    }
    
    @After
    public void tearDown() {
        System.out.println("After Test");
    }

   @Test
   public void testDoIt(){
       assertTrue(listIntegers.contains(5));
   }
   
   @Test
   public void testDoItBis(){
       assertTrue(listIntegers.size()==2);
   }
}
