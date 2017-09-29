/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.service;

import java.util.ArrayList;
import java.util.List;
import org.txbiomed.application.domain.Client;
import org.txbiomed.application.domain.Message;

/**
 *
 * @author lkacimi
 */
public class RaceResultsService {

    public List<Client> subscribers = new ArrayList<>();
    void addSubscriber(Client client) {
        this.subscribers.add(client);
    }

    
    public void send(Message message){
        this.subscribers.forEach(s -> s.receive(message));
    }
  
    
}
