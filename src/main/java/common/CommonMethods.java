package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import resources.Base;

import java.util.*;

public class CommonMethods extends Base {

    Random rand = new Random();
    List<String> destinationList = new ArrayList<String>();

    //Set<String> destinationList = new HashSet<String>();

    public int passengerCountGenerator()
    {
        int passengerCount = (int)(Math.random() * 4 + 1);
        return passengerCount;
    }

    public void destinationListGenerator()
    {
        destinationList.add("Acapulco");
        destinationList.add("Frankfurt");
        destinationList.add("London");
        destinationList.add("New York");
        destinationList.add("Paris");
        destinationList.add("Portland");
        destinationList.add("San Francisco");
        destinationList.add("Seattle");
        destinationList.add("Sydney");
        destinationList.add("Zurich");
    }

    public String DepatingDestinationSelector()
    {
        destinationListGenerator();
        int randomdest = (int)(Math.random() * 10 );
        return destinationList.get(randomdest);
    }

    public int monthGeneartor()
    {
        int month = (int)(Math.random() * 12) + 1;
        return month;
    }

    public int DayGeneartor()
    {
        int month = (int)(Math.random() * 31) + 1;
        return month;
    }

    public void selection(WebElement s)
    {
        select = new Select(s);
    }

}
