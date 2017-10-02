/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;

import org.txbiomed.application.domain.Request;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author ubuntu
 */
public class Server {

    private final ExecutorService executorService;    
    private final TaskService taskService;
    
    public Server(ExecutorService executorService, TaskService taskService) {
        this.executorService = executorService;
        this.taskService = taskService;
    }
    
    public void serve(Request request) {
        request.getTasks().forEach(t -> executorService.submit(new TaskHandler(taskService, t)));
    }
}
