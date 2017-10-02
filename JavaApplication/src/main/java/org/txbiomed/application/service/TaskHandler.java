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
public class TaskHandler implements Runnable{
    private final TaskService taskService;
    private final Task task;

    public TaskHandler(TaskService taskService, Task task) {
        this.taskService = taskService;
        this.task = task;
    }
    
    @Override
    public void run() {
        this.taskService.handle(this.task);
    }
    
}
