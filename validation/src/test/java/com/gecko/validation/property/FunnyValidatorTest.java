package com.gecko.validation.property;

import com.gecko.json.domain.Message;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Created by hlieu on 04/28/17.
 */
public class FunnyValidatorTest {

   @Test(expected= ConstraintViolationException.class)
   public void test_validation_exception () {
      Message notFunny = new Message ();
      notFunny.setStr ("some random thoughts");
      UniversalValidator.validate (notFunny);
   }

   @Test
   public void test_not_exception () {
      Message funny = new Message ();
      funny.setStr ("funny");
      UniversalValidator.validate (funny);
   }

   @Test
   public void test_null_string () {
      // null is considered funny also

      Message funny = new Message ();
      //funny.setStr (null);

      try {
         UniversalValidator.validate (funny);
      } catch (ConstraintViolationException e) {
         for (ConstraintViolation violation: e.getConstraintViolations ()) {
            System.out.println (violation.getRootBean ()  + ": " + violation.getPropertyPath () + " " + violation.getMessage ());
         }
         throw e;
      }
   }
}