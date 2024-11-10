package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import reports.ExcelReportUtil;
import utils.TestDataMapper;

public class AnnotationTransformer implements IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		List<Map<String, String>> list = ExcelReportUtil.getTestDataMap(TestDataMapper.getEcommerceData(),
				"Electronics");

		for (int i = 0; i < list.size(); i++) {

			if (annotation.getDataProvider().equalsIgnoreCase("testData_Electronics")
					&& list.get(i).get("TestID").equalsIgnoreCase("TC_001")) {

				annotation.setEnabled(false);

				break;
			}
		}

	}

}
