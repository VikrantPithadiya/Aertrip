package basic_selenium;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aertrip {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Vikrant\\VIKRANT\\selenium work\\Driver\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait=new WebDriverWait(driver, 20);

		driver.manage().window().maximize();

		// URL
		driver.navigate().to("https://aertrip.com/flights#/search");

		// Hotels
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotels-module\"]"))).click();

		Thread.sleep(4000);
		
		// Location Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autocomplete-js\"]"))).clear();

		// Location name enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autocomplete-js\"]"))).sendKeys("Dublin");
		
		//Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//li[2]/span[1]/strong"))).click();
		
		// Click on Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flights-page\"]/body/view/view/view[2]/div[1]/view/div[1]/div/div[1]/div[1]/div[2]/jq-daterange1/div[1]/div[1]/div"))).click();
		
		// Select Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("9"))).click();

		// Select Room
		driver.findElement(By.xpath("//*[@id=\"guests\"]")).click();

		// Child select
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[2]/div[3]/div[1]/i")).click();

		// Clear age 
		driver.findElement(By.className("numberInput")).clear();

		// Enter Child age 
		driver.findElement(By.className("numberInput")).sendKeys("10");

		// Add Room
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[6]")).click();

		// Adult Click
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[2]/i[3]")).click();

		// Child select
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[1]/i")).click();	

		// Clear age 
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[2]/span/input")).clear();

		// Enter Child age 
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[2]/span/input")).sendKeys("10");

		// Child select
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[3]/i")).click();

		// Clear age 
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[4]/span/input")).clear();

		// Enter Child age 
		driver.findElement(By.xpath("//*[@id=\"guests\"]/div[2]/div[3]/div[3]/div[4]/span/input")).sendKeys("12");
		
		Thread.sleep(4000);
		
		// Search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchHotelButton\"]"))).click();	
		System.out.println("Able to click on button");
		
		Thread.sleep(14000);
		
		// Nearest hotel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//view/view/view[2]/div[2]/view/div[1]/div[1]/div[3]/div/ul/li[3]/span[1]"))).click();
		
		String Near_By=driver.findElement(By.xpath("//*[@id=\"flights-page\"]/body/view/view/view[2]/div[2]/view/div[1]/div[1]/div[3]/div/ul/li[3]/span/span")).getText();
		
		System.out.println(Near_By);
		
		int b=Integer.parseInt(Near_By);
		
		//List<Integer> myList = null;
		//myList = new ArrayList<Integer>();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for (int i=1;i<=b;i++)
		{
			String fare = driver.findElement(By.xpath("//*[@id=\"nearby-hotels-js\"]/div["+i+"]/div/figcaption/div[2]/div[2]/div[2]/span[2]/div/span[2]")).getAttribute("data-base");
			                      
			int fare_v=Integer.parseInt(fare);
			myList.add(fare_v);
			System.out.println(fare_v);
		}
		
		Collections.sort(myList);
		System.out.println(myList);
		int element=myList.get(1);  
		System.out.println(element);
		
		// Selecting room
		for (int i=1;i<=b;i++)
		{
			String fare = driver.findElement(By.xpath("//*[@id=\"nearby-hotels-js\"]/div["+i+"]/div/figcaption/div[2]/div[2]/div[2]/span[2]/div/span[2]")).getAttribute("data-base");
			int fare_v=Integer.parseInt(fare);
			if(fare_v==element)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nearby-hotels-js\"]/div["+i+"]/div/figcaption/div[2]/div[2]/div[2]/span[2]/div/span[2]"))).click();
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"flights-page\"]/body/view/view/view[2]/div[2]/view/div[1]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"roomRate-js\"]/div/div[2]/div[2]/button")).click();
		
	}

}
