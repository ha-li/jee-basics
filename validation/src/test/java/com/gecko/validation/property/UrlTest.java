package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.net.URL;

/**
 * Created by hlieu on 04/30/17.
 */
public class UrlTest {
   @Test
   public void test_url () {
      TestBean test = new TestBean () ;

      test.setPersonalFtp ("ftp://scm.ie.nexus.com:21/home/jdax/personal/mp3s");

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test (expected = ConstraintViolationException.class)
   public void test_url_invalid_ftp () {
      TestBean test = new TestBean () ;

      test.setPersonalFtp ("http://scm.ie.nexus.com:21/home/jdax/personal/mp3s");

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test
   public void test_url_valid_http () {
      TestBean test = new TestBean () ;

      test.setPersonalWeb ("http://www.home.com:80/home/jdax/personal/mp3s");

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_url_invalid_http () {
      TestBean test = new TestBean () ;

      // this host is incorrect
      test.setPersonalWeb ("http://scm.nexus.net:80/home/jdax/personal/mp3s");

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test
   public void test_url_url () throws Exception {
      TestBean testBean = new TestBean ();

      URL url = new URL ("http://my.home.com:80");
      testBean.setAlternativeWeb (url);

      try {
         UniversalValidator.validate (testBean);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_url_url_invalid () throws Exception {
      TestBean testBean = new TestBean ();

      URL url = new URL ("ftp://my.home.com:80");
      testBean.setAlternativeWeb (url);

      try {
         UniversalValidator.validate (testBean);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_url_url__multi_invalids () throws Exception {
      TestBean testBean = new TestBean ();

      URL url = new URL ("ftp://scm.aipo.net:21");
      testBean.setAlternativeWeb (url);

      try {
         UniversalValidator.validate (testBean);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }
}
