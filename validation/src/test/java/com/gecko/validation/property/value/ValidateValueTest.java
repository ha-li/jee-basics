package com.gecko.validation.property.value;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

/**
 * Validator.validateValue is used to validate a constraints value,
 * ie you do not have to instantiate an object on which to validate,
 * you validate the class, specify the field to validate, and the
 * value to validate, it will tell you if the value is valid based on
 * the constraints on the field.
 *
 * This can then be used to populate the validated field after validation.
 *
 * Created by hlieu on 05/7/17.
 */
public class ValidateValueTest {

   @Test(expected=ConstraintViolationException.class)
   public void test_validateValue_exception () {

      // this test tells me that 8 will trigger a constraints violation in TestBean.class
      try {
         UniversalValidator.validateValue (TestBean.class, "count", 8);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
         throw ce;
      }
   }

   @Test
   public void test_validateValue_boundary () {
      // this tells me that 4 is valid value to set TestBean.class to
      try {
         UniversalValidator.validateValue (TestBean.class, "count", 4);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
         throw ce;
      }
   }

   @Test
   public void test_validateValue_valid () {
      // tells me that 2 is also okay to use
      try {
         UniversalValidator.validateValue (TestBean.class, "count", 2);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
         throw ce;
      }
   }
}
