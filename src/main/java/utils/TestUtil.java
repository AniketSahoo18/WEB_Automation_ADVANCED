package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import enums.WaitStrategy;
import testbase.DriverManager;
import testbase.WaitFactory;

public class TestUtil {

	public static void getUrl(String url, WebDriver driver) {

		try {

			driver.get(url);

		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

//	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
//
//		TakesScreenshot ss = (TakesScreenshot) driver;
//		File source = ss.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
//	}

	protected WebElement getWebElement(By by) {

		WebElement element = DriverManager.getDriver().findElement(by);

		return element;
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {

		WebElement element = WaitFactory.performExplicitWait(waitStrategy, by);

		element.sendKeys(value);

	}

	protected void click(By by, WaitStrategy waitStrategy) {

		WebElement element = WaitFactory.performExplicitWait(waitStrategy, by);

		element.click();

	}

	public static void click(WebElement ele, By by) {

		WebElement element = ele.findElement(by);

		element.click();
	}

	protected String getText(By by, WaitStrategy waitStrategy) {

		WebElement element = WaitFactory.performExplicitWait(waitStrategy, by);

		return element.getText();

	}

	public static String getText(WebElement ele, By by) {

		WebElement element = ele.findElement(by);

		return element.getText();
	}
	
	public static String getBase64Image() {

		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
