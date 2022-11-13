package test;

import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.StepsRest;

public class TestRestSuit {
	
	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void setUp(){
		steps.requestURL("https://petstore.swagger.io/");
	}

	@After
	public void tearDown(){
		steps.verifyStatusSuccess(404);
	}

	@Test
	public void test() {
		steps.servicioPetstore();
	}

}
