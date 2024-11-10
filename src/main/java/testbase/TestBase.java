package testbase;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import coreUtil.PropertyUtil;
import utils.TestUtil;

public class TestBase {

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)

	protected void setUp() {

		try {

			if (Objects.isNull(DriverManager.getDriver())) {

				driver = BrowserFactory.createBrowserInstance(PropertyUtil.getValue("browser"),
						Integer.parseInt(PropertyUtil.getValue("driverStartupWait")));

			}

			TestUtil.getUrl(PropertyUtil.getValue("url"), driver);
			WaitFactory.performImplicitWait();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}
	}

	@AfterMethod(alwaysRun = true)

	protected void tearDown() {

		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
