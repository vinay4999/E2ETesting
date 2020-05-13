package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;

	By userName=By.xpath("//*[@name='userName']");
	By password=By.xpath("//*[@name='password']");
	By login=By.xpath("//*[@name='login']");

	public Homepage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUsername()
	{
		return driver.findElement(userName);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}

}
