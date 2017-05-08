package com.gecko.constraints.validator;

import com.gecko.constraints.NonField;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator that cannot be applied to a FIELD (ie an attribute).
 * It can be applied to METHOD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER,
 * but not a field.
 *
 * Validates whatever it is applied to is:
 *  - returns true if it is not null
 *
 * Created by hlieu on 04/29/17.
 */
public class NonFieldValidator implements ConstraintValidator<NonField, Object> {

   @Override
   public void initialize (NonField parameters) {
   }

   public boolean isValid (Object object, ConstraintValidatorContext context) {
      return object != null;
   }
}
