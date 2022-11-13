package steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class StepsRest {

	private String endPointOrWSDL = "";
	private String contenType = "";
    private String accept = "";
    private String requestConsume = "{}";
    public RequestSpecification requestSpec;
    public Response res = null;
	
    @Step
    public void stepsRequestHTTPWithoutHeaders (){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBasePath(endPointOrWSDL);
        builder.setContentType(contenType);
        builder.setAccept(accept);
        builder.setBody(requestConsume);
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        requestSpec.log().all();
    }
    
	@Step
	public void requestURL(String url) {
		RestAssured.baseURI = url;
	}
	
	@Step
    public void withEndPoint(String endPoint)
    {
        this.endPointOrWSDL = endPoint;
    }
	
	@Step
    public void withMessageInJson() {
        this.contenType = "application/json";
        this.accept = "*/*";
    }
	
	@Step
    public void withHeaderAccept() {
        this.accept = "*/*";
    }
	
	@Step
    public void withHeaderJson() {
        this.contenType = "application/json";        
    }
	
	@Step
    public void withBodyRequest(String requestConsume)
    {
        this.requestConsume = requestConsume;
    }
	
	@Step
    public void postStepsRequest()  {
        res = requestSpec.when().post();
    }
	
	@Step
    public void limpiarJSON()  {
		this.requestConsume = "";
    }

    @Step
    public void getStepsRequest()  {
        res = requestSpec.when().get();
    }

    @Step
    public void deleteStepsRequest()
    {
        res = requestSpec.when().delete();
    }

    @Step
    public void putStepsRequest()
    {
        res = requestSpec.when().put();
    }
    
    @Step
    public void verifyStatusSuccess(int status) {
        Assert.assertEquals("The Status Responses Is Not Equal!",res.getStatusCode(),status);
    }

    @Step
    public void verifyResponseSuccess(String response) {
        Assert.assertEquals("The Responses Is Not Equal!",res.getBody().prettyPrint(),response);
    }

    @Step
    public void verifyResponseDataSucces(String dataResponse)
    {
        System.out.println("Este es el response");
        System.out.println(res.getBody().prettyPrint());
        //Assert.assertEquals("The Responses Is Not Equal!",res.getBody().prettyPrint().contains(dataResponse),true);
    }
    
    @Step
    public void servicioPetstore() {
    	
    	/*
    	 * Post
    	 * */
    	
    	String json = "{\r\n" + 
				"  \"id\": 2515,\r\n" + 
				"  \"username\": \"Arctyrael\",\r\n" + 
				"  \"firstName\": \"Dayana\",\r\n" +
				"  \"lastName\": \"Chaverra\",\r\n" +
				"  \"email\": \"damacha98@gmail.com\",\r\n" +
				"  \"password\": \"123456789\",\r\n" + 
				"  \"phone\": \"3146642635\",\r\n" +
				"  \"userStatus\": 1\r\n" + 
				"}";
    	withEndPoint("v2/user");
		withMessageInJson();
		withBodyRequest(json);
		stepsRequestHTTPWithoutHeaders();
		postStepsRequest();
		limpiarJSON();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
		
		/*
    	 * Put
    	 * */
		String jsonPut = "{\r\n" + 
				"  \"id\": 2515,\r\n" + 
				"  \"username\": \"Arctyrael\",\r\n" + 
				"  \"firstName\": \"Day\",\r\n" +
				"  \"lastName\": \"Chaverra\",\r\n" +
				"  \"email\": \"damacha98@gmail.com\",\r\n" +
				"  \"password\": \"123456789\",\r\n" + 
				"  \"phone\": \"312523666\",\r\n" +
				"  \"userStatus\": 1\r\n" + 
				"}";
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		withBodyRequest(jsonPut);
		stepsRequestHTTPWithoutHeaders();
		putStepsRequest();
		limpiarJSON();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
		
		/*
    	 * Delete
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		deleteStepsRequest();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
		
		/*
    	 * Get
    	 * */
		withEndPoint("v2/user/Arctyrael");
		withMessageInJson();
		stepsRequestHTTPWithoutHeaders();
		getStepsRequest();
    }
}
