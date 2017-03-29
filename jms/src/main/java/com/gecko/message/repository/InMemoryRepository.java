package com.gecko.message.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hlieu on 02/26/17.
 *
 * In order to use ssl protocol, the following jvm properties need to be
 * defined in your executable. You must have created these public and private keys,
 * see ActiveMQ in Action, ch 3/4.
 *
 *  -Djavax.net.ssl.keyStore=/Users/hlieu/Security/KeyStores/jms.client.ks
 *  -Djavax.net.ssl.keyStorePassword=jms123
 *  -Djavax.net.ssl.trustStore=/Users/hlieu/Security/KeyStores/jms.client.ts
 *
 */
public class InMemoryRepository {
   private static Map<String, String> brokerUrlMap = new HashMap<String, String>();

   static {
      // tcp
      brokerUrlMap.put ("tcp", "tcp://localhost:61616?trace=true");

      //nio
      brokerUrlMap.put ("nio", "nio://localhost:61620?trace=true");

      //udp
      //brokerUrlMap.put ("udp", "udp://localhost:6717?trace=true");

      //ssl
      brokerUrlMap.put ("ssl", "ssl://localhost:61618?trace=true");

      // failover protocol will allow a disconnected client to attempt to
      // reconnect automatically
      brokerUrlMap.put ("failover", "failover:(nio://localhost:61620,tcp://localhost:61617)");

   }

   private static final String DEFAULT_PROTOCOL = "nio";

   public static String getBrokerUrl () {
      return getBrokerUrl (DEFAULT_PROTOCOL);
   }

   public static String getProducerBrokerUrl () {
      return getBrokerUrl ("producer");
   }

   public static String getBrokerUrl (String protocol) {
      String brokerUrl = getBrokerMap ().get(protocol);
      if (brokerUrl == null) {
         throw new NullPointerException("No such consumer protocol exists.");
      }

      return brokerUrl;
   }

   private static Map<String, String> getBrokerMap () { return brokerUrlMap; }

}
