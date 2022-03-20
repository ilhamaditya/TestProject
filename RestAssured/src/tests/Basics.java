package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.CommonMethods;
import files.payload;

public class Basics {

	public static void main(String[] args) {
		
		// json
		payload payload = new payload();
		
		// init parameter
		String order_status = "IN PROGRESS";
		String last_updated_timestamp = "16423212104390000000";
		String uri = "/order";
		
		// base endpoint
		RestAssured.baseURI = "https://6237655af5f6e28a154c1af1.mockapi.io";
		
		// gherkin
		String response = given().header("Content-Type", "application/json").
		// for test fill the value of parameter order_status and last_updated_timestamp
		body(payload.processOrder(order_status,last_updated_timestamp))
		.when()
		.post(uri)
		// assertion
		.then().assertThat().statusCode(201)
		.extract().response().asString();
		
		CommonMethods x = new CommonMethods();
		JsonPath js = x.rawToJson(response);
		String outcomeOrderStatus = js.get("order_status");
		String outcomeLastUpdatedTimestamp = js.get("last_updated_timestamp");
		
		String newLine = System.getProperty("line.separator");
		System.out.println("API Response Body:" +response + newLine);
		System.out.println(outcomeOrderStatus + newLine);
		System.out.println(outcomeLastUpdatedTimestamp + newLine);
	
	}

}
