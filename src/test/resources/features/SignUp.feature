Feature: Sign Up Merchant API

  Scenario: Sign up a new merchant as an individual
    Given the base URL is "https://sandbox.api.lyomerchant.com/v1/signUpMerchant"
    When I send a POST request with the following form parameters:
      | email       | user_hpvir8d41wwdl4cs146jkg111@myDomain.com |
      | password    | Iv1^TDCZSjo@!oZ                             |
      | first_name  | Ethelyn                                     |
      | last_name   | Reynolds                                    |
      | type        | Individual                                  |
      | companyname | VAI                                         |
    Then the response status code should be 200
    And the response content type should be JSON
    And the response body should contain:
      | status  | success                     |
      | message | We sent token to your Email |
