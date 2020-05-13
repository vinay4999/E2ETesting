package Booking;

import common.CommonMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.FlightBookingpage;
import pageObjects.Homepage;
import resources.Base;

import java.io.IOException;

public class ticketBookingUnifiedAirlines extends Base {

    @Parameters(value = { "browser", "platform"})
    @BeforeTest
    public void initialize(String browser,String platform) throws IOException
    {
        driver =initializeDriver(browser,platform);
    }
    @Test(dataProvider="getData")

    public void basePageNavigation(String Username,String Password,String text) throws IOException, InterruptedException {
        driver.get(prop.getProperty("url"));
        wait = new WebDriverWait(driver,10);
        Homepage home=new Homepage(driver);
        CommonMethods common = new CommonMethods();
        FlightBookingpage flight = new FlightBookingpage(driver);

        wait.until(ExpectedConditions.visibilityOf(home.getUsername()));
        home.getUsername().sendKeys(Username);
        home.getPassword().sendKeys(Password);
        home.getLogin().click();

        common.selection(flight.getPassenger());
        select.selectByValue(String.valueOf(common.passengerCountGenerator()));
        common.selection(flight.getDepartingDestination());
        select.selectByValue(common.DepatingDestinationSelector());
        common.selection(flight.getDepartingMonth());
        select.selectByValue(String.valueOf(common.monthGeneartor()));
        common.selection(flight.getDepartingDate());
        select.selectByValue(String.valueOf(common.DayGeneartor()));
        common.selection(flight.getDestination());
        select.selectByValue(common.DepatingDestinationSelector());
        common.selection(flight.getDestMonth());
        select.selectByValue(String.valueOf(common.monthGeneartor()));
        common.selection(flight.getDestDate());
        select.selectByValue(String.valueOf(common.DayGeneartor()));
        common.selection(flight.getAirline());
        select.selectByVisibleText("Unified Airlines");
        flight.getFlights().click();

        wait.until(ExpectedConditions.visibilityOf(flight.getReserveFlight()));
        flight.getReserveFlight().click();
        flight.getUsername().sendKeys("Ganesh");
        flight.getLastname().sendKeys("Mahesh");
        flight.getCreditCard().sendKeys("4563352694535569");
        common.selection(flight.getexpiryMonth());
        select.selectByVisibleText("04");
        common.selection(flight.getexpiryYear());
        select.selectByValue("2008");
        flight.getBuyFlight().click();
        Assert.assertEquals(flight.getConfirmation().isDisplayed(),true,"Flight booking failed");

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
