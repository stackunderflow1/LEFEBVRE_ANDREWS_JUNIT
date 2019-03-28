package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	
	
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }
	  
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTime_case1() {
		ntc.setStartTime(-5);
	    ntc.setDuration(10);
	    ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case1() {
	    ntc.setStartTime(1800);
	    ntc.setDuration(0);
	    ntc.computeCharge();
	} 
	
	@Test
	public void testComputeCharge_BothDiscounts() {
	    ntc.setStartTime(500);
	    ntc.setDuration(100);
	    double expResult = 1768.0 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	  }
	
	  @Test
	  public void testComputeCharge_StartTimeDiscountOnly() {
	    ntc.setStartTime(0);
	    ntc.setDuration(60);
	    double expResult = 1248.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    
	  }
	  
	  @Test
	  public void testComputeCharge_DurationDiscountOnly() {
	    ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    double expResult = 1664.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	  } 
	  
	  @Test
	  public void testComputeCharge_NoDiscounts() {
	    ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    double expResult = 1664.00  ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	  }
	  
	

}
