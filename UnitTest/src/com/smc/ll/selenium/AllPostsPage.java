package com.smc.ll.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AllPostsPage {

	RemoteWebDriver driver;
	WebElement postsContainer, searchPosts, viewByCategories;
	
	public AllPostsPage(RemoteWebDriver driver){
		this.driver = driver;
		driver.get("http://developerlatonyalewis.wordpress.com/wp-admin/edit.php");
	}
	/**
	 * Map the services "create new post" on the page to method
	 * @param title
	 * @param description
	 */
	public void createNewPost(String title, String description){
		
	}
	/**
	 * Mapped the service "edit a post" on the  page to method
	 * @param title
	 */
	public void editAPost(String title){
		
	}
	/**
	 * Mapped the service "delete a post" on the page to method
	 * @param postTitle
	 */
	public void deleteAPost(String postTitle){
		
	}
	/**
	 * Mapped the service "filter post by Category" on the page to method
	 * @param category
	 */
	public void filterPostsByCategor(String category){
		
	}
	/**
	 * Mapped the service "search in posts" on the page to method
	 * @param searchText
	 */
	public void searchInPosts(String searchText){
		
	}
	/**
	 * Implied Services, not identified on the page, however, count the number of post on the page
	 * @return
	 */
	public int getAllPostsCount(){
		return 0;
		
	}
}
