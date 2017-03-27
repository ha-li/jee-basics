package com.gecko.jee.jndi;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import java.util.Hashtable;

/**
 * A basic example showing Java Naming and Directory Interface (JNDI).
 *
 * This example makes use of a file naming service implementation
 * as the SPI (Service Provider Interface) that underlies the jndi.
 *
 *
 *
 * Created by hlieu on 03/26/17.
 */
public class JndiBasics {
   public static void main (String[] args) throws Exception {
      Hashtable<String, String> env = new Hashtable ();

      // the spi class to use as the implementation of the jndi
      env.put (Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

      // the url required value. in the case of a file naming service,
      // the provider url provides the initial context that the service
      // uses as its namespace, ie all the files in the file service
      // will be the files in this url.
      // the protocol will be file:///
      env.put (Context.PROVIDER_URL, "file:////Users/hlieu/Desktop/");
      Context context = new InitialContext (env);

      NamingEnumeration namingEnumeration = context.listBindings("");
      while (namingEnumeration.hasMore ()) {
         Binding binding = (Binding) namingEnumeration.next();
         System.out.println("name: " + binding.getName() + " object: " + binding.getObject());
      }
   }
}