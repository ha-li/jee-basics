package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

/**
 * Created by hlieu on 04/28/17.
 */
public class FalseTest {

   @Test(expected = ConstraintViolationException.class)
   public void test_false () {
      TestBean tb = new TestBean ();
      tb.setMustBeFalse (Boolean.TRUE);

      UniversalValidator.validate (tb);
   }

   @Test
   public void test_true () {
      TestBean tb = new TestBean ();
      tb.setMustBeFalse (Boolean.FALSE);

      UniversalValidator.validate (tb);
   }

   // nulls are both true and false based on their annotation
   @Test
   public void test_null () {
      TestBean tb = new TestBean ();

      UniversalValidator.validate (tb);
   }
}
