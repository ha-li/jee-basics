package com.gecko.constraints.validator;

import com.gecko.constraints.ChronologicalOrder;
import com.gecko.json.domain.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by hlieu on 04/29/17.
 */
public class ChronologicalOrderValidator implements ConstraintValidator <ChronologicalOrder, Employee> {
   public void initialize (ChronologicalOrder parameters) {}

   public boolean isValid (Employee obj, ConstraintValidatorContext context) {
      return true;
   }
}
