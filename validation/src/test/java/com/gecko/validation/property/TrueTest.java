package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

/**
 * Created by hlieu on 04/28/17.
 */
public class TrueTest {

   @Test(expected = ConstraintViolationException.class)
   public void test_true () {
      TestBean tb = new TestBean ();
      tb.setMustBeTrue (Boolean.FALSE);

      UniversalValidator.validate(tb);
   }

   @Test
   public void test_false () {
      TestBean tb = new TestBean ();
      tb.setMustBeTrue (Boolean.TRUE);

      UniversalValidator.validate(tb);
   }

   // nulls are also both true and false based on the annotation
   @Test
   public void test_null () {
      TestBean tb = new TestBean ();

      UniversalValidator.validate(tb);
   }
}
