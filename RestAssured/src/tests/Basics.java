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
		
		payload payload = new payload();
		String order_status = "";
		String last_updated_timestamp = "";
		String uri = "/";
		
		RestAssured.baseURI = "";
		String response = given().header("Content-Type", "application/json").
		body(payload.processOrder(order_status,last_updated_timestamp))
		.when()
		.post(uri)
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		CommonMethods x = new CommonMethods();
		JsonPath js = x.rawToJson(response);
		String outcomeOrderStatus = js.get("order_status");
		System.out.println(outcomeOrderStatus);
	
	}

}
