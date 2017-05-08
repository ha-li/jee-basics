package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * A test class of my own defined email constraints,
 * a simpler verson then hibernate's email constraints.
 * Created by hlieu on 04/30/17.
 */
public class EmailTest {

   @Test
   public void test_email () {
      TestBean bean = new TestBean ();
      bean.setEmail ("bob@bob.com");

      try {
         UniversalValidator.validate (bean);
      } catch (ConstraintViolationException e) {
         for (ConstraintViolation violation: e.getConstraintViolations ()) {
            System.out.println (violation.getRootBean () + " " + violation.getMessage ());
         }
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_email_invalid () {
      TestBean bean = new TestBean ();
      bean.setEmail ("bob@.com");

      try {
         UniversalValidator.validate (bean);
      } catch (ConstraintViolationException e) {
         for (ConstraintViolation violation: e.getConstraintViolations ()) {
            System.out.println (violation.getRootBean () + " " + violation.getMessage ());
         }
         throw e;
      }
   }
}
