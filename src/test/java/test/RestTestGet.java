package test;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.StepsRest;

public class RestTestGet {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://petstore.swagger.io/");
		steps.withEndPoint("v2/user/Arctyrael");
		steps.withMessageInJson();
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.getStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyResponseDataSucces("");
	}
}
