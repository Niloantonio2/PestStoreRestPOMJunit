package test;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.StepsRest;

public class RestTestPut {
	
	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void setUp() {
		String json = "{\r\n" + 
				"  \"id\": 2515,\r\n" + 
				"  \"username\": \"Arctyrael\",\r\n" + 
				"  \"firstName\": \"Probandooo\",\r\n" +
				"  \"lastName\": \"Ramos\",\r\n" + 
				"  \"email\": \"Dayana@qa.co\",\r\n" +
				"  \"password\": \"123456789\",\r\n" + 
				"  \"phone\": \"3113198129\",\r\n" + 
				"  \"userStatus\": 1\r\n" + 
				"}";
		steps.requestURL("https://petstore.swagger.io/");
		steps.withEndPoint("v2/user/Arctyrael");
		steps.withMessageInJson();
		steps.withBodyRequest(json);
		steps.stepsRequestHTTPWithoutHeaders();
	}

	@After
	public void tearDown() {
		steps.verifyResponseDataSucces("");
	}

	@Test
	public void test() {
		steps.putStepsRequest();
	}

}
