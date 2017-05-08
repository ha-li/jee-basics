package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

/**
 * Created by hlieu on 04/29/17.
 */
public class MaxTest {
   @Test
   public void test_max () {
      TestBean bean = new TestBean ();
      bean.setCount(new BigDecimal ("3.2"));

      UniversalValidator.validate (bean);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_max_constraint () {
      TestBean bean = new TestBean ();
      bean.setCount(new BigDecimal ("8"));

      UniversalValidator.validate (bean);
   }
}
