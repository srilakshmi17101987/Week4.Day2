package LearnframeAlerts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		WebElement we=driver.findElement(By.xpath("//*[@id='sortable']//li[4]"));
		WebElement we1=driver.findElement(By.xpath("//*[@id='sortable']//li[5]"));
		
		Thread.sleep(2000);
		//builder.clickAndHold(we).moveToElement(we1).release().perform();
		Point location=we1.getLocation();
		int x= location.getX();
		int y=location.getY();
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(we, x, y).perform();
	}

}
