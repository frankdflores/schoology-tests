package org.example.schoology.pages.resources;

/**
 * @author Veronica Prado
 */
public enum PageResourceForm {
    TITLE("Title"),
    RESOURCE_NOTES("Resource Notes"),
    CONTENT("Content"),
    LEVEL("Level"),
    RESOURCE_TYPE("Resource Type"),
    SUBJECT("Subject"),
    LEARNING_OBJECTIVES("Learning Objectives");

    private final String name;

    PageResourceForm(final String name) {this.name = name;}

    public String getName() {return name;}
}
