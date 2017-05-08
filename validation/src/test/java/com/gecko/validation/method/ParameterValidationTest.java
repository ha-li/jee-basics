package com.gecko.validation.method;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */
public class ParameterValidationTest {

   @Test(expected = ConstraintViolationException.class)
   public void test_tax_too_high () throws NoSuchMethodException {
      TestBean test = new TestBean ();

      Method priceCalculator = TestBean.class.getMethod("calculatePrice", BigDecimal.class);

      try {
         UniversalValidator.validateParameters (test, priceCalculator, new Object[]{BigDecimal.valueOf (2.0d)});
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_tax_too_low () throws NoSuchMethodException {
      TestBean test = new TestBean ();

      Method priceCalculator = TestBean.class.getMethod("calculatePrice", BigDecimal.class);

      try {
         UniversalValidator.validateParameters (test, priceCalculator, new Object[]{BigDecimal.valueOf (1.0d)});
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test
   public void test_tax_rate () throws Exception {

      Method priceCalculator = TestBean.class.getMethod("calculatePrice", BigDecimal.class);

      BigDecimal taxRate = BigDecimal.valueOf (1.5d);
      try {
         UniversalValidator.validateParameters (TestBean.class.newInstance (), priceCalculator, new Object[]{taxRate});
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }

      // taxRate is valid, so we use it to find the final price
      TestBean testBean = new TestBean ();
      testBean.setpValue (BigDecimal.valueOf (48.3d));
      BigDecimal finalPrice = testBean.calculatePrice (taxRate);
      Assert.assertTrue (finalPrice.compareTo(testBean.getpValue ()) > 0);
   }

}
