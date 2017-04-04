package com.gecko.gateway.service;

import com.gecko.gateway.repository.InMemoryRepository;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.UUID;

/**
 * Created by hlieu on 04/3/17.
 */
public class MessageServiceTest {
   private static ConnectionFactory factory = null;
   private static Connection connection = null;
   private static Session session = null;

   @BeforeClass
   public static void setUp () throws Exception {
      String brokerUrl = InMemoryRepository.getBrokerUrl ("nio");
      factory = new ActiveMQConnectionFactory ("admin", "admin", brokerUrl);
      connection = factory.createConnection ();
      session = connection.createSession (true, Session.AUTO_ACKNOWLEDGE);
   }

   @Test
   public void test_createMessage () throws Exception {

      Message message = MessageService.createMessage(session, UUID.randomUUID ().toString(), "A message to send.");
      Assert.assertEquals ("A message to send.", ((TextMessage)message).getText());
   }
}