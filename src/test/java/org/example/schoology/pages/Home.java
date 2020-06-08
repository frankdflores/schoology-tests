package org.example.schoology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
		return new SubMenu(driver);
	}

	public Resources clickResourcesMenuOption(){
		driver.findElement(By.xpath("//header[@class='_1SIMq _3v0y7 _349XD']/descendant::a[@href='/resources']")).click();
		return new Resources(driver);

	}

}
