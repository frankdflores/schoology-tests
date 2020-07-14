package org.example.schoology.pages.groups;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {

    private WebDriver driver;

    @FindBy(css = "a.create-group")
    WebElement createGroup;

    public Groups(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public CreateGroupPopup openGroupsModal(){

        createGroup.click();
        return new CreateGroupPopup(driver);

    }
}
