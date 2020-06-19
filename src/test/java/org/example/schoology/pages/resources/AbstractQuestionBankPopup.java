package org.example.schoology.pages.resources;

import org.example.AbstractPage;
import org.example.schoology.pages.Step;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractQuestionBankPopup extends AbstractPage {

    protected void fillFields(Map<String, String> questionBankValuesMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(questionBankValuesMap.get("name")));
        stepsMap.put("description", () -> setDescription(questionBankValuesMap.get("description")));
        stepsMap.put("enable question Tracking", () -> setEnableQuestionTracking(questionBankValuesMap.get("enable question Tracking")));

        for (Step step : stepsMap.values()) {
            step.execute();
        }
    }

    public abstract void setName(String name);
    public abstract void setDescription(String description);
    public abstract void setEnableQuestionTracking(String condition);
}
