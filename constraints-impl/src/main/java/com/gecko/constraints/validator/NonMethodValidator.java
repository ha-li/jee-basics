package com.gecko.constraints.validator;

import com.gecko.constraints.NonMethod;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by hlieu on 04/29/17.
 */
public class NonMethodValidator implements ConstraintValidator <NonMethod, Object>  {

   public void initialize (NonMethod parameters) {}

   public boolean isValid (Object obj, ConstraintValidatorContext context) {
      return true;
   }
}
