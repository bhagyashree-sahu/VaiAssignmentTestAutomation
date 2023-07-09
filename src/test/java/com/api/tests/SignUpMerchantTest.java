package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.util.TestUtil;

import static org.hamcrest.Matchers.*;

import java.util.Map;

@Listeners(com.listeners.MyListeners.class)
public class SignUpMerchantTest {

	private static final String BASE_URL = TestUtil.readProp("BASE_URL");
	private static final String EMAIL = " bhagya@gmail.com";
	private static final String PASSWORD = "Iv1^TDCZSjo@!oZ";
	private static final String FIRST_NAME = "Ethelyn";
	private static final String LAST_NAME = "Reynolds";
	private static final String TYPE = "Individual";
	private static final String COMPANY_NAME = "VAI";
	private static final Map<String, String> formParams = TestUtil.createFakeParams();

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URL;
	}

	@Test
	public void signUpMerchantTest() {
		Response response = RestAssured.given()
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").formParams(formParams)
				.when().log().all().post("signUpMerchant");

		response.then().log().all().assertThat().statusCode(200).contentType(ContentType.JSON)
				.body("status", equalTo(200)).body("message", equalTo("We sent token to your Email"))
				.body("data.first_name", equalTo(formParams.get("first_name")))
				.body("data.last_name", equalTo(formParams.get("last_name")))
				.body("data.type", equalTo(formParams.get("type")))
				.body("data.company",equalTo(formParams.get("company_name")));


	}
}
