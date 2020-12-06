BFFL | Software Architecture Document
======
Version <1.0>
======

- [1. Introduction](#1-introduction)
  * [1.1 Purpose](#11-purpose)
  * [1.2 Scope](#12-scope)
  * [1.3 Definitions, Acronyms and Abbreviations](#13-definitions--acronyms-and-abbreviations)
  * [1.4 References](#14-references)
  * [1.5 Overview](#15-overview)
- [2. Architectural Representation](#2-architectural-representation)
- [3. Architectural Goals and Conststraints](#3-architectural-goals-and-conststraints)
- [4. Use-Case View](#4-use-case-view)
- [5. Logical View](#5-logical-view)
- [6. Deployment View](#6-deployment-view)
- [7. Data View](#7-data-view)

 
Software Architecture Document 
## [1. Introduction](#1-introduction)
[The introduction of the Software Architecture Document provides an overview of the entire Software Architecture Document. It includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview of the Software Architecture Document.]
### 1.1	Purpose
This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

[This section defines the role or purpose of the Software Architecture Document, in the overall project documentation, and briefly describes the structure of the document. The specific audiences for the document is identified, with an indication of how they are expected to use the document.]
### 1.2	Scope
[A brief description of what the Software Architecture Document applies to; what is affected or influenced by this document.]
### 1.3	Definitions, Acronyms, and Abbreviations
[This subsection provides the definitions of all terms, acronyms, and abbreviations required to properly interpret the Software Architecture Document.  This information may be provided by reference to the project’s Glossary.]
### 1.4	References
[This subsection provides a complete list of all documents referenced elsewhere in the Software Architecture Document. Identify each document by title, report number (if applicable), date, and publishing organization. Specify the sources from which the references can be obtained. This information may be provided by reference to an appendix or to another document.]
### 1.5	Overview
[This subsection describes what the rest of the Software Architecture Document contains and explains how the Software Architecture Document is organized.]
## 2.	Architectural Representation Basti
The software architecture for our system is based on AWS in the backend and on Angular in the frontend.
In the [Use-Case View](#4-use-case-view), you find the static requirement analysis and some use cases.
The architecture of the webapp is shown in the [Logical View](#5-logical-view).
In the [Deployment View](#6-deployment-view), you can see our digital infrastracture.
The database scheme is shown in the [Data View](#7-data-view).

## 3.	Architectural Goals and Constraints Basti
Our most important requirement, which has an impact on the architecture is safety. We want our customers data to be protected. In this purpose, we are using keycloak, as you can see in Figure 6, and FIDO2. Keycloak is an open source software and allows single sign-on with Identity and Access Management. A login with your social network account becomes possible. FIDO2 is a new technology, which allows a login without a password, using some identification hardware.
The data protection of our customers is guaranteed in an other way: The AWS has build-in help, which means, that the database can not be deletet by accident.
The points mentioned above are taking possesion of privacy, too. If your data is safe and your account is safe, you can work with the application in privacy.
We want an application with portability, so we decided to work with angular, which is running on all modern browsers. Angular has another advantage, which is reuse. In Angular you are working with modules, which are components of one or more pages. The components can be (re)used on several pages.

## 4.	Use-Case View Basti
The static requirement analysis of the BFFL webapp shows what the core requirements of the application are.

 ![alt text](./Pictures/Static%20Requirement%20Analysis.png?raw=true)
Figure 1: Static Requirement Analysis

The dynamic requirement analysis of the BFFL webapp concretises the static requirement analysis. It consists out of the documentation of the processes of the core requirements shown in the static requirement analysis. The following figures show three of the most important requirements, which are in fact, our use cases:

 ![alt text](./Pictures/Dynamic%20Requirement%20Analysis%20of%20show%20Short-URLs.png?raw=true)
Figure 2: Dynamic Requirement Analysis of “show Short-URLs”

![alt text](./Pictures/Dynamic%20Requirement%20Analysis%20of%20create%20a%20Short-URL.png?raw=true)
Figure 3: Dynamic Requirement Analysis of “create a Short-URL”

 ![alt text](./Pictures/Dynamic%20Requirement%20Analysis%20of%20update%20Short-URLs.png?raw=true)
Figure 4: Dynamic Requirement Analysis of “update Short-URLs”

## 5.	Logical View
![alt text](./Pictures/Logical%20View.png?raw=true)

Figure 5: The following figure shows the architecture of the BFFL webapp and gives information of central functionalities, attributes and dependencies of all major components.

## 6.	Deployment View
 ![alt text](./Pictures/Digital%20Infrastructure%20Diagram.png?raw=true)
Figure 6: Digital Infrastructure Diagram

## 7.	Data View
 ![alt text](./Pictures/DB%20Schema.png?raw=true)
Figure 7: Database scheme
