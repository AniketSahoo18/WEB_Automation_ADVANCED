package webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import testbase.DriverManager;
import utils.TestUtil;

public class CartPage extends TestUtil {

	private final By txtCartProducts = By.cssSelector(".cartSection h3");
	private final By btnCheckout = By.cssSelector(".totalRow button");
	private final By paymentMethod = By.xpath("//div[contains(text(), 'Payment Method')]");

	public CheckoutPage placeOrder(String productName, boolean check, String steps) {

		try {

			// Checking product is added in Cart

			Boolean match = DriverManager.getDriver().findElements(txtCartProducts).stream()
					.anyMatch(cartProduct -> cartProduct.getText().equals(productName));

			Assert.assertTrue(match);

			// Checkout

			click(btnCheckout, WaitStrategy.CLICKABLE);

			if (check) {

				ValidationUtil.validationCheck("hard", "boolean", getWebElement(paymentMethod), "", "", steps, true);

			} else {

				ValidationUtil.stepInfo(steps);

			}

		}

		catch (Exception e) {

			ValidationUtil.validation(false, "Failed Step : " + steps, "</br>Fail Cause : " + e.getMessage());

		}

		return new CheckoutPage();
	}
}
