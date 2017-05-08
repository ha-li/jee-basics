package com.gecko.constraints.validator;


import com.gecko.constraints.MustBeFunny;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validate that the string must be <code>"funny"</code>
 * Created by hlieu on 04/23/17.
 */
public class MustBeFunnyValidator implements ConstraintValidator<MustBeFunny, String> {

   @Override
   public void initialize (MustBeFunny parameters) {
   }

   @Override
   public boolean isValid(String object, ConstraintValidatorContext constraintValidatorContext) {
      return object == null || object.equalsIgnoreCase ("funny");
   }
}
