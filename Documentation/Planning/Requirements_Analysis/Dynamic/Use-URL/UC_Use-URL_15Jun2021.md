# BFFL
# Use Case Specification: Use ShortURL.

## Version <1.0>

# Revision History
-----

|    Date    | Version | Description | Author |
|------------|---------|-------------|--------|
| 22.10.2020 |   1.0   |  -  | Krayaty |

# Table of Contents

- [1. Use-Case Name](#1-Use-Case-Name)
  * [1.1 Brief Description](#11-Brief-Description)
- [2. Mock Up](#2-Mock-Up)
  * [2.1 Mock](#21-Mock)
  * [2.2 Screenshots](#22-Screenshots)
- [3. Flow of Events](#3-Flow-of-Events)
  * [3.1 Basic Flow](#31-Basic-Flow)
  * [3.2 .feature](#32-.feature)
  * [3.3 Alternative Flows](#33-Alternative-Flows)
- [4. Special Requirements](#4-special-requirements)
- [5. Preconditions](#5-Preconditions)
- [6. Postconditions](#6-Postconditions)

# Use Case Specification: Use ShortURL.

## 1. Use-Case Name  
### 1.1 Brief Description
The content of this document is the specification of the use case called "Use ShortURL".
This use case describes the use of a ShortURL to forward to a target url.

## 2. Mock Up
### 2.1 Mock
n/a

### 2.2 Screenshots
n/a


## 3. Flow of Events
### 3.1 Basic Flow
![Basic Flow](./UC_Use-URL_flow)

### 3.2 .feature
``` Cucumber
  Feature: Use Case use a ShortURL
    As a user
    I want to click on or input a ShortURL to get to the current registered target website.

    Background:
      Given The ShortURL exists

    Scenario: Error - Invalid ShortURL
      Given The ShortURL isn't valid (time)
      Then The user gets redirected to an error page

    Scenario: Success - Invalid target
      Given The ShortURL hasn't a current valid target
      Then The user gets redirected to an the targeted where an error is created
      And An url_call-entry is created with the clients ip

    Scenario: Success - Redirect and save url_call-entry
      Given The The ShortURL is valid (time)
      And The ShortURL has a current valid target
      Then The user gets redirected to the targeted website
      And An url_call-entry is created with the clients ip
```

### 3.3 Alternative Flows
n/a


## 4. specific requirements
n/a


## 5. Preconditions
To use a ShortURL following requirements have to be met:
- The ShortURL must exist
- The ShortURL needs to be valid (time)
- The ShortURL must have a current valid target


## 6. Postconditions
- After usage of a ShortURL the client is redirected to the targeted website.
- An url_call-entry is created for the client that used the ShortURL


## 7. Extension Points
n/a
