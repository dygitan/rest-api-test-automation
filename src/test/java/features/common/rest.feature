@ignore
Feature: Centralized handling of GET method

  Background: GET request
    Given url baseUrl + __arg.url
    Given header Accept = 'application/json'

  @get_request
  Scenario:
    * print 'Connecting to ', baseUrl + url
    When method get
    Then match responseStatus == 200
