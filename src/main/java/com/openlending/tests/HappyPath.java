/*
 * Copyright (c) Dematic GmbH 2018. All rights reserved. Confidential.
 */
package com.openlending.tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.openlending.ObjectRepository.GoogleDotCom;
import com.openlending.ObjectRepository.InvestorRelations;
import com.openlending.ObjectRepository.OpenLandingMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ngrishakin
 */
public class HappyPath  {

   private WebDriver driver;
   GoogleDotCom googleDotCom = new GoogleDotCom();
   OpenLandingMainPage openLandingMainPage = new OpenLandingMainPage();
   InvestorRelations investorRelations = new InvestorRelations();

   @BeforeClass
   public void testSetup() throws Exception {

   }

     @Test(priority = 1, alwaysRun = true)
     public void test_01_OpenGoogle() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://www.google.com/");
      driver.manage().window().fullscreen();
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("document.body.style.zoom='100%';");
      System.out.println("Main Window Title: " + driver.getTitle());
      Assert.assertTrue(driver.getTitle().contains("Google"));
   }

    @Test(priority = 2, alwaysRun = true)
    public void test_02_SearchForOpenLending() throws Exception {
        googleDotCom.searchGoogle(driver, "Open Lending");
        googleDotCom.findLinkText(driver, "Automated Lending Platform | Open Lending | United States").click();
        System.out.println("Main Window Title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Automated Lending Platform | Open Lending | United States"));
    }

    @Test(priority = 3, alwaysRun = true)
    public void test_03_ClickOnInvestorRelationsLink()  {
       openLandingMainPage.investorRelationsLink(driver).click();
       // put all window handles in array list
       ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
       //switch to new tab
       driver.switchTo().window(newTb.get(1));
       System.out.println("Page title of new tab: " + driver.getTitle());
       driver.manage().window().fullscreen();
       Assert.assertTrue(openLandingMainPage.investorRelationsText(driver).getText().contains("Investor Relations"));
    }

    @Test(priority = 4, alwaysRun = true)
    public void test_04_InvestorRelations() {
       driver.manage().window().fullscreen();
       investorRelations.newsAndEventsLink(driver).click();
       investorRelations.waitForNewsReleasesMessage(driver, 20); // wait for "News Releases" message to show up
       investorRelations.chosenDrop(driver, investorRelations.year2021);
       investorRelations.filterButton(driver).click();
       driver.manage().window().fullscreen();
       investorRelations.findLinkText(driver, "Open Lending to Announce First Quarter 2021 Results on May 11, 2021").click();
       System.out.println("Page title of new tab: " + driver.getTitle());
       driver.manage().window().fullscreen();
       investorRelations.pdfVersion(driver).click();
       ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
       //switch to new tab
       driver.switchTo().window(newTb.get(2));
       System.out.println("Page title of new tab: " + driver.getTitle());
       driver.manage().window().fullscreen();
       investorRelations.documentDownload(driver).click();

    }


   @AfterClass
   public void testCleanUp() throws Exception {
        driver.quit();
   }
}
