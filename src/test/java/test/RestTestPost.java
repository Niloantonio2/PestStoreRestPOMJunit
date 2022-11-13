package test;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.StepsRest;

public class RestTestPost {
	
	@Steps
	StepsRest steps = new StepsRest();

	@Before
	public void before() {
		String json = "{\r\n" + 
				"  \"id\": 2515,\r\n" + 
				"  \"username\": \"Arctyrael\",\r\n" + 
				"  \"firstName\": \"Dayana\",\r\n" +
				"  \"lastName\": \"Chaverra\",\r\n" +
				"  \"email\": \"prueba@Qa.com\",\r\n" +
				"  \"password\": \"123456789\",\r\n" + 
				"  \"phone\": \"3113198129\",\r\n" + 
				"  \"userStatus\": 1\r\n" + 
				"}";
		steps.requestURL("https://petstore.swagger.io/");
		steps.withEndPoint("v2/user");
		steps.withMessageInJson();
		steps.withBodyRequest(json);
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.postStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyResponseDataSucces("");
	}
}
