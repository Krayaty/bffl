Feature: Use Case to shorten a link

  Background:
    Given The user is logged in
    And The user is part of a group
    And The app is opened

  Scenario: Error - Shorten an existing link
    Given The entered URL is already in the database
    When The user clicks the button "Shorten URL"
    Then Text "Your URL has been shortened already" is displayed
    And Input fields are cleared

  Scenario: Error - Shorten an invalid link
    Given The entered URL does not match the URL format
    When The user clicks the button "Shorten URL"
    Then The text "Your URL is invalid" is displayed
    And Input fields are cleared

  Scenario: Error - Shorten a link without a short URL
    Given The entered URL is a URL
    And The entered URL is valid
    And No short URL has been entered
    When The user clicks the button "Shorten URL"
    Then The text "Please enter a short URL" is displayed
    And The input field is highlighted in red

  Scenario: Error - Shorten a link without a category
    Given The entered URL is a URL
    And The entered URL is valid
    And No category has been selected
    When The user clicks the button "Shorten URL"
    Then The text "Please select a category" is displayed
    And The categories are highlighted in red

  Scenario: Success - Shorten a link
    Given The entered URL is a URL
    And The entered URL is valid
    And A short URL has been entered
    And At least one category is selected
    When The user clicks the button "Shorten URL"
    Then The text "Link shortened successfully" is displayed
    And The link is added to the database
    And All inputs are cleared
    And No categories will be selected