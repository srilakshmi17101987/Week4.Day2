package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("https://www.nykaa.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.getTitle();
WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
Actions builder=new Actions(driver);
builder.moveToElement(brand).perform();
builder.moveToElement(popular).perform();
driver.findElement(By.xpath("//ul[@class='l-vertical-list']//following::li[4]")).click();
Set<String> windowhandleset = driver.getWindowHandles();
List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
driver.switchTo().window(windowhandlelist.get(1));
String title=driver.getTitle();

if(title.contains("L'Oreal Paris"))
{
	System.out.println("The page is on L'Oreal Paris");
}
else
{
	System.out.println("Not on L'Oreal Paris");
}

JavascriptExecutor js=(JavascriptExecutor) driver;

Thread.sleep(4000);
js.executeScript("window.scrollBy(0,800)");
Thread.sleep(4000);
driver.switchTo().window(windowhandlelist.get(1));
//driver.findElement(By.xpath("//i[@class='fa fa-angle-down']//following::span[4]")).click();

driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
driver.findElement(By.xpath("(//div[@class='control__indicator radio'])[4]")).click();
Thread.sleep(2000);
js.executeScript("window.scrollBy(0,800)");
//driver.findElement(By.xpath("//div[text()='Category']//following::span[text()='Shampoo']")).click();
driver.findElement(By.xpath("//div[text()='Category']")).click();
driver.findElement(By.xpath("//span[text()='Hair']")).click();
driver.findElement(By.xpath("//span[text()='Hair']//following::span[1]")).click();
driver.findElement(By.xpath("(//label[@class=\"control control--checkbox\"])[1]")).click();
String str=driver.findElement(By.xpath("//li[text()='Shampoo']")).getText();
if (str.contains("Shampoo"))
{
	System.out.println("Shampoo is selected");
}
else
{
	System.out.println("Something else is selected");

}

driver.findElement(By.xpath("(//h2[@title=\"L'Oreal Paris Colour Protect Shampoo\"])[1]")).click();




System.out.println(driver.getTitle());
Thread.sleep(3000);
Set<String> windowhandleset1 = driver.getWindowHandles();
//windowhandlelist.addAll(windowhandleset1);
List<String> windowhandlelist1=new ArrayList<String>(windowhandleset1);
driver.switchTo().window(windowhandlelist1.get(2));
Thread.sleep(2000);
System.out.println(driver.getTitle());
//driver.switchTo().window(windowhandlelist.lastIndexOf(windowhandleset1));
Thread.sleep(2000);
String size=driver.findElement(By.xpath("//span[@class='shade-txt']")).getText();
System.out.println(size);
String original=driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
String org=original.replaceAll("[^0-9]", "");
List<Integer> val=new ArrayList<Integer>();
val.add(Integer.parseInt(org));
Thread.sleep(2000);
System.out.println("The product price is: "+val.get(0));

Thread.sleep(3000);
js.executeScript("window.scrollBy(0,400)");
Thread.sleep(2000);
driver.findElement(By.xpath("(//button[text()='ADD TO BAG'])[1]")).click();
Thread.sleep(3000);

driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
Thread.sleep(3000);
String total=driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
Thread.sleep(2000);
String tot=total.replaceAll("[^0-9]", "");
//List<Integer> val=new ArrayList<Integer>();
val.add(Integer.parseInt(tot));

System.out.println("The  total is: "+val.get(1));
js.executeScript("window.scrollBy(0,300)");
driver.findElement(By.xpath("//span[text()='Proceed']")).click();

//add 
js.executeScript("window.scrollBy(0,300)");
driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
js.executeScript("window.scrollBy(0,300)");
String finalamt=driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
String finamt = finalamt.replaceAll("[^0-9]", "");
val.add(Integer.parseInt(finamt));

System.out.println("The grand total is: "+val.get(2));

if(tot.equals(finamt))
{
	System.out.println("The grand total and total are same");	
}
	
else
{
	System.out.println("The grand total and total are different");
}

driver.close();
	}

}
