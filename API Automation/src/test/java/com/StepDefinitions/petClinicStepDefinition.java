package com.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class petClinicStepDefinition {


    private Response response;
    private RequestSpecification request;

    @Given("I set the base URI to {string}")
        public void i_set_the_base_uri_to(String baseUri) {
            RestAssured.baseURI = baseUri;
            request = given();
            System.out.println(request);

        }

    @When("I send a POST request to {string} with the following data")
    public void i_send_a_post_request_to_with_the_following_data(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        System.out.println("Sending POST request to: " + endpoint);
        System.out.println("Request Headers: Content-Type=application/json");
        System.out.println("Request Body: " + data);
        response = request
                .header("Content-Type", "application/json")
                .body(data)
                .post(endpoint);
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders().toString());
        System.out.println("Response Body: ");
    }


    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        // Log the request details
        System.out.println("Sending GET request to: " + endpoint);

        // Send the GET request
        response = request.get(endpoint);

        // Log the response details
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders().toString());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String key) {
        Assert.assertTrue(response.getBody().asString().contains(key));
    }

    @When("I send a PUT request to {string} with the following data")
    public void i_send_a_put_request_to_with_the_following_data(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        // Log the request details
        System.out.println("Sending PUT request to: " + endpoint);
        System.out.println("Request Headers: Content-Type=application/json");
        System.out.println("Request Body: " + data);

        // Create the request specification
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.header("Content-Type", "application/json");
        requestSpec.body(data);

        // Send the PUT request
        response = requestSpec.put(endpoint);

        // Log the response details
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders().toString());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        // Log the request details
        System.out.println("Sending DELETE request to: " + endpoint);

        // Send the DELETE request
        response = request.delete(endpoint);

        // Log the response details
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders().toString());
        System.out.println("Response Body: " + response.getBody().asString());
    }

}
