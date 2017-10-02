/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;
import org.txbiomed.application.domain.Task;
/**
 *
 * @author ubuntu
 */
public class TaskService {
    public void handle(Task task){
        System.out.println("I am handling the given task");
    }
}
