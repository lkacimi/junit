/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.messenger;

import org.txbiomed.application.domain.Client;

/**
 *
 * @author lkacimi
 */
public class Messenger {
    private final TemplateEngine templateEngine;
    private final MailServer mailServer;
    public Messenger(MailServer mailServer, TemplateEngine templateEngine) { 
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }
    public void sendMessage(Client client, Template template) { 
        String msgContent = templateEngine.prepareMessage(template, client); 
        mailServer.send(client.getEmail(), msgContent); 
    }
}
