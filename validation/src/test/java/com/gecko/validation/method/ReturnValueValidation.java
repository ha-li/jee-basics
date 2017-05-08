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
public class ReturnValueValidation {

   @Test (expected=ConstraintViolationException.class)
   public void testReturnValueValidation_throws_exception () throws Exception {
      TestBean test = new TestBean ();
      test.setpValue (BigDecimal.valueOf(9.99d));

      BigDecimal finalPrice = test.isStoreGuaranteeValid ();

      Method isStoreGuarantee = TestBean.class.getMethod("isStoreGuaranteeValid", null);

      try {
         UniversalValidator.validateReturnValue (test, isStoreGuarantee, finalPrice);
      } catch (ConstraintViolationException c) {
         UniversalValidator.violation (c, System.out);
         throw c;
      }

      System.out.println (finalPrice);
   }

   @Test
   public void testReturnValueValidation_no_excpetion () throws Exception {
      TestBean test = new TestBean ();
      test.setpValue (BigDecimal.valueOf(7d));

      BigDecimal finalPrice = test.isStoreGuaranteeValid ();

      Method isStoreGuarantee = TestBean.class.getMethod("isStoreGuaranteeValid", null);

      try {
         UniversalValidator.validateReturnValue (test, isStoreGuarantee, finalPrice);
      } catch (ConstraintViolationException c) {
         UniversalValidator.violation (c, System.out);
         throw c;
      }

      Assert.assertTrue(finalPrice.compareTo(BigDecimal.valueOf(9.99d)) < 0);
   }

}
