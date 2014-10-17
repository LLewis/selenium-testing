package CodeTest;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.Test;


/**
 * This class builds and prints out the original arraryList of numbers then gets the max number from the list.
 * It then compares the max number to each element in the original list, if it's less than the max it builds another list.
 * It then gets the max number from the new list.   
 * @author llewis
 *
 */
public class SecondHighestNumber {

	
	
	ArrayList<Integer> myList = new ArrayList<Integer>();
	ArrayList<Integer> secondHighestNumList = new ArrayList<Integer>();
	
	@Test
	public void getMylist (){
		myList.add(22);
		myList.add(307);
		myList.add(777);
		myList.add(12);
		
		System.out.printf("This is my Original List %s\n", myList);
		
		int maxValue = Collections.max(myList);
		
		System.out.printf("This is the max value %s \n", maxValue);
		
		for(Integer num : myList)
			if(maxValue > num){
				secondHighestNumList.add(num);
			}
		int secondHighestMaxNum  = Collections.max(secondHighestNumList);
		
		System.out.printf("This is my Second List %s\n", secondHighestNumList);
		System.out.printf("The second highest number in the list is: %s \n", secondHighestMaxNum);
		
		
	}
	
}
