BFFL | Software Requirements Specification
======
Version 1.2
======

- [1. Introduction](#1-introduction)
  * [1.1 Purpose](#11-purpose)
  * [1.2 Scope](#12-scope)
  * [1.3 Definitions, Acronyms and Abbreviations](#13-definitions--acronyms-and-abbreviations)
  * [1.4 References](#14-references)
  * [1.5 Overview](#15-overview)
- [2. Overall Description](#2-overall-description)
  * [2.1 Vision](#21-vision)
  * [2.2 Use Case Diagram](#22-use-case-diagram)
  * [2.3 Technology Stack](#23-technology-stack)
- [3. Specific Requirements](#3-specific-requirements)
  * [3.1 Functionality](#31-functionality)
    + [3.1.1 Accessmanagement](#311-accessmanagement)
    + [3.1.2 Linking to other websites](#312-linking-to-other-websites)
    + [3.1.3 Data Analysis](#313-data-analysis)
    + [3.1.4 Dashboard](#314-dashboard)
  * [3.2 Usability](#32-usability)
    + [3.2.1 Conform common usability standards](#321-conform-common-usability-standards)
    + [3.2.2 Appearance](#322-appearance)
  * [3.3 Reliability](#33-reliability)
    + [3.3.1 Availability](#331-availability)
    + [3.3.2 Defect Rate](#332-defect-rate)
  * [3.4 Perfomance](#34-perfomance)
    + [3.4.1 Capacity](#341-capacity)
    + [3.4.2 App perfomance / Response time](#342-app-performance-response-time)
    3.4.2 App perfomance / Response time
  * [3.5 Supportability](#35-supportability)
  * [3.6 Design Constraints](#36-design-constraints)
  * [3.7 On-line User Documentation and Help System Requirements](#37-on-line-user-documentation-and-help-system-requirements)
  * [3.8 Purchased Components](#38-purchased-components)
  * [3.9 Interfaces](#39-interfaces)
    + [3.9.1 User Interfaces](#391-user-interfaces)
    + [3.9.2 Hardware Interfaces](#392-hardware-interfaces)
    + [3.9.3 Software Interfaces](#393-software-interfaces)
    + [3.9.4 Communications Interfaces](#394-communications-interfaces)
  * [3.10 Licensing Requirements](#310-licensing-requirements)
  * [3.11 Legal, Copyright, and Other Notices](#311-legal--copyright--and-other-notices)
  * [3.12 Applicable Standards](#312-applicable-standards)
- [4. Supporting Information](#4-supporting-information)

Revision History
-----

|    Date    | Version | Description                   | Author            |
|------------|---------|-------------------------------|-------------------|
| 10.10.2020 |   1.0   |  <Add Chapters>               | <BFFL>            |
| 06.12.2020 |   1.1   |  <Update Table of Contents>   | Bastian Schäfer   |
| 17.12.2020 |   1.2   |  Minor fixes                  | Felix Hirschel    |

## [1. Introduction](#1-introduction)


### [1.1 Purpose](#11-purpose)
This SRS's (or software requirements specification) purpose is to save, list and document planned features. By doing so, it should give any person interested a more or less detailed outline about the link-shortening-project BFFL (name remains yet to be changed). Therefore it should explain usability and expected behaviour of the application. It is supposed to hold all functional, as well as non-functional requirements, which may or may not be implemented throughout the next year (late 2020 to mid 2021).

### [1.2 Scope](#12-scope)
The document contains the BFFL project in its entirety, therefore containing information and requirements about the following sub-systems:
 - Link-Administration: A collection of all shortened links by a single user or their respective group.
 - Access management: The option for users to create and manage their account. Also provides grouping of such.
 - Dashboard: Gives users an overview over data collected by usage of their shortened links.

### [1.3 Definitions, Acronyms and Abbreviations](#13-definitions--acronyms-and-abbreviations)

| Abbrevation | Explanation                            |
| ----------- | -------------------------------------- |
| SRS         | Software Requirements Specification    |
| n/a         | not applicable                         |
| tbd         | to be determined                       |
| ----------- | -------------------------------------- |

### [1.4 References](#14-references)
[This subsection should provide a complete list of all documents referenced elsewhere in the SRS.  Each document should be identified by title, report number (if applicable),
date, and publishing organization.  Specify the sources from which the references can be obtained. This information may be provided by reference to an appendix or to another
document.]
| Title                                                                           | Date       | Publishing organization   |
| --------------------------------------------------------------------------------|:----------:| ------------------------- |
| [Topic](URL)                                                                    | XX.XX.XXXX | <author>                  |
| --------------------------------------------------------------------------------|:----------:| ------------------------- |


### [1.5 Overview](#15-overview)
[This subsection should describe what the rest of the SRS contains and explain how the document is organized.]

## [2. Overall Description](#2-overall-description)
[This section of the SRS should describe the general factors that affect the product and its requirements.  This section does not state specific requirements.  
Instead, it provides a background for those requirements, which are defined in detail in Section 3, and makes them easier to understand. Include such items as:
 - product perspective
 - product functions
 - user characteristics
 - constraints
 - assumptions and dependencies
 - requirements subsets


### [2.1 Vision](#21-vision)
Running out of options for pretty URLs can be really frustrating, espcially when trying to build a huge application. In addition to that it becomes rather hard to keep it clean and keeping track of everything is often an impossible task. BFFL is a project providing a URL-shortening-service with the goal of providing a secure and professional alternative to common URL-shorteners for business environments.
Furthermore you will not only be able to manage a tidied up collection of links but access additional information about the usage of your hyperlinks.

### [2.2 Use Case Diagram](#22-use-case-diagram)
![alt text](https://lucid.app/publicSegments/view/0dad81c4-3d9b-4b91-b314-05ccb2a11b17/image.png)
Find the respective CRUD and the applying UCs [here](https://github.com/Krayaty/bffl/blob/master/Documentation/Planning/Requirements_Analysis/Static/CRUD/CRUD.md).

### [2.3 Technology Stack](#23-technology-stack)
Our frontend will primarily be done with [Angular CLI](https://cli.angular.io/). The database and overlying system we will use to store all those URLs is, just as the system connecting the UI to our server, tbd.

## [3. Specific Requirements](#3-specific-requirements)
Every user can shorten URLs, search for his shortend URLs and manage them:
Our program should primary shorten URLs, that means, that it creates a short URL for a given (long) URL. This short URL is tied with the original URL and can be managed in a clearly structured table. By using the search functions, you can find every URL, you shortened.

### [3.1 Functionality](#31-functionality)
The main services, the software must offer, has been mentioned in the "Specific Requirements" (Chapter 3) and in the "Use Case Diagram" (Chapter 2).
As you can see there, the system is divided in three subsystems. The Accessmanagement and the Linking to other Websites will be done this semester, the data analysis will be done in the next semester. In this software, security is very important, because we are having to do responsible with the data of our customers.

#### [3.1.1 Accessmanagement](#311-accessmanagement)
The system should have an accessmanagement. There should be an acces for the application manager who manages the accounts and the group, which can acces the data of a certain application.

#### [3.1.2 Linking to other websites](#312-linking-to-other-websites)
The most important function is the creation of new shortend URLs. Those shortend URLs should link to a given Website, which can easily be changed. Because of this, the combination of shortend URL and the original URL has to be saved in a table, where the content should be managed by the regular user. This should be realized by a search function, with which a specific URL can be searched in the created URLs.

#### [3.1.3 Data Analysis](#313-data-analysis)
The accessmanager, mentioned at the top, has acces to the data analysis. In this subsystem, security should be ensured, because this is the part, where ths user daata is collected and the evaluation is shown on a Dashboard, specified below.

#### [3.1.4 Dashboard](#314-dashboard)
The application should have a Dashboard, where all important information for the users are shown.

## [3.2 Usability](#32-usability)
A normal user is for example a person responible for some websites. Those persons are normally used to URLs and will immediately understand the functionality of our application. The required training time should be nearly zero.
The usabilty requirements should be simliar to URL shortener like "bitly". The time fot the typical task, which is to shorten a URL should be under 3 minutes. The management of the created short URLs should not take more time, too.

### [3.2.1 Conform common usability standards](#321-conform-common-usability-standards)
The websites should contain no unnecessary content. In the development process, we will experience, which content will be important to show on the dashboard, and whcih content will not. In the design process, the comparison to real URL shortener should be made. There should just be pop-ups, if it is really necessary. Besides, the user should not have to wait longer than 30 seconds for any service of the application. The website should be accesible by everyone, even if one does not has the rights. We do not need to mention, that the website should be accesible from every common browser (Safari, Google Chrome, Firefox, Microsoft Edge, Internet Explorer). The application should have a search function, with which one can find and access content of the whole application.

#### [3.2.2 Appearance](#322-appearance)
The homepage of our application should be understandable and inform the user exactly, what one can get on this website. The content should be ordered from important to unimportant from the top to the bottom. The website should have a clear structured navigation menu, with which one can get from every page to every page. If scrolling is necessary on the page, the header and the navigation of the page should stay, while the content moves. Links on the website should be named clearly. Of course, the font formatting should be consistent on the whole application. The same categories of information, for example phone numbers, should always be formatted in the same way.

### [3.3 Reliability](#33-reliability)
The application should always be avaiable and should not lose any data.

#### [3.3.1 Availability](#331-availability)
The application should be avaible all the time. 

#### [3.3.2 Defect Rate](#332-defect-rate)
Our goal is that we have no loss of any data. It is important for people working with the application, to be sure, that the shortened URLs and the original URLs are available in there relation.

### [3.4 Perfomance](#34-perfomance)

#### [3.4.1 Capacity](#341-capacity)
The system should normally not have more than ten users at the same time.

#### [3.4.2 App perfomance / Response time](#342-app-performance-response-time)
The response time should be, as described in the "Usability" as short as possible.

### [3.5 Supportability](#35-supportability)
The coding for the project should follow strict guidelines regarding the naming of for example variables and methods. These should, unless they are a simple interator, be named in an understandable way that describes their function. Additionally comments should be added at important places in the code to describe its functionality.

### [3.6 Design Constraints](#36-design-constraints)
The application should be created using the framework Angular for the frontend. Further more for now only the standard libraries and no external ones should be used. 

### [3.7 On-line User Documentation and Help System Requirements](#37-on-line-user-documentation-and-help-system-requirements)
Alongside the actual application there should also be created a user documentation that clearly describes the application's functionality. This documentation should include all the implemented functions of the product and how to use them.

### [3.8 Purchased Components](#38-purchased-components)
In order to avoid license fees, only freely available software products should be used. 

### [3.9 Interfaces](#39-interfaces)
#### [3.9.1 User Interfaces](#391-user-interfaces)
The UI should be kept to a minimum. The design is unimportant at first. What is relevant is that there is one log-in and two different websites based on user roles. On the page for users it should be possible to shorten, change and manage URLs. On the page for admins the same should be possible. Additionally a dashboard for data analysis should be displayed.

#### [3.9.2 Hardware Interfaces](#392-hardware-interfaces)
Since the web application requires a DBMS and a user administration service, a server must be configured accordingly.

#### [3.9.3 Software Interfaces](#393-software-interfaces)
Since this application is essentially based on a DBMS, it is particularly important that such a DBMS is used and connected to the rest.
It is also likely that a service for data analysis is needed.
A user administration service is also elementary.

#### [3.9.4 Communications Interfaces](#394-communications-interfaces)
not applicable

### [3.10 Licensing Requirements](#310-licensing-requirements)
For this project only software and hardware that can be used commercially free of charge shall be used. Therefore nothing has to be licensed with costs. Everything that is used is licensed under a license similar to the General Public License.
The content of this project is intellectual property of the above mentioned persons and may not be used or copied without their permission. The idea behind it is to put only commercial free software into the product, so that this product can theoretically be published later. Should it come to that, the product itself will have to be licensed by the user.

### [3.11 Legal, Copyright, and Other Notices](#311-legal--copyright--and-other-notices)
Since only software and hardware should be used which is under a free license, there should be no legal problems in this area. Concerning copyrights and patents there are no problems for the time being, because there is no commercial interest in this project. A release with commercial use is not planned in the near future.

### 3[3.12 Applicable Standards](#312-applicable-standards)
During the implementation of the project, the URL standard RFC-1738 should be followed.

## [4. Supporting Information](#4-supporting-information)
This project is an assignment of the following students at the DHBW Karlsruhe:
Felix Hirschel,
Lars Hudalla,
Bastian Schäfer,
Fabian Schwickert.
This application may not meet any legal requirements and therefore may not be used commercially or otherwise publicly. This project is only a purely pedagogical exercise. The content of this project is intellectual property of the above mentioned persons and may not be used or copied without their permission.
No liability is assumed for any commercial use by third parties.
