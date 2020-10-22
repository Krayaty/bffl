# BFFL
# Use Case Specification: Update an URL-entry.

## Version <1.0>

Revision History
----

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
  * [3.2 Alternative Flows](#32-Alternative-Flows)
- [4. Special Requirements](#4-special-requirements)
- [5. Preconditions](#5-Preconditions)
- [6. Postconditions](#6-Postconditions)
- [7. Extension Points](#7-Extension-Points)
  
# Use Case Specification: Update an URL-entry.
  
## 1. Use-Case Name  
### 1.1 Brief Description
This document is a definition of a special use case called: "Update an URL-entry".
This is part of a so-called CRUD. CRUD is an acronym that describes the four fundamental operations of data management:
- Create (Insert): Create new data.
- Read (Select, Retrieve. Search): Select existing data and make it available for further processing.
- Udate (Modify): Update existing data.
- Delete (Destroy): Delete obsolete data.

(see glossar.hs-augsburg.de (ed.): CRUD, 19th Mai 2016, https://glossar.hs-augsburg.de/CRUD, retrieved on 22.10.2020.)

The [CRUD](../README.md) referred to here deals with the main content of this web application: shortened URLs.
The present document concretizes the process "Update".
 
 
## 2. Mock Up
### 2.1 Mock
abc
  
### 2.2 Screenshots
abc 
 
 
## 3. Flow of Events
### 3.1 Basic Flow
![Basic Flow](res/UC_Update_22Okt2020.png)
  
### 3.2 Alternative Flows
n/a
  
  
## 4. Special requirements
n/a

 
## 5. Preconditions
The following must be done before a URL entry can be changed
- The user must be registered. 
- The user must be logged in.
- The user himself or a member of his group must have created at least one URL entry.
  
  
## 6. Postconditions
When an attempt is made to change a URL entry, the application can enter three states: 
1. The target URL is to be changed.
    1. The URL is valid and accessible.
    2. The URL is not reachable.
2. Something other than the URL is to be changed.

In the case of states 1.2 and 2, no problem occurs and success is displayed after the record has been changed.
In case of state 1.1 a problem occurs which is immediately reported to the user.
In both cases the application can be used normally.
  
  
## 7. Extension Points
This Use Case is a possible follow-up process to the [creation](../README.md), [deletion](../README.md) and [display](../README.md) of shortened URLs in the [CRUD](../README.md) described above.
