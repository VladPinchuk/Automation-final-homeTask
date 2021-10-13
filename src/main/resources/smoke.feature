Feature: Smoke
  As a user
  I want to write 10 tests checking the main site functionality
  So that I can learn BDD realization and complete my final home task
  # Deadline: 22.09.2021
  # Author: Vladyslav Pinchuk

  Scenario: Check that User can switch to MEN version of Asos web-shop
    Given User opens 'https://www.asos.com/women' page
    When User clicks 'MEN' button
    Then User checks that current url contains 'men' version


  Scenario: Check that Accessories tab includes some necessary points
    Given User opens 'https://www.asos.com/women' page
    When User clicks Accessories button
    Then User checks that appears necessary point 'SHOP BY BRAND'


  Scenario Outline: Check that Sale tab icludes some necessary points
    Given User opens '<homePage>' page
    When User clicks Sale button
    Then User checks that appears necessary point with '<pointName>'

    Examples:
      | homePage                   | pointName     |
      | https://www.asos.com/women | Best of sale  |
      | https://www.asos.com/women | SALE View all |
      | https://www.asos.com/women | SALE Shoes    |
      | https://www.asos.com/women | SALE Gifts    |


  Scenario: Check that saved product is present in the Saved List
    Given User opens 'https://www.asos.com/women' page
    And User checks search field visibility
    And User makes search at 'Home page' by keyword 'Originals jacquard backpack in black'
    And User chooses adidas Originals jacquard backpack in black product
    When User clicks 'Save' button
    And User opens Saved lists page
    Then User checks that 'Originals jacquard backpack in black' is added to saved items


  Scenario: Check that country of delivery is changed
    Given User opens 'https://www.asos.com/women' page
    When User opens Delivery and return page
    And User clicks 'Change' button
    And User clicks 'SearchCountry' field
    And User makes search by keyword 'Spain'
    And User selects Spain country for delivery
    Then User checks that current url contains 'es' country


  Scenario Outline: Check to login with wrong credentials
    Given User opens 'https://www.asos.com/women' page
    When User clicks 'AccountButton'
    And User selects 'HomePage Sign In' button
    And User enters wrong '<login>' or wrong '<password>'
    And User clicks 'Sign In' button
    Then User checks that 'Failure Massage' appears
    Examples:
      | login                 | password   |
      | 12345@gmail.com       | 0123456789 |
      | vladpinchuk@gmail.com | 1111111    |


  Scenario: Check that search result contains search word
    Given User opens 'https://www.asos.com/women' page
    And User checks search field visibility
    When User makes search at 'Home page' by keyword 'adidas'
    Then User checks that search result includes products containing 'adidas'


  Scenario: Check that search result does not contain
    Given User opens 'https://www.asos.com/women' page
    And User checks search field visibility
    When User makes search at 'Home page' by keyword 'adidas'
    Then User checks that search result doesnt includes products containing 'nike'


  Scenario Outline: Check to login with correct credentials
    Given User opens 'https://www.asos.com/women' page
    When User clicks 'AccountButton'
    And User selects 'HomePage Sign In' button
    And User enters correct '<login>' and correct '<password>'
    And User clicks 'Sign In' button
    #And If needed User clicks 'I am not a robot' button
    And User clicks 'AccountButton'
    Then User checks that 'Sign Out' button is displayed
    Examples:
      | login                 | password   |
      | vladpinchuk@gmail.com | 0123456789 |