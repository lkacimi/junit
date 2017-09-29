/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author ubuntu
 */
public class CarTest {
    private Car mockCar = Mockito.mock(Car.class);
    public CarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println(mockCar.getEngineTemperature());
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
    public void testThatMockCarIsInstanceOfCar(){
        assertTrue(mockCar instanceof Car);
    }
    
    @Test
    public void testThatCarNeedsFuels(){
        Mockito.when(mockCar.needsFuel()).thenReturn(true);
        assertTrue(mockCar.needsFuel());
        Mockito.verify(mockCar,Mockito.times(1)).needsFuel();
       
    }
    @Test(expected = RuntimeException.class)
    public void testThatCarNeedsFuelReturnExpception(){
         Mockito.when(mockCar.needsFuel()).thenThrow(new RuntimeException());
         mockCar.needsFuel();
    }
}
