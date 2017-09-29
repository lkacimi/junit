/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lkacimi
 */
public class Client {
    private String name;
    private String email;
    
    private List<Address> adresses = new ArrayList();

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Address> adresses) {
        this.adresses = adresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void receive(Message message) {
        System.out.println("Message received");
    }
    
    
    
    
}
