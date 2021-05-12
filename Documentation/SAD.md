BFFL | Software Architecture Document
======
Version 1.4
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

Revision History
-----

|    Date    | Version | Description      | Author            |
|------------|---------|------------------|-------------------|
| 02.12.2020 |   1.0   | Get default file | Bastian Schäfer   |
| 03.12.2020 |   1.1   | Update chap. 4-7 | Fabian Schwickert |
| 04.12.2020 |   1.2   | Convert to .md   | Bastian Schäfer   |
| 06.12.2020 |   1.3   | Update chap. 2+3 | Bastian Schäfer   |
| 06.12.2020 |   1.4   | Update chap. 1   | Lars Hudalla      |
| 06.04.2021 |   1.3   | Update chap 4    | Bastian Schäfer   |
 
# Software Architecture Document 
## [1. Introduction](#1-introduction)
### [1.1 Purpose](#11-purpose)
This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.
### [1.2 Scope](#12-scope)
This document describes the architecture of the BFFL link shortener project. 
### [1.3 Definitions, Acronyms and Abbreviations](#13-definitions--acronyms-and-abbreviations)
n/a
### [1.4 References](#14-references)
|    File                                                                                           |
|---------------------------------------------------------------------------------------------------|
| [Create short URL](Planning/Requirements_Analysis/Dynamic/Create-URL/UC_Create-Link.md)           |
| [Update short URL](Planning/Requirements_Analysis/Dynamic/Update-URL/UC_Update-Link_22Okt2020.md) |
### [1.5 Overview](#15-overview)
In the following sections the project's architecure will be defined through a description of the requirements and the used systems and software. The archtitecture will be further described with diagrams that showcase the use cases and different views on the logic, deployment and data.
## [2. Architectural Representation](#2-architectural-representation)
The software architecture for our system is based on AWS in the backend and on Angular in the frontend.
In the [Use-Case View](#4-use-case-view), you find the static requirement analysis and some use cases.
The architecture of the webapp is shown in the [Logical View](#5-logical-view).
In the [Deployment View](#6-deployment-view), you can see our digital infrastracture.
The database scheme is shown in the [Data View](#7-data-view).

## [3. Architectural Goals and Conststraints](#3-architectural-goals-and-conststraints)
Our most important requirement, which has an impact on the architecture is safety. We want our customers data to be protected. In this purpose, we are using keycloak, as you can see in Figure 6, and FIDO2. Keycloak is an open source software and allows single sign-on with Identity and Access Management. A login with your social network account becomes possible. FIDO2 is a new technology, which allows a login without a password, using some identification hardware.
The data protection of our customers is guaranteed in an other way: The AWS has build-in help, which means, that the database can not be deletet by accident.
The points mentioned above are taking possesion of privacy, too. If your data is safe and your account is safe, you can work with the application in privacy.
We want an application with portability, so we decided to work with angular, which is running on all modern browsers. Angular has another advantage, which is reuse. In Angular you are working with modules, which are components of one or more pages. The components can be (re)used on several pages.

## [4. Use-Case View](#4-use-case-view)
The static requirement analysis of the BFFL webapp shows what the core requirements of the application are.

 ![alt text](./Pictures/Static%20Requirement%20Analysis.png?raw=true)
Figure 1: Static Requirement Analysis

The dynamic requirement analysis of the BFFL webapp concretises the static requirement analysis. It consists out of the documentation of the processes of the core requirements shown in the static requirement analysis. For more details, you can read our [Software Requirement Specifications](https://github.com/Krayaty/bffl/blob/master/Documentation/SRS.md). 

## [5. Logical View](#5-logical-view)

![alt text](./Pictures/Angular%20Model-View-Controller.jpg?raw=true)
![alt text](./Pictures/Screenshot%20(888).png?raw=true)
Figure 2 and 3: In the second figure, you can see how the components in angular usually belong to rather model, view or controller. The third figure shows how our application is structured. As visible in the second picture, the spec.ts and .ts -files belong to the controller and the .html and .css files belong to the view.

![alt text](./Pictures/Logical%20View%20with%20Model%20View%20and%20Model%20View.jpg?raw=true)
Figure 4: This figure shows the architecture of the BFFL webapp and gives information of central functionalities, attributes and dependencies of all major components. You can also see the parts which belong to the model, the model-view and the view.

## [6. Deployment View](#6-deployment-view)
 ![alt text](./Pictures/Digital%20Infrastructure%20Diagram.png?raw=true)
Figure 5: Digital Infrastructure Diagram

## [7. Data View](#7-data-view)
 ![alt text](./Pictures/DB%20Schema.png?raw=true)
Figure 5: Database scheme
