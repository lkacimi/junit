/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

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
public class FootballTeamTest {
    
    public FootballTeamTest() {
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
    public void testConstructorShouldSetGamesWon(){
        FootballTeam ft = new FootballTeam(3);
        assertEquals(3,ft.getGamesWon());
    }
    
    @Test
    public void testShouldBeComparable(){
        assertTrue(new FootballTeam(5)  instanceof Comparable);
    }
    
    @Test 
    public void testTeamsShouldBeSortedCorrectly(){
        FootballTeam team1 = new FootballTeam(5);
        FootballTeam team2 = new FootballTeam(4);
        FootballTeam[] teams = {team1,team2};
        Arrays.sort(teams);
        assertArrayEquals(new FootballTeam[]{team2,team1}, teams);
    }
}
