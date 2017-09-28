/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.mockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.txbiomed.application.helper.StringHelper;

/**
 *
 * @author ubuntu
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitTest {
    @Mock
    StringHelper helper;
    
    public MockitoJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testStringHelper(){
        helper.areFirstAndLastCharactersTheSame("ABCDEA");
        Mockito.when(helper.areFirstAndLastCharactersTheSame(Mockito.anyString())).thenReturn(true);
        BDDMockito.given(helper.truncateAInFirst2Positions(BDDMockito.anyString())).willReturn("BB");
        
        assertEquals(helper.areFirstAndLastCharactersTheSame("AAAE"), true);
        Mockito.verify(helper, Mockito.times(2)).areFirstAndLastCharactersTheSame(Mockito.anyString());
        assertEquals(helper.truncateAInFirst2Positions("HELLO"), "BB");
        Mockito.verify(helper, Mockito.atLeast(1)).truncateAInFirst2Positions(Mockito.anyString());
    }
}
