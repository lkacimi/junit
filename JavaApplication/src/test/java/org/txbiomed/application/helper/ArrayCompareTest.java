/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

import java.util.Arrays;
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
public class ArrayCompareTest {
    
    public ArrayCompareTest() {
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
    public void testArrays(){
        int[] numbers={12,3,4,1};
        int[] sorted={1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(sorted, numbers);
    }
    
    @Test(expected = NullPointerException.class)
    public void testException(){
       int[] numbers=null;
       Arrays.sort(numbers);    
    }
    
    @Test(timeout = 1000) // test performance using timeout, 10 in ms
    public void testSortPerformance(){
        int[] a ={12,23,4};
        for(int i=0; i<=1000000; i++){
            a[0]=i;
            Arrays.sort(a);
        }
        
    }
}
