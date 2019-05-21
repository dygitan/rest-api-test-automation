Feature: check returned todos by the API

  Background:
    * url 'https://jsonplaceholder.typicode.com'
    * header Accept = 'application/json'

  Scenario: List todos
    Given path 'todos'
    When method get
    Then status 200