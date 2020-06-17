package org.example.schoology.pages;

import org.example.AbstractPage;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
		return new SubMenu();
	}

	public Resources clickResourcesMenuOption(){
		driver.findElement(By.xpath("//header[@class='_1SIMq _3v0y7 _349XD']/descendant::a[@href='/resources']")).click();
		return new Resources();

	}

}
