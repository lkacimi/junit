/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;

/**
 *
 * @author ubuntu
 */
public class OperatingSystemServiceTest {
    
    @Test
    public void testThatWillOnlyRunOnLinux(){
        Assume.assumeTrue(this.isLinuxMachine());
        assertTrue(true);
    }
    
    @Test
    public void testThatWillOnlyRunOnWindows(){
        Assume.assumeTrue(this.isWindowsMachine());
        assertTrue(false);
    }
    
    private boolean isWindowsMachine(){
        return System.getProperty("os.name").startsWith("Windows");
    }
    
    private boolean isLinuxMachine(){
        return System.getProperty("os.name").startsWith("Linux");
    }
}
