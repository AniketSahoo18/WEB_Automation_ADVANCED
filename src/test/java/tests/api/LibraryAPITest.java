package tests.api;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import coreUtil.PropertyUtil;
import coreUtil.ValidationUtil;
import io.restassured.specification.RequestSpecification;
import pojoResponse.AddBookResponse;
import requestSpecification.RequestSpec;
import resources.api.APIResources;
import resources.api.TestDataBuild;
import utils.DBConnection;
import utils.DataProvidersAPI;

@Listeners(listeners.TestListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryAPITest {

	RequestSpecification res;
	AddBookResponse response;

	RequestSpec reqSpec = new RequestSpec();

	@Test(dataProvider = "libraryAPIData", dataProviderClass = DataProvidersAPI.class, enabled = true)

	public void test_Message(Map<String, String> mapData) throws IOException {

		try {

			res = given().spec(reqSpec.libraryRequestSpecification()).body(TestDataBuild.addBookPayLoad(mapData));

			APIResources resourceAPI = APIResources.valueOf("AddBookAPI");

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);

			String mssg = response.getMsg();

			// Connection to DB and fetch data
			List<Object> data = DBConnection.getDBDataLibrary();

			ValidationUtil.stepInfo("Message Validation");

			ValidationUtil.validationCheck("soft", mssg, data.get(0).toString(),
					"Validation : Expected Value from API and Actual Value from DB");

		}

		catch (Exception e) {

			Assert.assertTrue(false,
					"User is not able to perform the below steps : <br>"
							+ "Validation : Expected Value from API and Actual Value from DB"

							+ "<br>Technical Error Message is as below : <br/>" + e.getMessage());
		}

	}

	@Test(dataProvider = "libraryAPIData", dataProviderClass = DataProvidersAPI.class, enabled = true)

	public void test_ID(Map<String, String> mapData) throws IOException {

		try {

			res = given().spec(reqSpec.libraryRequestSpecification()).body(TestDataBuild.addBookPayLoad(mapData));

			APIResources resourceAPI = APIResources.valueOf("AddBookAPI");

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);

			String id = response.getID();

			// Connection to DB and fetch data
			List<Object> data = DBConnection.getDBDataLibrary();

			ValidationUtil.stepInfo("ID Validation");

			ValidationUtil.validationCheck("soft", id, data.get(1).toString(),
					"Validation : Expected Value from API and Actual Value from DB");

		}

		catch (Exception e) {

			Assert.assertTrue(false,
					"User is not able to perform the below steps : <br>"
							+ "Validation : Expected Value from API and Actual Value from DB"

							+ "<br>Technical Error Message is as below : <br/>" + e.getMessage());
		}

	}
}
