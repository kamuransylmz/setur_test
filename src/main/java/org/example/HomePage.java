package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public By toWhere = By.xpath("//input[@value = '']");
    public By searchButton = By.xpath(".//span[text()='Ara']");
    public By setDate = By.xpath("//*[contains(text(),'Giriş - Çıkış Tarihleri')]");


    public String searchHotel(String hotelName) {
        waitFor(searchButton);
        //driver.findElement(toWhere).click();
        driver.findElement(toWhere).sendKeys(hotelName);
         return hotelName;
    }

    public Date setDateForHotel(Date date) {
        waitFor(searchButton);
        driver.findElement(setDate).click();

        return date;
    }

    private void waitFor(By Locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

}