package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Imdb extends Baseclass
{
	@FindBy(xpath="//*[text()='Country of origin']/following::a[1]")
	public WebElement country;

	@FindBy(xpath="//*[text()='Release date']/following::*[1]")
     public WebElement releaseDate;

      public   RemoteWebDriver driver;

     public   Imdb(RemoteWebDriver driver)
     {
           PageFactory.initElements(driver , this);
           this.driver=driver;
     }
     
    
public  void  scrollIntoView()  throws   Exception
{
 //get visibility of element of page in desktop
 //WebElement e driver.findelement(By.xpath("(//pre)[1]"));
 driver.executeScript("arguments[0].scrollIntoView();",releaseDate);
 Thread.sleep(5000);
}

public String getTextforcountryImdb()
{
 String x=country.getText();
 System.out.println(x);
 return x;
}
public String getTextforReleaseDateImdb()
{
 String y=releaseDate.getText();
 System.out.println(y);
 return y;
}

}
