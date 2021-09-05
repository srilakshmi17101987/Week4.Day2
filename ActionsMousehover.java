package LearnframeAlerts;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.lu.a;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsMousehover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		WebElement we = driver.findElement(By.xpath("//a[contains(text(),'TestLeaf Courses')]"));
		
		//System.out.println(we.getSize());
          
		Actions builder = new Actions(driver);
		builder.moveToElement(we).perform();
		
		driver.findElementByXPath("//a[contains(text(),'Selenium')]").click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("the list options are: ");
		builder.moveToElement(we).perform();
		
		List<WebElement> list1=driver.findElements(By.xpath("//a[@class='listener']"));
		
		for (WebElement webElement : list1) {
			String text=webElement.getText();
			System.out.println(text);
			
		}
		
		
		
	}

	}
