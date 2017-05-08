package com.gecko.domain;

import com.gecko.constraints.FdaAccepted;

import java.math.BigDecimal;

/**
 * Created by hlieu on 05/7/17.
 */

public class StudyCorrelation {

   private BigDecimal rValueMin;
   private BigDecimal rValueMax;
   private BigDecimal rValue;


   @FdaAccepted
   public StudyCorrelation (BigDecimal min, BigDecimal max) {
      rValueMin = min;
      rValueMax = max;
   }

   public BigDecimal getrValueMin () {
      return rValueMin;
   }

   public void setrValueMin (BigDecimal rValueMin) {
      this.rValueMin = rValueMin;
   }

   public BigDecimal getrValueMax () {
      return rValueMax;
   }

   public void setrValueMax (BigDecimal rValueMax) {
      this.rValueMax = rValueMax;
   }

   public BigDecimal getrValue () {
      return rValue;
   }

   public void setrValue (BigDecimal rValue) {
      this.rValue = rValue;
   }
}
