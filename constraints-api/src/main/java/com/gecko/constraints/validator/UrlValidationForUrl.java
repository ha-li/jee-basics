package com.gecko.constraints.validator;

import com.gecko.constraints.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by hlieu on 04/30/17.
 */
public class UrlValidationForUrl implements ConstraintValidator<URL, java.net.URL> {
   private String protocol;
   private String host;
   private int port;

   public void initialize (URL parameters) {
      this.protocol = parameters.protocol ();
      this.host = parameters.host ();
      this.port = parameters.port ();
   }

   public boolean isValid (java.net.URL url, ConstraintValidatorContext context) {
      if (url == null) return true;

      boolean violation = false;
      //ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate ("constraints violation: is/are wrong");
      if (protocol != null && protocol.length () > 0) {
         if ( !url.getProtocol ().equals (protocol) ) {
            context.disableDefaultConstraintViolation ();
            context.buildConstraintViolationWithTemplate ("is wrong").addPropertyNode ("protocol").addConstraintViolation ();

            //context.buildConstraintViolationWithTemplate ("Invalid protocol for URL").addConstraintViolation ();
            //context.buildConstraintViolationWithTemplate ("this detail is wrong")
            //        .addPropertyNode ("protocol").addConstraintViolation ();
            //builder.addPropertyNode ("protocol");
            violation = true;
            //return false;
         }
      }

      if (host != null && host.length () > 0) {
         if ( !url.getHost ().equals (host)) {
            context.disableDefaultConstraintViolation ();
            context.buildConstraintViolationWithTemplate ("is wrong").addPropertyNode ("host").addConstraintViolation ();
            //builder.addPropertyNode ("host");
            violation = true;
         }
      }

      if (port != -1) {
         if (url.getPort () != port) {
            context.disableDefaultConstraintViolation ();
            context.buildConstraintViolationWithTemplate ("is wrong").addPropertyNode ("port").addConstraintViolation ();

            //context.buildConstraintViolationWithTemplate ("Invalid port for URL").addConstraintViolation ();
            //builder.addPropertyNode ("port");
            violation = true;
         }
      }

      //if (violation) {
      //   builder.addConstraintViolation ();
      //}

      return (!violation);
   }
}
