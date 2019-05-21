@ignore
Feature: Centralized handling of GET method

  Background: GET request
    * url baseUrl + requestUrl
    * header Accept = 'application/json'

  @get_request
  Scenario:
    * print 'Connecting to ', requestUrl
    When method get
    Then match responseStatus == 200
