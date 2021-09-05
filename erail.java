package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class erail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		WebElement frm = driver.findElement(By.id("txtStationFrom"));
		frm.clear();
		frm.sendKeys("ms", Keys.ENTER);
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("mdu", Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement webtable = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
		List<WebElement> rowlist = webtable.findElements(By.tagName("tr"));
		System.out.println("The no of rows are: " + rowlist.size());
		List<WebElement> wecol = driver.findElements(By.tagName("td"));
		System.out.println("The column size: " + wecol.size());
		System.out.println("***************Train names List********************");
		for (int i = 0; i < rowlist.size(); i++) {
			WebElement we = rowlist.get(i);
			List<WebElement> allcolumns = we.findElements(By.tagName("td"));
			String text = allcolumns.get(1).getText();
			System.out.println(text);
		}

	}

}
