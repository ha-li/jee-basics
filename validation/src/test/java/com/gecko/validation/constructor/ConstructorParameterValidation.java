package com.gecko.validation.constructor;

import com.gecko.test.beans.TestBean;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */
public class ConstructorParameterValidation {

   @Test(expected = ConstraintViolationException.class)
   public void test_constructor_parameter_invalid () throws Exception {
      Constructor<TestBean> constructor = TestBean.class.getConstructor (BigDecimal.class);

      try {
         UniversalValidator.validateConstructorParameters (constructor, new Object[]{BigDecimal.valueOf (10.19d)});
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation(ce, System.out);
         throw ce;
      }
   }

   @Test
   public void test_constructor_parameter_valid () throws Exception {
      Constructor<TestBean> constructor = TestBean.class.getConstructor (BigDecimal.class);

      try {
         UniversalValidator.validateConstructorParameters (constructor, new Object[]{BigDecimal.valueOf (9.19d)});
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation(ce, System.out);
         throw ce;
      }
   }

}
