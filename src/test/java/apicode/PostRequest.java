package apicode;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@SuppressWarnings("unchecked")
	@Test
	void PostData() {
		
//	RestAssured.baseURI="localhost";
	RestAssured.port=9200;
	//Request Object
	RequestSpecification httpRequest = RestAssured.given();
	//Response Object
	
	JSONObject requestparam = new JSONObject();
	requestparam.put("name", "John Doe");

	httpRequest.header("Content-Type", "application/json");
	
	httpRequest.body(requestparam.toJSONString());
	Response response = httpRequest.request(Method.POST,"/customer/_doc/2");
	//Print response in console
	String responseBody = response.getBody().asString();
	System.out.println("The response body is " + responseBody);
	int statuscode = response.getStatusCode();
	System.out.println("The status code value is " +statuscode);
	Assert.assertEquals(statuscode, 201);
	String statusLine = response.getStatusLine();
	System.out.println("The status Line is " + statusLine);

}
}