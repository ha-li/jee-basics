package com.gecko.constraints.impl;

import com.gecko.constraints.Pdufa;
import com.gecko.domain.ClinicalTrial;
import com.gecko.domain.StudyCorrelation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */
public class PdufaValidation implements ConstraintValidator <Pdufa, ClinicalTrial> {

   // the recommended pValue for FDA approval
   private BigDecimal min_p_value = BigDecimal.valueOf(0.05d);


   public void initialize (Pdufa parameters) {
   }

   public boolean isValid (ClinicalTrial trial, ConstraintValidatorContext context) {
      StudyCorrelation studyResult = trial.getpVal ();
      BigDecimal pValue = studyResult.getrValue ();

      return pValue.compareTo(min_p_value) < 0;
   }
}
