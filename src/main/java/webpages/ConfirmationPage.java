package webpages;

import org.openqa.selenium.By;
import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import utils.TestUtil;

public class ConfirmationPage extends TestUtil {

	private final By txtConfirmationMssg = By.cssSelector(".hero-primary");

	String confirmationMessage;

	public void getConfirmationMssg(boolean check, String steps) {

		try {

			confirmationMessage = getText(txtConfirmationMssg, WaitStrategy.VISIBLE);

			if (check) {

				ValidationUtil.validationCheck("soft", "texttotext", getWebElement(txtConfirmationMssg),
						"THANKYOU FOR THE ORDER.", confirmationMessage, steps, true);

			} else {

				ValidationUtil.stepInfo(steps);

			}

		}

		catch (Exception e) {

			ValidationUtil.validation(false, "Failed Step : " + steps, "</br>Fail Cause : " + e.getMessage());

		}

	}
}
