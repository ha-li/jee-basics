package com.gecko.validation.property;

import com.gecko.json.domain.PrisonCell;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

/**
 * Created by hlieu on 05/1/17.
 */
public class PrisonNumberNull {
   @Test(expected=ConstraintViolationException.class)
   public void test_not_null () {

      PrisonCell prisoner = new PrisonCell ();
      prisoner.setId ("183264");

      try {
         UniversalValidator.validate(prisoner);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }

   @Test
   public void test_null () {

      PrisonCell prisoner = new PrisonCell ();
      //prisoner.setId ("183264");

      try {
         UniversalValidator.validate(prisoner);
      } catch (ConstraintViolationException e) {
         UniversalValidator.violation (e, System.out);
         throw e;
      }
   }
}
