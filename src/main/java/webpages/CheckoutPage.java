package webpages;

import org.openqa.selenium.By;

import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import utils.TestUtil;

public class CheckoutPage extends TestUtil {

	private final By txtCountryField = By.cssSelector("[placeholder='Select Country']");
	private final By searchCountryField = By.cssSelector(".ta-item:nth-of-type(2)");
	private final By btnPlaceOrder = By.cssSelector(".action__submit");

	public ConfirmationPage submitOrder(boolean check, String steps) {

		try {

			sendKeys(txtCountryField, "India", WaitStrategy.PRESENCE);
			click(searchCountryField, WaitStrategy.CLICKABLE);
			click(btnPlaceOrder, WaitStrategy.CLICKABLE);

			ValidationUtil.stepInfo(steps);

		}

		catch (Exception e) {

			ValidationUtil.validation(false, "Failed Step : " + steps, "</br>Fail Cause : " + e.getMessage());

		}

		return new ConfirmationPage();
	}

}
