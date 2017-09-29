/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;

import org.txbiomed.application.domain.Message;
import org.txbiomed.application.service.RaceResultsService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import org.txbiomed.application.domain.Client;

/**
 *
 * @author lkacimi
 */
public class RaceResultsServiceTest {
    
    @Test
    //@Ignore
    public void testSubscribedClientsShouldReceilveMessages(){
        RaceResultsService raceResultsService = new RaceResultsService();
        
        Client client = Mockito.mock(Client.class);
        Message message = Mockito.mock(Message.class);
        
        raceResultsService.addSubscriber(client);
        raceResultsService.send(message);
        Mockito.verify(client).receive(message);
    }
    
    @Test
    public void testUnsubscribedClientsShouldNotReceiveMessages(){
        RaceResultsService raceResultsService = new RaceResultsService();
        
        Client client = Mockito.mock(Client.class);
        Message message = Mockito.mock(Message.class);
        raceResultsService.send(message);
        Mockito.verify(client,Mockito.never()).receive(message);
        
        
    }
    
    
}
