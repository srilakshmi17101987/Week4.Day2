package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jqueryresizeable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		//WebElement we=driver.findElement(By.xpath("//div[@id='resizable']"));
		Thread.sleep(3000);
		WebElement we1=driver.findElement(By.xpath("(//div[@id='resizable']//div)[3]"));
		
		Thread.sleep(3000);
		//builder.moveToElement(we1).perform();
		//builder.clickAndHold(we1).perform();
		//driver.switchTo().frame(frame);
		Actions builder=new Actions(driver);
		//Thread.sleep(3000);
		//driver.switchTo().frame(frame);
		Thread.sleep(4000);
		builder.moveToElement(we1).perform();
		Thread.sleep(4000);
		builder.clickAndHold().dragAndDropBy(we1, -200, -200).perform();
		//builder.clickAndHold(we1).moveByOffset(200,100).release().perform();
		//builder.moveByOffset(217,190).release().perform();
		
		
	
	}

}
