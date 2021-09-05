package week4.day2;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		;

		WebElement webmen = driver.findElementByXPath("//a[text()='Men']");
		Actions builder = new Actions(driver);
		builder.moveToElement(webmen).perform();
		driver.findElementByXPath("(//a[text()='Jackets'])[1]").click();
		String jackcount = driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println(jackcount);

		String val = jackcount.replaceAll("[^0-9]", "");
		System.out.println(jackcount.replaceAll("[^0-9]", ""));
		Integer count = Integer.parseInt(val);
		System.out.println(count);
		// convert it int using regex

		String jaclket = driver.findElement(By.xpath("//span[@class='categories-num'][1]")).getText();
		System.out.println(jaclket);
		String val1 = jaclket.replaceAll("[^0-9]", "");
		// System.out.println(jaclket.replaceAll("[^0-9]",""));
		Integer count1 = Integer.parseInt(val1);
		Thread.sleep(2000);
		String item2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println(item2);
		String val2 = item2.replaceAll("[^0-9]", "");
		System.out.println(item2.replaceAll("[^0-9]", ""));
		Integer count2 = Integer.parseInt(val2);
		int sum = count1 + count2;
		if (sum == count) {
			System.out.println("The categort jacket count matches");
		} else {
			System.out.println("The categort jacket count does not matches");
		}
		Thread.sleep(2000);
		driver.findElementByXPath("//label[text()='Jackets']").click();
		driver.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("//div[@class='brand-more']").click();
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Duke");
		driver.findElementByXPath("//label[contains(text(),'Duke')]").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(2000);
		List<WebElement> brand = driver.findElements(By.tagName("h3"));
		for (int i = 0; i < brand.size(); i++) {
			String str = brand.get(i).getText();
			if (str.equals("Duke")) {
				System.out.println("The brand is Duke");
			} else {
				System.out.println("The brand is not duke");
			}

		}
		Thread.sleep(2000);
		driver.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//label[text()='50% and above']")).click();
		String str1 = driver.findElement(By.xpath("//span[@class='product-discountedPrice'][1]")).getText();
		System.out.println("The first displayed item is" + str1);
		driver.findElementByXPath("//span[@class='product-discountedPrice'][1]").click();
		Set<String> windowhandleset = driver.getWindowHandles();
		List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
		driver.switchTo().window(windowhandlelist.get(1));
		System.out.println(driver.getTitle());
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/myntra.png");
		FileUtils.copyFile(src1, dst);
		driver.findElementByXPath("//span[text()='WISHLIST']").click();
		driver.switchTo().window(windowhandlelist.get(0));
		driver.close();
	}

}
