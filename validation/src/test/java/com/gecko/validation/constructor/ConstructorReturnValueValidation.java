package com.gecko.validation.constructor;

import com.gecko.domain.StudyCorrelation;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */
public class ConstructorReturnValueValidation {

   @Test(expected = ConstraintViolationException.class)
   public void test_constructor_invalid_fda () throws Exception {
      StudyCorrelation testBean = new StudyCorrelation (BigDecimal.valueOf(0.3d), BigDecimal.valueOf(.9d));

      Constructor<StudyCorrelation> constructor = StudyCorrelation.class.getConstructor (BigDecimal.class, BigDecimal.class);

      try {
         UniversalValidator.validateConstructorReturnValue (constructor, testBean);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation(ce, System.out);
         throw ce;
      }
   }

   @Test
   public void test_constructor_valid_fda () throws Exception {
      StudyCorrelation testBean = new StudyCorrelation (BigDecimal.valueOf(0.003d), BigDecimal.valueOf(.9d));

      Constructor<StudyCorrelation> constructor = StudyCorrelation.class.getConstructor (BigDecimal.class, BigDecimal.class);

      try {
         UniversalValidator.validateConstructorReturnValue (constructor, testBean);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation(ce, System.out);
         throw ce;
      }
   }

}
