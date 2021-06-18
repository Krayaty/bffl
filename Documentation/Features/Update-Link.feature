Feature: Update-Link
  as a User
    I want to be able to find my shortened URLs on the main page in a List view. By clicking on an entry I want to be
    able to change the entry. I want to see a view that shows me all changeable fields. With click on submit all changes
    should be saved. With click on cancel I the changes should be discarded.

  Background: User is logged in.

  Scenario: User and his group have no URL saved.
    Given the user and his group have no URL saved in the database
    Then an empty list should be viewed

  Scenario: The User and his group have an URL saved and successfully changes the entry.
    Given the user and his group have minimum one URL saved in the database
    When the user clicks on an entry
    Then the update-view should open for the specific entry
    When the user changes the entries data
    And clicks on submit
    And the data is valid
    Then the data is changed in the database
    And the main page is shown
    But the update-view closes

  Scenario: The User and his group have an URL saved and changes the entry but discards the changes.
    Given the user and his group have at least one URL saved in the database
    When the user clicks on an entry
    Then the update-view should open for the specific entry
    When the user changes the entries data
    And exits the update view
    Then the changes are discarded by not sending an SQL-request
    And the main page is shown

  Scenario: The User and his group have an URL saved and wants to change the entry, but the new data is not valid.
    Given the user and his group have minimum one URL saved in the database
    When the user clicks on an entry
    Then the update-view should open for the specific entry
    When the user changes the entries data
    Then the submit button should be disable
