package test;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.StepsRest;

public class RestTestDelete {
	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void setUp(){
		steps.requestURL("https://petstore.swagger.io/");
		steps.withEndPoint("v2/user/Arctyrael");
		steps.withMessageInJson();
		steps.stepsRequestHTTPWithoutHeaders();
	}

	@After
	public void tearDown(){
		steps.verifyResponseDataSucces("");
	}

	@Test
	public void test(){
		steps.deleteStepsRequest();
	}

}
