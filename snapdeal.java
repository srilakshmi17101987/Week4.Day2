package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
   
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		//to get mens fashion
		Actions builder=new Actions(driver);
		WebElement we=driver.findElement(By.xpath("//span[@class=\"catText\" and text()=\"Men's Fashion\"]"));
		builder.moveToElement(we).perform();
		
	driver.findElement(By.xpath("(//span[@class=\"linkTest\" and text()=\"Sports Shoes\"])[1]")).click();
		
		String count=driver.findElement(By.xpath("//span[@class=\"category-count\"]")).getText();
		 System.out.println(count.replaceAll("[^0-9a-zA-Z]"," "));
		 
		 driver.findElement(By.xpath("//div[text()=\"Training Shoes\"]")).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("//div[@class=\"sort-drop clearfix\"]")).click();
		 driver.findElement(By.xpath("//div[@class='sort-selected']//following::li[2]")).click();
		 Thread.sleep(1000);
		 List<WebElement> prlist=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		 
		List<Integer> val= new ArrayList<Integer>();
		WebElement end=driver.findElement(By.xpath("//span[@class='btn-yes js-yesFeedback']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",end);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(3000);
		 for(int i=0;i<prlist.size();i++)
		 {
			 
			 String pr=prlist.get(i).getText().replaceAll("[^0-9]", "");
			 System.out.println(pr);
			  val.add(Integer.parseInt(pr));
			 //System.out.print(val);
			
		 }
		 //System.out.println(val);
		 List<Integer> sortlist=new ArrayList<Integer>(val);
		 Collections.sort(sortlist);
		 boolean b = false;
		 for (int i=0;i<val.size();i++)
		 {
		   if(val.get(i)==sortlist.get(i))
		     {
			System.out.println("The list is sorted");
		     }
		     else
		      {
			 System.out.println("The displayed list is not sorted");
			 
		       }
		 } 
		/* if(b==true)
		 System.out.println("the list is sorted");
		 else
			 System.out.println("The list is not sorted");*/
		 js.executeScript("window.scrollBy(0,400)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[contains(text(),\"View More\")])[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()=' Columbus ']")).click();
			driver.findElement(By.xpath("//div[text()='APPLY']")).click();
			Thread.sleep(3000);
			 js.executeScript("window.scrollBy(0,750)");
			WebElement columbus=driver.findElement(By.xpath("//img[@title='Columbus TB-4 White Training Shoes']"));
			Thread.sleep(3000);
			builder.moveToElement(columbus).perform();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),'Quick View') and @pogid='673658543440']")).click();
			
		String price=driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		price.replaceAll("[^0-9]", "");
		System.out.println("The product price is: "+price);
		String disc=driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The discount proce is: "+disc);
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/shoe.png");
		FileUtils.copyFile(src1, dst);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();
		
		
		
	}

}
