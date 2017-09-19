/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author lkacimi
 */
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
    StringHelper stringHelper = new StringHelper();
    /*public StringHelperParameterizedTest() {
    }*/
    @Parameterized.Parameters
    public static Collection<String[]> testCondition(){
        String expectedOutputs[][] ={{"AACD","CD"},{"ACD","CD"}};
        
        return Arrays.asList(expectedOutputs);
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
        assertEquals(expected, stringHelper.truncateAInFirst2Positions(input));
    }
    
    private String expected;
    private String input;

    public StringHelperParameterizedTest(String input, String expected) {
        this.expected = expected;
        this.input = input;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
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
