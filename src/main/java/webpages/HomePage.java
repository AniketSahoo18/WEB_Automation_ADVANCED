package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import testbase.DriverManager;
import testbase.WaitFactory;
import utils.TestUtil;

public class HomePage extends TestUtil {

	private final By txtProducts = By.cssSelector(".mb-3");
	private final By txtProduct = By.cssSelector("b");
	private final By linkCart = By.cssSelector("[routerlink*='cart']");
	private final By linkProduct = By.cssSelector(".card-body button:last-of-type");
	private final By linkPopUp = By.cssSelector("#toast-container");
	private final By linkAnimation = By.cssSelector(".ng-animating");
	private final By myCart = By.xpath("//h1[contains(text(), 'My Cart')]");

	public CartPage addProductToCart(String productName, boolean check, String steps) {

		try {

			WebElement prod = DriverManager.getDriver().findElements(txtProducts).stream()
					.filter(product -> getText(product, txtProduct).equals(productName)).findFirst().orElse(null);

			click(prod, linkProduct);

			WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, linkPopUp);
			WaitFactory.performExplicitWait(WaitStrategy.INVISIBLE, linkAnimation);

			// Click Cart

			click(linkCart, WaitStrategy.CLICKABLE);

			if (check) {

				ValidationUtil.validationCheck("hard", "boolean", getWebElement(myCart), "", "", steps, true);

			} else {

				ValidationUtil.stepInfo(steps);

			}

		}

		catch (Exception e) {

			ValidationUtil.validation(false, "Failed Step : " + steps, "</br>Fail Cause : " + e.getMessage());

		}

		return new CartPage();
	}
}
