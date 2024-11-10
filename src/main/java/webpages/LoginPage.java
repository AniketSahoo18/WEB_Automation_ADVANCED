package webpages;

import org.openqa.selenium.By;
import coreUtil.DecodeUtil;
import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import utils.TestUtil;

public class LoginPage extends TestUtil {

	private final By txtBoxEmail = By.id("userEmail");
	private final By txtBoxPassword = By.id("userPassword");
	private final By btnLogin = By.id("login");
	private final By home = By.xpath("//i[@class='fa fa-home']");

	public HomePage loginApplication(String email, String password, boolean check, String steps) {

		try {

			sendKeys(txtBoxEmail, email, WaitStrategy.PRESENCE);
			sendKeys(txtBoxPassword, DecodeUtil.getDecodedString(password), WaitStrategy.PRESENCE);
			click(btnLogin, WaitStrategy.CLICKABLE);

			if (check) {

				ValidationUtil.validationCheck("hard", "boolean", getWebElement(home), "", "", steps, true);

			} else {

				ValidationUtil.stepInfo(steps);

			}

		}

		catch (Exception e) {

			ValidationUtil.validation(false, "Failed Step : " + steps, "</br>Fail Cause : " + e.getMessage());

		}
		return new HomePage();
	}

}
