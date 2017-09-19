/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

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
public class StringHelperTest {
    StringHelper stringHelper = new StringHelper();
    public StringHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of truncateAInFirst2Positions method, of class StringHelper.
     */
    @Test
    public void testTruncateAInFirst2Positions() {
        assertEquals("B", stringHelper.truncateAInFirst2Positions("AAB"));
    }
    
    @Test
    public void testTruncateAInFirst2PositionsBis(){
       
        assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2PositionsTrio(){
       
        assertEquals("CDEF", stringHelper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2PositionsQuatro(){
       
        assertEquals("CDAA", stringHelper.truncateAInFirst2Positions("CDAA"));
    }

    /**
     * Test of areFirstAnsLastCharactersTheSame method, of class StringHelper.
     */
    @Test
    public void testAreFirstAndLastCharactersTheSame() {
        
        assertTrue(stringHelper.areFirstAndLastCharactersTheSame("AA"));
        
    }
    
    @Test
    public void testAreFirstAndLastCharactersTheSameBis() {
        
        assertFalse(stringHelper.areFirstAndLastCharactersTheSame("AAC"));
        
    }
    
}
