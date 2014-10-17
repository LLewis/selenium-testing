package com.smc.selenium;
import org.junit.Before;
import org.junit.Test;


public class MockitoTest {
	
	   CurrentPricingRequests_New objectUnderTest;
	

	    CurrentPricingRequests_New newPricingRequest = mock(CurrentPricingRequests_New.class);

	    @Before
	    public void setUp(){
	       
			//objectUnderTest = new CurrentPricingRequets();
	    }

	    private CurrentPricingRequests_New mock(Class<CurrentPricingRequests_New> class1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Test
	    public void shouldReturnAFirstCourseMealWhenOrderedHamburger() throws Exception {
	        //given
			objectUnderTest.doNavigate();
	        //String mealName = "Hamburger";
	        //boolean vegetarian = false;
	        //Meal referenceMeal = new FirstCourse();
	        //when(kitchenServiceMock.prepareMeal(mealName, vegetarian)).thenReturn(referenceMeal);

	        //when
	        //Meal orderedMeal = objectUnderTest.bringOrderedMeal(mealName, vegetarian);

	        //then
	        //assertThat(orderedMeal, is(referenceMeal));
	        //verify(kitchenServiceMock).prepareMeal(mealName, vegetarian);
	    }

	    @Test
	    public void shouldThrowAnExceptionWhenAMealOfImproperTypeHasBeenReturnedFromTheKitchen() throws Exception {
	        //given
	    	//objectUnderTest.doLoginUser();
	        //String mealName = "Hamburger";
	        //boolean vegetarian = false;
	        //Meal referenceMeal = new VegetarianFirstCourse();
	        //when(kitchenServiceMock.prepareMeal(mealName, vegetarian)).thenReturn(referenceMeal);

	        //when
	        //try{
	          //  objectUnderTest.bringOrderedMeal(mealName, vegetarian);
	           // fail();
	        //}catch(WrongMealException wrongMealException){

	        //}

	        //then
	        //verify(kitchenServiceMock).prepareMeal(mealName, vegetarian);
	    }


}
