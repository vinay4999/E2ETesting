package Loginflow;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import resources.Base;

/**
 * Scenarios covered in the script
 *
 * Case 1: Wrong username as input
 * Case 2: Empty username as input
 * Case 3: Wrong Password as input
 * Case 4: Empty Password as input
 * Case 5: Empty username and password
 *
 */
public class wrongUserNamePassword extends Base {

    @Parameters(value = { "browser", "platform"})
    @BeforeTest
    public void initialize(String browser,String platform) throws IOException
    {

        driver =initializeDriver(browser,platform);

    }
    @Test(dataProvider="getData")

    public void verifyUsernamePassword(String Username,String Password,String Error) throws IOException
    {

        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver,10);
        Homepage home=new Homepage(driver);

        wait.until(ExpectedConditions.visibilityOf(home.getUsername()));
        home.getUsername().sendKeys(Username);
        home.getPassword().sendKeys(Password);
        home.getLogin().click();

        Assert.assertEquals(home.getUsername().isDisplayed(),true);
        log.info(Error);

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

        Object[][] data=new Object[5][3];

        //case 1
        data[0][0]="1";
        data[0][1]="Quocom@123";
        data[0][2]="Wrong Username";
        //case 2
        data[1][0]="";
        data[1][1]="Quocom@123";
        data[1][2]="Empty Username";
        //case 3
        data[2][0]="quocom13@gmail.com";
        data[2][1]="Quocom@1234";
        data[2][2]="Wrong Password";
        //case 4
        data[3][0]="quocom13@gmail.com";
        data[3][1]="";
        data[3][2]="Empty Password";
        //case 5
        data[4][0]="2";
        data[4][1]="456788";
        data[4][2]="Empty Username and Password";

        return data;

    }

}
