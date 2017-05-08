package com.gecko.validation.pdufa;

import com.gecko.constraints.groups.PostTrial;
import com.gecko.domain.ClinicalTrial;
import com.gecko.domain.StudyCorrelation;
import com.gecko.validation.UniversalValidator;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

/**
 * An example of validation using groups.
 *
 * A group is simply a marker interface. Here we have a PostTrial group
 * to indicate that the study is currently in post clinical trial, so it
 * should have a study result (pValue).
 *
 * We validate the clinical trial which has a @Pdufa constraint in PostTrial phase.
 *
 * In one example we do a validation in Default group, no exception.
 *
 * In the test_post_pdufa_failed_trial, validate in PostTrial group,
 * which expects a StudyCorrelation with a pvalue populated.
 * Since the results of the p-value are not within the range of < 0.05
 * the trial fails and there will be no PDUFA date (a constaint violation is thrown).
 *
 * In test_post_pdufa_successful_trial, we validate in PostTrial group with
 * a successful pValue, so no violation is thrown.
 * Created by hlieu on 05/7/17.
 */
public class ClinicalTrialTest {
   @Test
   public void test_pre_pdufa () {
      ClinicalTrial trial = new ClinicalTrial ();
      try {
         UniversalValidator.validate (trial);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
      }
   }

   @Test(expected = ConstraintViolationException.class)
   public void test_post_pdufa_failed_trial () {

      ClinicalTrial trial = new ClinicalTrial ();
      StudyCorrelation studyResults = new StudyCorrelation (BigDecimal.valueOf(0.05d), BigDecimal.valueOf(0.9d));
      studyResults.setrValue (BigDecimal.valueOf(.08d));
      trial.setpVal (studyResults);
      try {
         UniversalValidator.validate (trial, PostTrial.class);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
         throw ce;
      }
   }

   @Test
   public void test_post_pdufa_successful_trial () {

      ClinicalTrial trial = new ClinicalTrial ();
      StudyCorrelation studyResults = new StudyCorrelation (BigDecimal.valueOf(0.05d), BigDecimal.valueOf(0.9d));
      studyResults.setrValue (BigDecimal.valueOf(.02d));
      trial.setpVal (studyResults);
      try {
         UniversalValidator.validate (trial, PostTrial.class);
      } catch (ConstraintViolationException ce) {
         UniversalValidator.violation (ce, System.out);
         throw ce;
      }
   }
}
