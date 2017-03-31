package com.gecko.message;

import com.gecko.message.producer.Producer;
import com.gecko.message.repository.ProducerRepository;

/**
 * Created by hlieu on 03/3/17.
 */
public class MessageProducer {

   public static void main (String[] args) throws Exception {

      for (int i = 0; i < 10; i++) {
         System.out.println ("Sending a message with transaction id");
         ProducerRepository.findProducer ("default_producer").send("A test message " + i);
      }

      ProducerRepository.destroy ();
   }
}
