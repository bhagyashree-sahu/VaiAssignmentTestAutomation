package com.api.sd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class SignUpMerchantStepDefinitions {

	private Response response;

	@Given("the base URL is {string}")
	public void setBaseURL(String baseUrl) {
		RestAssured.baseURI = baseUrl;
	}

	@When("I send a POST request with the following form parameters:")
	public void sendPostRequestWithFormParams(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> formParams = dataTable.asMap(String.class, String.class);
		response = RestAssured.given().header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.formParams(formParams).when().log().all().post();
	}

	@Then("the response status code should be {int}")
	public void verifyResponseStatusCode(int expectedStatusCode) {
		response.then().log().all().assertThat().statusCode(expectedStatusCode);
	}

	@Then("the response content type should be JSON")
	public void verifyResponseContentType() {
		response.then().assertThat().contentType(ContentType.JSON);
	}

	@Then("the response body should contain:")
	public void verifyResponseBody(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> expectedResponse = dataTable.asMap(String.class, String.class);
		for (Map.Entry<String, String> entry : expectedResponse.entrySet()) {
			response.then().assertThat().body(entry.getKey(), equalTo(entry.getValue()));
		}
	}
}
