Feature: Login

  Scenario: Login with valid credentials
    Given User navigate to OrangeHRM page
    And User login with Admin credentials
    Then User is logged in and see Dashboard page

