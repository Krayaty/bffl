# BFFL
# Use Case Specification: Create a new URL-entry.

## Version <1.0>

Revision History
----

|    Date    | Version | Description | Author |
|------------|---------|-------------|--------|
| 23.10.2020 |   1.0   |  First specification of use case   | Felix |

# Table of Contents

- [1. Use-Case Name](#1-Use-Case-Name)
  * [1.1 Brief Description](#11-Brief-Description)
- [2. Mock Up](#2-Mock-Up)
  * [2.1 Mock](#21-Mock)
  * [2.2 Screenshots](#22-Screenshots)
- [3. Flow of Events](#3-Flow-of-Events)
  * [3.1 Basic Flow](#31-Basic-Flow)
  * [3.2 Alternative Flows](#32-Alternative-Flows)
- [4. Special Requirements](#4-special-requirements)
- [5. Preconditions](#5-Preconditions)
- [6. Postconditions](#6-Postconditions)
  
# Use Case Specification: Update an URL-entry.
  
## 1. Use-Case Name  
### 1.1 Brief Description
The content of this document is the specification of the use case called "Create URL-entry". 
The use case itself is part of a CRUD regarding the management of URLs in our application. The CRUD holds all four operations (Create, Read, Update, Delete) which you will
find [here](CRUD.md).
 
 
## 2. Mock Up
### 2.1 Mock
![Mock of application](Mock/mock_total.png)
  
### 2.2 Screenshots
### 2.2.1 Initial state of URL registration
![Mock of entry fields](Mock/mock_input.png)

### 2.2.2 After registering a new URL
![Mock of successful registration](Mock/mock_success.png)
 
 
## 3. Flow of Events
### 3.1 Basic Flow
![Basic Flow](./UC_Create_Link.png)
  
### 3.2 .feature
  ``` Cucumber 
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
  ```
  
### 3.3 Alternative Flows
n/a
  
  
## 4. Special requirements
n/a

 
## 5. Preconditions
To create a new URL-entry following requirements have to be met:
- The user must be logged in with a valid account
- The account of such user has to be part of at least one group
- The user has to be on the main page of the application
  
  
## 6. Postconditions
After a new URL has been registered succesfully, its properties must be added to the database.
In case of an unsuccessful registration the user is to be notified and the database will be left unchanged. The application remains usable.
