/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;
import java.util.Arrays;
import java.util.Collection;
import org.txbiomed.application.domain.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.txbiomed.application.domain.Request;

/**
 *
 * @author ubuntu
 */
public class ServerTest {
    
    public ServerTest() {
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

    /**
     * Test of serve method, of class Server.
     */
    @Test
    public void testServe() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TaskService taskService = Mockito.mock(TaskService.class);
        Task task = Mockito.mock(Task.class);
        
        Request request = new Request();
        request.getTasks().add(task);
        Server server = new Server(executorService, taskService);
        
        server.serve(request);
        Thread.sleep(1000);
        Mockito.verify(taskService).handle(task);
        
        
    }
    
}
