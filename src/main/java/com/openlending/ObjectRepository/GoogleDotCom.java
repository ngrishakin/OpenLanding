package com.openlending.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleDotCom {

    private static WebDriverWait wait;

    public void searchGoogle(WebDriver driver, String searchString) {
        wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        driver.findElement(By.name("q")).sendKeys(searchString + Keys.ENTER);
        driver.manage().window().fullscreen();
    }

    public WebElement findLinkText(WebDriver driver, String textLink) {
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(textLink))));
        driver.manage().window().fullscreen();
        return driver.findElement(By.partialLinkText(textLink));
        //h3[contains(text(),'| Open Lending | United States')]
    }


}
