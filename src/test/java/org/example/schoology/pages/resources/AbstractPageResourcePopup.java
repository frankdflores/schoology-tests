package org.example.schoology.pages.resources;

import org.example.core.Environment;
import org.example.core.ui.AbstractPage;
import org.example.schoology.Resources;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Veronica Prado
 */
public abstract class AbstractPageResourcePopup extends AbstractPage {

    @FindBy(id = "edit-template-fields-title")
    private WebElement titlePageTextField;

    @FindBy(id = "edit-description")
    private WebElement resourceNotesTextField;

    @FindBy(id = "edit-description")
    protected WebElement ResourceNotes;

    @FindBy(css = "#edit-grade-level-range-start")
    private WebElement levelDropDown;

    @FindBy(id = "resource-info-selector")
    private WebElement optionsButton;

    @FindBy(id = "s-library-collection-template-form")
    private WebElement addForm;

    private final ResourceBundle bundle;
    public AbstractPageResourcePopup() {
        super();
        bundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE, Environment.getInstance().getLocale());
    }

    public void fill(final Map<PageResourceForm, String> resourceMap) {
        EnumMap<PageResourceForm, Step> stepMap = new EnumMap<>(PageResourceForm.class);
        stepMap.put(PageResourceForm.TITLE, () -> setTitle(resourceMap.get(PageResourceForm.TITLE)));
        stepMap.put(PageResourceForm.RESOURCE_NOTES, () -> setResourceNotes(resourceMap.get(PageResourceForm.RESOURCE_NOTES)));

        for (final PageResourceForm keyField : resourceMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }


    public void setTitle(final String title)
    {
        action.setValue(titlePageTextField, title);
    }


    public void setResourceNotes(final String resourceNotes)
    {
        action.setValue(resourceNotesTextField, resourceNotes);
    }

    public void submitButton() {
        String keyAddPageResource = "resource.Page.SubmitButton";
        WebElement submitBtn = addForm.findElement(By.cssSelector(String.format("[value='%s']",
                bundle.getString(keyAddPageResource))));
        action.jsClick(submitBtn);
    }
    public WebElement OptionsButton()
    {
        return optionsButton;
    }
}
