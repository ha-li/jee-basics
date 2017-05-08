package com.gecko.constraints.impl;

import com.gecko.domain.StudyCorrelation;
import com.gecko.constraints.FdaAccepted;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */
public class FdaAcceptedValidation implements ConstraintValidator<FdaAccepted, StudyCorrelation> {

   private BigDecimal min_p_value = BigDecimal.valueOf(0.05d);

   @Override
   public void initialize (FdaAccepted parameters) {

   }

   @Override
   public boolean isValid (StudyCorrelation correlation, ConstraintValidatorContext context) {
      BigDecimal minValue = correlation.getrValueMin ();

      return minValue.compareTo(min_p_value) < 0 ;
   }
}
