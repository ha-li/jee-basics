package com.gecko.test.beans;

import com.gecko.constraints.Email;
import com.gecko.constraints.URL;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hlieu on 04/28/17.
 */
public class TestBean {

   public TestBean () {}


   public TestBean (@DecimalMax ("9.99") BigDecimal price) {
      this.pValue = price;
   }

   @NotNull
   public TestBean (BigDecimal minCorrelation, BigDecimal maxCorrelation) {

   }

   @AssertFalse
   private Boolean mustBeFalse;

   @AssertTrue
   private Boolean mustBeTrue;

   @DecimalMax (value="1.0")
   @DecimalMin (value="-1.0")
   private BigDecimal correlation;

   @Digits (integer=2, fraction=3)
   private BigDecimal pValue;

   @Future
   private Date offload;

   @Past
   private Date createdDate;

   @Max (value=4)
   BigDecimal count;

   @Size (min=1, max=5)
   private List<Integer> all;

   @Email
   private String email;

   @URL (protocol="http", host="www.home.com", port=80)
   private String personalWeb;

   @URL (protocol="ftp", port=21)
   private String personalFtp;

   @URL (protocol="http", host="my.home.com", port=80)
   private java.net.URL alternativeWeb;

   @NotNull
   public BigDecimal calculatePrice (@DecimalMin(value="1.4") @DecimalMax(value="1.9") BigDecimal tax){
      return pValue.multiply (tax);
   }

   // everything in the store must be less than $10.00
   @DecimalMax(value="9.99")
   public BigDecimal isStoreGuaranteeValid () {
      return calculatePrice (BigDecimal.valueOf(1.4d));
   }

   public java.net.URL getAlternativeWeb () {
      return alternativeWeb;
   }

   public void setAlternativeWeb (java.net.URL alternativeWeb) {
      this.alternativeWeb = alternativeWeb;
   }

   public String getPersonalWeb () {
      return personalWeb;
   }

   public void setPersonalWeb (String personalWeb) {
      this.personalWeb = personalWeb;
   }

   public String getPersonalFtp () {
      return personalFtp;
   }

   public void setPersonalFtp (String personalFtp) {
      this.personalFtp = personalFtp;
   }

   public String getEmail () {
      return email;
   }

   public void setEmail (String email) {
      this.email = email;
   }

   public List<Integer> getAll () {
      return all;
   }

   public void setAll (List<Integer> all) {
      this.all = all;
   }

   public BigDecimal getCount () {
      return count;
   }

   public void setCount (BigDecimal count) {
      this.count = count;
   }

   public Date getCreatedDate () {
      return createdDate;
   }

   public void setCreatedDate (Date createdDate) {
      this.createdDate = createdDate;
   }

   public Date getOffload () {
      return offload;
   }

   public void setOffload (Date offload) {
      this.offload = offload;
   }

   public BigDecimal getpValue () {
      return pValue;
   }

   public void setpValue (BigDecimal pValue) {
      this.pValue = pValue;
   }

   public BigDecimal getCorrelation () {
      return correlation;
   }

   public void setCorrelation (BigDecimal correlation) {
      this.correlation = correlation;
   }

   public Boolean getMustBeTrue () {
      return mustBeTrue;
   }

   public void setMustBeTrue (Boolean mustBeTrue) {
      this.mustBeTrue = mustBeTrue;
   }

   public Boolean getMustBeFalse () {
      return mustBeFalse;
   }

   public void setMustBeFalse (Boolean mustBeFalse) {
      this.mustBeFalse = mustBeFalse;
   }
}
