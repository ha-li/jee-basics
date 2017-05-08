package com.gecko.validation.property;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;

/**
 * Created by hlieu on 04/30/17.
 */
public class SizeTest {

   @Test(expected = ConstraintViolationException.class)
   public void test_size_violation () {
      TestBean testBean = new TestBean ();
      Integer[] ints = {1, 3, 2, 3, 5, 8};
      testBean.setAll (Arrays.asList(ints));

      UniversalValidator.validate(testBean);
   }

   @Test
   public void test_size_valid () {
      TestBean testBean = new TestBean ();
      Integer[] ints = {1, 3};
      testBean.setAll (Arrays.asList(ints));

      UniversalValidator.validate(testBean);
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_size_valid_too_small () {
      TestBean testBean = new TestBean ();
      Integer[] ints = {};
      testBean.setAll (Arrays.asList(ints));

      UniversalValidator.validate(testBean);
   }
}
