package Loginflow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.FlightBookingpage;
import pageObjects.Homepage;
import resources.Base;
import java.io.IOException;

/**
 * Scenarios covered in the script
 *
 * Sign and Sign out of user
 *
 */

public class signINSignOut extends Base {

    @Parameters(value = { "browser", "platform"})
    @BeforeTest
    public void initialize(String browser,String platform) throws IOException
    {
        driver =initializeDriver(browser,platform);
    }
    @Test(dataProvider="getData")

    public void basePageNavigation(String Username,String Password,String text) throws IOException
    {
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver,10);
        Homepage home=new Homepage(driver);
        FlightBookingpage flight = new FlightBookingpage(driver);

        wait.until(ExpectedConditions.visibilityOf(home.getUsername()));
        home.getUsername().sendKeys(Username);
        home.getPassword().sendKeys(Password);
        home.getLogin().click();

        Assert.assertEquals(flight.getRoundTrip().isDisplayed(),true,"Login not successfull");

        wait.until(ExpectedConditions.visibilityOf(flight.getSignOut()));
        flight.getSignOut().click();
        Assert.assertEquals(home.getUsername().isDisplayed(),true,"Logout not successfull");
        log.info("Sign out");

    }

    @AfterTest
    public void teardown()
    {

        driver.close();
        driver=null;

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data=new Object[1][3];

        data[0][0]="quocom13@gmail.com";
        data[0][1]="Quocom@123";
        data[0][2]="valid user";

        return data;
    }
}
