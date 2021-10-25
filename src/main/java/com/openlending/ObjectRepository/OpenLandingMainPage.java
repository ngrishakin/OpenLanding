package com.openlending.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenLandingMainPage {

    public WebElement investorRelationsLink(WebDriver driver) {
        //driver.manage().window().fullscreen();
        return driver.findElement(By.id("DrpDwnMn13label"));
    }

    public WebElement investorRelationsText(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='banner-content']//h1[contains(text(),'Investor Relations')]"));
    }

}
