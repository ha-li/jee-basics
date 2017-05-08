package com.gecko.domain;

import com.gecko.constraints.Pdufa;
import com.gecko.constraints.groups.PostTrial;

import java.util.Date;

/**
 * Created by hlieu on 05/7/17.
 */
@Pdufa(groups = {PostTrial.class})
public class ClinicalTrial {

   // TODO - make this an enum {I, II, III, IV}
   private String phase;

   private Date pdufa;

   private StudyCorrelation pVal;

   public StudyCorrelation getpVal () {
      return pVal;
   }

   public void setpVal (StudyCorrelation pVal) {
      this.pVal = pVal;
   }

   public String getPhase () {
      return phase;
   }

   public void setPhase (String phase) {
      this.phase = phase;
   }

   public Date getPdufa () {
      return pdufa;
   }

   public void setPdufa (Date pdufa) {
      this.pdufa = pdufa;
   }
}
