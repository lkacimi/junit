/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static junitparams.JUnitParamsRunner.$;
/**
 *
 * @author lkacimi
 */

@RunWith(JUnitParamsRunner.class)
public class ParameterizedMoneyTest {
    
    public ParameterizedMoneyTest() {
    }
    
    private static final Object[] getMoney(){
        return new Object[]{
            new Object[]{10,"USD"},
            new Object[]{20,"EUR"},
            new Object[]{30,"EUR"}
        };
    }
    
    private static final Object[] getMoneyBis(){
        return $(
            $(10,"USD"),
            $(20,"EUR"),
            $(30,"EUR")
        );
        
    }
    @Test
    @Parameters(method = "getMoneyBis")
    public void testConstructor(int amount, String currency){
        Money money = new Money(amount,currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency,money.getCurrency());
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
    
    @Test(expected = IllegalArgumentException.class)
    public void testExcpetion(){
        throw new IllegalArgumentException();
    }
}
