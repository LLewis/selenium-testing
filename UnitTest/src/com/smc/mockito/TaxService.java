package com.smc.mockito;

//package com.blogspot.toomuchcoding.book.chapter1.common;


//import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {   
	
	double getCurrentTaxFactorFor(Person person);

	double getCurrentTaxFactorFor(Class<Person> person);
	
}