package utils;

public final class TestDataMapper {

	private TestDataMapper() {

	}

	private static final String TESTDATA_BASE_PATH = "./src/test/resources/testdatas/";

	public static String getAPIData() {

		return TESTDATA_BASE_PATH + "InputData.xlsx";
	}

	public static String getEcommerceData() {

		return TESTDATA_BASE_PATH + "purchaseOrder.xlsx";
	}

}
