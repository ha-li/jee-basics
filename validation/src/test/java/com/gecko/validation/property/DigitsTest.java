package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

/**
 * Created by hlieu on 04/28/17.
 */
public class DigitsTest {

   @Test(expected = ConstraintViolationException.class)
   public void test_too_large_integer () {
      TestBean test = new TestBean ();
      test.setpValue (new BigDecimal ("310"));

      UniversalValidator.validate(test);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_too_many_decimal () {
      TestBean test = new TestBean ();
      test.setpValue (new BigDecimal ("1.1231"));

      UniversalValidator.validate(test);
   }

   @Test
   public void test_fair_value() {
      TestBean test = new TestBean ();
      test.setpValue (new BigDecimal ("1.0"));

      UniversalValidator.validate(test);
   }

   @Test
   public void test_fair_value2() {
      TestBean test = new TestBean ();
      test.setpValue (new BigDecimal ("99.999"));

      UniversalValidator.validate(test);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_not_fair_value() {
      TestBean test = new TestBean ();
      test.setpValue (new BigDecimal ("99.9990"));

      UniversalValidator.validate(test);
   }
}
