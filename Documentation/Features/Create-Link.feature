Feature: Use Case to shorten a link
  As a user
  I want to open the app and be able to shorten a link to a custom URL
  So that my own web application stays tidied up and I can keep track of all my internal URLs

  Background:
    Given The user is logged in
    And The user is part of a group
    And The app is opened

  Scenario: Error - Shorten an existing link
    Given The entered URL is already in the database
    When The user clicks the button "Shorten URL"
    Then Text "Your URL has been shortened already" is displayed

  Scenario: Error - Shorten an invalid link
    Given The entered URL does not match the URL format
    When The user clicks the button "Shorten URL"
    Then The text "Missing or wrong argument for TargetURL" is displayed
    And The input field is highlighted in red

  Scenario: Error - Shorten a link without a suffix
    Given The entered URL is a URL
    And The entered URL is valid
    And No custom suffix is entered
    When The user clicks the button "Shorten URL"
    Then The text "Missing or wrong argument for suffix of ShortURL" is displayed
    And The input field is highlighted in red

  Scenario: Error - Shorten a link without a scope
    Given The entered URL is a URL
    And The entered URL is valid
    And A custom suffix is entered
    And No Scope is selected
    When The user clicks the button "Shorten URL"
    Then The test "Missing or wrong argument for scope" is displayed

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