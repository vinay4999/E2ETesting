package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBookingpage {

    public WebDriver driver;

    By roundTrip=By.xpath("//*[@value='roundtrip']");
    By sign_Off=By.xpath("//a[text()='SIGN-OFF']");
    By login=By.xpath("//*[@name='login']");
    By passengerCount=By.xpath("//*[@name='passCount']");
    By departing = By.xpath("//*[@name='fromPort']");
    By fromMonth = By.xpath("//*[@name='fromMonth']");
    By fromDay = By.xpath("//*[@name='fromDay']");
    By dest = By.xpath("//*[@name='toPort']");
    By toMonth = By.xpath("//*[@name='toMonth']");
    By toDay = By.xpath("//*[@name='toDay']");
    By findFlights = By.xpath("//*[@name='findFlights']");
    By reserveFlights = By.xpath("//*[@name='reserveFlights']");
    By userName = By.xpath("//*[@name='passFirst0']");
    By lastName = By.xpath("//*[@name='passLast0']");
    By creditnumber = By.xpath("//*[@name='creditnumber']");
    By expiryMonth = By.xpath("//*[@name='cc_exp_dt_mn']");
    By expiryYear = By.xpath("//*[@name='cc_exp_dt_yr']");
    By buyFlights = By.xpath("//*[@name='buyFlights']");
    By confirmation = By.xpath("//*[text()='Delivery Address (N/A for Ticketless Travel)']");
    By onewaytrip = By.xpath("//*[@value='oneway']");
    By businessclass = By.xpath("//*[@value='Business']");
    By firstclass = By.xpath("//*[@value='First']");
    By economyclass = By.xpath("//*[@value='Coach']");
    By airline = By.xpath("//*[@name='airline']");
    By cruises = By.xpath("//*[text()='Cruises']");
    By booking = By.xpath("(//*[contains(@href,'mercuryreservation.php')])[2]");

    public FlightBookingpage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getRoundTrip() { return driver.findElement(roundTrip); }
    public WebElement getSignOut()
    {
        return driver.findElement(sign_Off);
    }
    public WebElement getLogin()
    {
        return driver.findElement(login);
    }
    public WebElement getPassenger() { return driver.findElement(passengerCount); }
    public WebElement getDepartingDestination() { return driver.findElement(departing); }
    public WebElement getDepartingMonth() { return driver.findElement(fromMonth); }
    public WebElement getDepartingDate() { return driver.findElement(fromDay); }
    public WebElement getDestination() { return driver.findElement(dest); }
    public WebElement getDestMonth() { return driver.findElement(toMonth); }
    public WebElement getDestDate() { return driver.findElement(toDay); }
    public WebElement getFlights() { return driver.findElement(findFlights); }
    public WebElement getReserveFlight() { return driver.findElement(reserveFlights); }
    public WebElement getUsername() { return driver.findElement(userName); }
    public WebElement getLastname() { return driver.findElement(lastName); }
    public WebElement getCreditCard() { return driver.findElement(creditnumber); }
    public WebElement getexpiryYear() { return driver.findElement(expiryYear); }
    public WebElement getexpiryMonth() { return driver.findElement(expiryMonth); }
    public WebElement getBuyFlight() { return driver.findElement(buyFlights); }
    public WebElement getConfirmation() { return driver.findElement(confirmation); }
    public WebElement getOnewaytrip() { return driver.findElement(onewaytrip); }
    public WebElement getBusinessClass() { return driver.findElement(businessclass); }
    public WebElement getFirstClass() { return driver.findElement(firstclass); }
    public WebElement getEconomyClass() { return driver.findElement(economyclass); }
    public WebElement getAirline() { return driver.findElement(airline); }
    public WebElement getCruises() { return driver.findElement(cruises); }
    public WebElement getCruiseBooking() { return driver.findElement(booking); }


}
