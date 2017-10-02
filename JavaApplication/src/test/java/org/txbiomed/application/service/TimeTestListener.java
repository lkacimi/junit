/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 * @author ubuntu
 */
public class TimeTestListener extends TestWatcher {
    
    @Override
    protected void starting(Description description){
        System.out.println("Test about to start: Class:" + description.getClassName()+", Method: " + description.getMethodName());
    }
}
