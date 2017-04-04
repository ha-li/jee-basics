package com.gecko.gateway.consumer;

import org.apache.activemq.command.ActiveMQBlobMessage;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by hlieu on 04/3/17.
 */
public class DefaultConsumerTest {

   @Test
   public void test_on_message () throws Exception {
      ActiveMQTextMessage message = new ActiveMQTextMessage ();
      message.setStringProperty ("TransactionId", UUID.randomUUID ().toString());
      message.setText("A random test message");

      DefaultConsumer consumer = new DefaultConsumer ();
      consumer.onMessage (message);
   }

   @Test
   public void test_blob_message () throws Exception {
      ActiveMQMessage message = new ActiveMQBlobMessage ();
      message.setStringProperty ("TransactionId", UUID.randomUUID ().toString());

      DefaultConsumer consumer = new DefaultConsumer ();
      consumer.onMessage (message);
   }
}
