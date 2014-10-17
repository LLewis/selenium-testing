package com.smc.jmockit;

import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;


/********** BankTest.java **************/
@RunWith(JMockit.class)
public class BankTest {
 
 @Test
 public void testMakeConnectionWithMockUp(){
  new MockUp<DBManager>(){
    
   // Redefine the method here
   // But With No static modifier
   @Mock
   public String getConnectionString(){
    return "DUPLICATE";
   }
 
  };
   
  Bank bank =  new Bank();
  String status = bank.makeConnection();
   System.out.println("This is the new status:  " +  status);// LL added 
   
   
  assertEquals("Status is FAIL","FAIL",status);
 }
}