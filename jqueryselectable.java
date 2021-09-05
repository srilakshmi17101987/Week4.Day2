package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jqueryselectable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		// WebElement src=driver.findElement(By.xpath("//li[text()='Item 1']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", " ");
		// driver.executeScript("Window.scrollBy(0,500)");
		// builder.click().perform();
		// driver.switchTo().frame(frame);
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		List<WebElement> items = driver.findElements(By.xpath("//ol[@id='selectable']//following::li"));
		for (int i = 0; i < items.size(); i++) {

			builder.moveToElement(items.get(i)).click().perform();
			// builder.click().perform();
		}

	}

}
