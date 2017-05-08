package com.gecko.constraints.validator;

import com.gecko.constraints.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;

/**
 * Created by hlieu on 04/30/17.
 */
public class UrlValidationForString implements ConstraintValidator<URL, String> {

   private String protocol;
   private String host;
   private int port;

   public void initialize (URL parameters) {
      this.protocol = parameters.protocol ();
      this.host = parameters.host ();
      this.port = parameters.port ();
   }

   public boolean isValid (String urlValue, ConstraintValidatorContext context) {
      if (urlValue == null) return true;

      if (urlValue.length () == 0) return false;

      java.net.URL url;
      try {
         url = new java.net.URL (urlValue);
      } catch (MalformedURLException ue) {
         return false;
      }

      if (protocol != null && protocol.length () > 0 ) {
         if ( !url.getProtocol ().equals (protocol) ) {
            return false;
         }
      }

      if (host != null && host.length () > 0) {
         if ( !url.getHost ().equals (host) ) {
            return false;
         }
      }

      if (port != -1) {
         if ( url.getPort () != port ) {
            return false;
         }
      }
      return true;
   }
}
