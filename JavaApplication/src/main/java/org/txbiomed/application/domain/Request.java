/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ubuntu
 */
public class Request {
    Set<Task> tasks = new HashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }
    
}
