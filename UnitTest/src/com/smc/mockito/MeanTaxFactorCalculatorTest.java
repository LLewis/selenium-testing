package com.smc.mockito;
//package Mockito;
//
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.mock.*;
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MeanTaxFactorCalculatorTest {
//	
//	static final double TAX_FACTOR = 10;
//	//Annotate the test fields with the @Mock or @Spy annotation to have either a 
//	//mock or spy object instantiated
//	@Mock TaxService taxService;
//	
//	//Annotate the test fields with the @InjectMocks annotation to first instantiate
//	//the @InjectMock annotated field and then inject all the @Mock or @Spy
//	//annotated fields into it (if applicable)
//	@InjectMocks MeanTaxFactorCalculator systemUnderTest;
//	
//	@Test
//	public void should_calculate_mean_tax_factor(){
//		//given
//		given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn (TAX_FACTOR);
//		//when
//		double meanTaxFactor =
//			systemUnderTest.calculatorMeanTaxFactorFor(new Person());
//		
//		//then
//	  then(meanTaxFactor).isEqualTo
//		(TAX_FACTOR);
//		
//	}
//
//	private Object then(double meanTaxFactor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private Object given(double currentTaxFactorFor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private Person any(Class<Person> class1) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	
//	
//	
//
//	
//
//}
