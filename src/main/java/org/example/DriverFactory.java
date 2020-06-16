package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;

public class DriverFactory {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void addDriver(WebDriver driver){
        drivers.set(driver);

    }

    public static WebDriver getDriver(){
        return drivers.get();
    }


}
