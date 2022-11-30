package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia extends Baseclass
{
	@FindBy(xpath="(//*[text()='India'])[1]")
			public WebElement country;
	
	@FindBy(xpath="(//*[@class='infobox-data'])[10]")
	public WebElement releaseDate;
	
	public   RemoteWebDriver driver;
	
	public   Wikipedia(RemoteWebDriver driver)
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
     public String getTextforReleaseDateWiki()
     {
    	 String a=releaseDate.getText();
    	 System.out.println(a);
    	 return a;
     }
     public String getcountryWiki()
     {
    	 String b=country.getText();
    	 System.out.println(b);
    	 return b;
     }
    
}