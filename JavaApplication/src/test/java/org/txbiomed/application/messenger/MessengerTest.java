/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.messenger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.txbiomed.application.domain.Client;

/**
 *
 * @author ubuntu
 */
public class MessengerTest {
    
    public MessengerTest() {
    }
    
   
    @Test
    public void testSendMessage() {
        Client client = Mockito.mock(Client.class);
        Template template = Mockito.mock(Template.class);
        MailServer mailServer = Mockito.mock(MailServer.class);
        
        TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);
        Mockito.when(templateEngine.prepareMessage(Mockito.any(Template.class), Mockito.any(Client.class))).thenReturn("Hello!");
        
        Messenger messenger = new Messenger(mailServer, templateEngine);
        
        messenger.sendMessage(client, template);
        Mockito.verify(mailServer).send(client.getEmail(), "Hello!");
       
    }
    
}
