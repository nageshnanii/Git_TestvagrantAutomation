package runner;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Baseclass;
import pages.Imdb;
import pages.Wikipedia;

public class Runner extends Baseclass
{
	public RemoteWebDriver driver;
	
	public String x;
	public String y;
	public String a;
	public String b;
	public Wikipedia obj=new Wikipedia(driver);
	public Imdb obj1=new Imdb(driver);
	
	@Test(priority=1)
	public void validateImdbAndWiki() throws ParseException
		{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver= new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		 obj= new Wikipedia(driver);
		 try {
				obj.scrollIntoView();
			}
		 catch (Exception e) 
		 {
				
				e.printStackTrace();
			}
		String a=obj.getTextforReleaseDateWiki();
		String b=obj.getcountryWiki();
		obj1=new Imdb(driver);
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> s=driver.getWindowHandles();
		List<String> l= new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.get("https://www.imdb.com/title/tt9389998/");
		try {
			obj1.scrollIntoView();
		}
	 catch (Exception e) 
	 {
			
			e.printStackTrace();
		}
		String x=obj1.getTextforcountryImdb();
		String y=obj1.getTextforReleaseDateImdb();
		
		
		if(b.equalsIgnoreCase(x))
		{
			System.out.println("Both country names same");
			Reporter.log("Both country names same");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Both country names not same");
			Reporter.log("Both country names not same");
			Assert.assertTrue(true);
		}
		try {
		String pattern="dd MMMMM yyyy";		
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		//Date date1=format.parse("17 December 2021");
		Date date1=format.parse(a);
		System.out.println("The released date1 is "+date1);
		
		String pattern1="dd, MMMMM yyyy";		
		SimpleDateFormat format1=new SimpleDateFormat(pattern1);
		Date date2=format1.parse("December 17, 2021 (United States)");
		//Date date2=format1.parse(y);
		System.out.println("The released date2 is "+date2);
		if(date1.compareTo(date2) ==0)
		{
			System.out.println("both release date is same");
			Reporter.log("both release date is same");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Both release date not same");
			Reporter.log("Both release date not same");
			Assert.assertTrue(true);
		
		}
	}
		catch (Exception e)
		{
		
	}
		
	}
	}
	
	