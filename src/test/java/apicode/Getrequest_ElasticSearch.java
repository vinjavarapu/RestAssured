package apicode;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getrequest_ElasticSearch {
	
	@Test
	void GetData() {
		
		//Specify Base URI
		RestAssured.baseURI="http://localhost:9200";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response Object
		Response response = httpRequest.request(Method.GET,"/");
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("The response body is " + responseBody);
		int statuscode = response.getStatusCode();
		System.out.println("The status code value is " +statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusLine = response.getStatusLine();
		System.out.println("The status Line is " + statusLine);
				
	}

}
