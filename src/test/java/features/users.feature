Feature: Users API

  Background:
    Given def requestUrl = '/api/users'
    Given def userId = '464d3975-3a59-4447-94d6-fd273600ec50'

  Scenario: Get Users
    * json param = '{"url" : "' + requestUrl + '"}'
    When def response = call read('classpath:features/common/rest.feature@get_request') param
    When def data = response.response
    Then match data[0].lastName == 'Doe'

  Scenario Outline: Get User <userId>
    * json param = '{"url" : "' + requestUrl + '/' + '<userId>' + '"}'
    When def response = call read('classpath:features/common/rest.feature@get_request') param
    When def data = response.response
    * def expected = read('classpath:json/user.json')
    * replace expected
      | token        | value         |
      | ${userId}    | '<userId>'    |
      | ${lastName}  | '<lastName>'  |
      | ${firstName} | '<firstName>' |
    * json expectedJson = expected
    Then match data == expectedJson

    Examples:
      | userId                               | lastName | firstName |
      | 464d3975-3a59-4447-94d6-fd273600ec50 | Doe      | John      |
      | d52cafcd-3f09-4304-a047-b06526ee01a0 | Doe      | Jane      |