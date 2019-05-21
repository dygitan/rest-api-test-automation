Feature: Users API

  Background:
    Given def requestUrl = '/api/users'

  Scenario: Get Users
    When def response = call read('classpath:features/common/rest.feature@get_request')
    When def data = response.response
    Then match data[0].lastName == 'Doe'