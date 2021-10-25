package com.openlending.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class InvestorRelations {

    public String year2020 = "2020";
    public String year2021 = "2021";
    public String none = "None";

    public WebElement newsAndEventsLink(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='main-menu']/ul[@role='menubar']/li[3]/a[@href='/news-and-events/news-releases']"));
    }

    public void waitForNewsReleasesMessage(WebDriver driver, int timeOutSeconds) {
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(presenceOfElementLocated(By.xpath("//div[@class='large-8 small-12 column']//h1[contains(text(),'News Releases')]")));
    }

    public void chosenDrop(WebDriver driver, String value) {
        WebElement dropDown = driver.findElement(By.xpath("//form[@id='widget-form-base']/div/div/div//span"));
        dropDown.click();
        String xPath = String.format("//form[@id='widget-form-base']/div/div/div//li[.='%s']", value );
        dropDown.findElement(By.xpath(xPath)).click();
    }

    public WebElement filterButton(WebDriver driver) {
        return driver.findElement(By.id("edit-submit"));
    }

    public WebElement findLinkText(WebDriver driver, String textLink) {
        return driver.findElement(By.partialLinkText(textLink));
    }

    public WebElement pdfVersion(WebDriver driver) {
        return driver.findElement(By.linkText("PDF Version"));
    }

    public WebElement documentDownload(WebDriver driver) {
        driver.switchTo().defaultContent(); // you are now outside both frames
        driver.switchTo().frame("dc-view-frame");
        return driver.findElement(By.id("documentDownload"));
    }

}
