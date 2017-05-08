package com.gecko.validation.property;

import com.gecko.json.domain.Prisoner;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

/**
 * Created by hlieu on 05/1/17.
 */
public class MarriedAssertTrue {

   @Test(expected = ConstraintViolationException.class)
   public void test_married_false () {

      // prison-constraints.xml says 'married' should be true,
      // overriding the constraints in the bean class
      Prisoner test = new Prisoner ();
      test.setMarried(Boolean.FALSE);

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test
   public void test_married_true () {

      // prison-constraints.xml says 'married' should be true,
      // overriding the constraints in the bean class
      Prisoner test = new Prisoner ();
      test.setMarried(Boolean.TRUE);

      try {
         UniversalValidator.validate (test);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }
}
