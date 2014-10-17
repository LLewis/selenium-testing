package com.smc.mockito;

public class MeanTaxFactorCalculator {
	
	private final TaxService taxService;
	
	public MeanTaxFactorCalculator(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public double calculatorMeanTaxFactorFor (Person person){
		double currentTaxFactor = 
				taxService.getCurrentTaxFactorFor(person);
		double anotherTaxFactor =
				taxService.getCurrentTaxFactorFor(person);
		return (currentTaxFactor + anotherTaxFactor) * 2;
	
	}
}
