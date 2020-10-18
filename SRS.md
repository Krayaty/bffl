BBFL | Software Requirements Specification
======
Version <1.0>
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
    + [3.1.1 Linking to other websites](#311-linking-to-other-website)
    + [3.1.2 Accessmanagement](#311-accessmanagement)
    + [3.1.3 Data Analysis](#311-data-analysis)
    + [3.1.4 Dashboard](#311-dashboard)
- [3.2 Usability](#32-usability)
  * [3.2.1 Usability Requirement One](#321-usability-requirement-one)
  * [3.3 Supportability](#35-supportability)
    + [3.5.1 Supportability Requirement One](#351-supportability-requirement-one)
  * [3.4 Design Constraints](#36-design-constraints)
    + [3.6.1 Design Constraint One](#361--design-constraint-one-)
  * [3.5 On-line User Documentation and Help System Requirements](#37-on-line-user-documentation-and-help-system-requirements)
  * [3.6 Purchased Components](#38-purchased-components)
  * [3.7 Interfaces](#39-interfaces)
    + [3.7.1 User Interfaces](#391-user-interfaces)
    + [3.7.2 Hardware Interfaces](#392-hardware-interfaces)
    + [3.7.3 Software Interfaces](#393-software-interfaces)
    + [3.7.4 Communications Interfaces](#394-communications-interfaces)
  * [3.8 Licensing Requirements](#310-licensing-requirements)
  * [3.9 Legal, Copyright, and Other Notices](#311-legal--copyright--and-other-notices)
  * [3.10 Applicable Standards](#312-applicable-standards)
- [4. Supporting Information](#4-supporting-information)

#Revision History
-----

|    Date    | Version | Description | Author |
|------------|---------|-------------|--------|
| XX.XX.XXXX |   X.X   |  <details>  | <name> |

## 1. Introduction


### 1.1 Purpose
This SRS's (or software requirements specification) purpose is to save, list and document planned features. By doing so, it should give any person interested a more or less detailed outline about the link-shortening-project BFFL (name remains yet to be changed). Therefore it should explain usability and expected behaviour of the application. It is supposed to hold all functional, as well as non-functional requirements, which may or may not be implemented throughout the next year (late 2020 to mid 2021).

### 1.2 Scope
The document contains the BFFL project in its entirety, therefore containing information and requirements about the following sub-systems:
 - Link-Administration: A collection of all shortened links by a single user or their respective group.
 - Access management: The option for users to create and manage their account. Also provides grouping of such.
 - Dashboard: Gives users an overview over data collected by usage of their shortened links.

### 1.3 Definitions, Acronyms and Abbreviations

| Abbrevation | Explanation                            |
| ----------- | -------------------------------------- |
| SRS         | Software Requirements Specification    |
| n/a         | not applicable                         |
| tbd         | to be determined                       |
| ----------- | -------------------------------------- |

### 1.4 References
[This subsection should provide a complete list of all documents referenced elsewhere in the SRS.  Each document should be identified by title, report number (if applicable), 
date, and publishing organization.  Specify the sources from which the references can be obtained. This information may be provided by reference to an appendix or to another 
document.]
| Title                                                                           | Date       | Publishing organization   |
| --------------------------------------------------------------------------------|:----------:| ------------------------- |
| [Topic](URL)                                                                    | XX.XX.XXXX | <author>                  |
| --------------------------------------------------------------------------------|:----------:| ------------------------- |


### 1.5 Overview
[This subsection should describe what the rest of the SRS contains and explain how the document is organized.]

## 2. Overall Description
[This section of the SRS should describe the general factors that affect the product and its requirements.  This section does not state specific requirements.  
Instead, it provides a background for those requirements, which are defined in detail in Section 3, and makes them easier to understand. Include such items as:
 - product perspective
 - product functions
 - user characteristics
 - constraints
 - assumptions and dependencies
 - requirements subsets]


### 2.1 Vision
Running out of options for pretty URLs can be really frustrating, espcially when trying to build a huge application. In addition to that it becomes rather hard to keep it clean and keeping track of everything is often an impossible task. BFFL is a project providing a URL-shortening-service with the goal of providing a secure and professional alternative to common URL-shorteners for business environments.
Furthermore you will not only be able to manage a tidied up collection of links but access additional information about the usage of your hyperlinks.

### 2.2 Use Case Diagram
![alt text](https://lucid.app/publicSegments/view/0dad81c4-3d9b-4b91-b314-05ccb2a11b17/image.png)

### 2.3 Technology Stack
Our frontend will primarily be done with [Angular CLI](https://cli.angular.io/). The database and overlying system we will use to store all those URLs is, just as the system connecting the UI to our server, tbd.

## 3. Specific Requirements
Every user can shorten URLs, search for his shortend URLs and manage them:
Our program should primary shorten URLs, that means, that it creates a short URL for a given (long) URL. This short URL is tied with the original URL and can be managed in a clearly structured table. By using the search functions, you can find every URL, you shortened.

### 3.1 Functionality
The main services, the software must offer, has been mentioned in the "Specific Requirements" (Chapter 3) and in the "Use Case Diagram" (Chapter 2).
As you can see there, the system is divided in three subsystems. The Accessmanagement and the Linking to other Websites will be done this semester, the data analysis will be done in the next semester. In this software, security is very important, because we are having to do responsible with the data of our customers.

#### 3.1.2 Linking to other websites
The most important function is the creation of new shortend URLs. Those shortend URLs should link to a given Website, which can easily be changed. Because of this, the combination of shortend URL and the original URL has to be saved in a table, where the content should be managed by the regular user. This should be realized by a search function, with which a specific URL can be searched in the created URLs.

#### 3.1.1 Accessmanagement
The system should have an accessmanagement. There should be an acces for the application manager who manages the accounts and the group, which can acces the data of a certain application. 

#### 3.1.3 Data Analysis
The accessmanager, mentioned at the top, has acces to the data analysis. In this subsystem, security should be ensured, because this is the part, where ths user daata is collected and the evaluation is shown on a Dashboard, specified below.

#### 3.1.4 Dashboard
The application should have a Dashboard, where all important information for the users are shown.

## 3.2 Usability
A normal user is for example a person responible for some websites. Those persons are normally used to URLs and will immediately understand the functionality of our application. The required training time should be nearly zero.
The usabilty requirements should be simliar to URL shortener like "bitly". The time fot the typical task, which is to shorten a URL should be under 3 minutes. The management of the created short URLs should not take more time, too.

### 3.2.1 Conform common usability standards
The websites should contain no unnecessary content. In the development process, we will experience, which content will be important to show on the dashboard, and whcih content will not. In the design process, the comparison to real URL shortener should be made. There should just be pop-ups, if it is really necessary. Besides, the user should not have to wait longer than 30 seconds for any service of the application. The website should be accesible by everyone, even if one does not has the rights. We do not need to mention, that the website should be accesible from every common browser (Safari, Google Chrome, Firefox, Microsoft Edge, Internet Explorer). The application should have a search function, with which one can find and access content of the whole application.

#### 3.2.2 Appearance
The homepage of our application should be understandable and inform the user exactly, what one can get on this website. The content should be ordered from important to unimportant from the top to the bottom. The website should have a clear structured navigation menu, with which one can get from every page to every page. If scrolling is necessary on the page, the header and the navigation of the page should stay, while the content moves. Links on the website should be named clearly. Of course, the font formatting should be consistent on the whole application. The same categories of information, for example phone numbers, should always be formatted in the same way.


### 3.3 Supportability
[This section indicates any requirements that will enhance the supportability or maintainability of the system being built, including coding standards, naming conventions, 
class libraries, maintenance access, maintenance utilities.]

#### 3.3.1 Supportability Requirement One
[The requirement description goes here.]

### 3.4 Design Constraints
[This section should indicate any design constraints on the system being built. Design constraints represent design decisions that have been mandated and must be adhered to.  
Examples include software languages, software process requirements, prescribed use of developmental tools, architectural and design constraints, purchased components, class 
libraries, etc.]

#### 3.4.1 <Design Constraint One>
[The requirement description goes here.]

### 3.5 On-line User Documentation and Help System Requirements
[Describes the requirements, if any, for on-line user documentation, help systems, help about notices, etc.]

### 3.6 Purchased Components
[This section describes any purchased components to be used with the system, any applicable licensing or usage restrictions, and any associated compatibility and interoperability or 
interface standards.]

### 3.7 Interfaces
[This section defines the interfaces that must be supported by the application. It should contain adequate specificity, protocols, ports and logical addresses, etc. so that the software 
can be developed and verified against the interface requirements.]

#### 3.7.1 User Interfaces
[Describe the user interfaces that are to be implemented by the software.]

#### 3.7.2 Hardware Interfaces
[This section defines any hardware interfaces that are to be supported by the software, including logical structure, physical addresses, expected behavior, etc. ]

#### 3.7.3 Software Interfaces
[This section describes software interfaces to other components of the software system. These may be purchased components, components reused from another application or 
components being developed for subsystems outside of the scope of this SRS but with which this software application must interact.]

#### 3.7.4 Communications Interfaces
[Describe any communications interfaces to other systems or devices such as local area networks, remote serial devices, etc.]

### 3.8 Licensing Requirements
[Defines any licensing enforcement requirements or other usage restriction requirements that are to be exhibited by the software.]

### 3.9 Legal, Copyright, and Other Notices
[This section describes any necessary legal disclaimers, warranties, copyright notices, patent notice, wordmark, trademark, or logo compliance issues for the software.]

### 3.10 Applicable Standards
[This section describes by reference any applicable standard and the specific sections of any such standards which apply to the system being described. For example, this could 
include legal, quality and regulatory standards, industry standards for usability, interoperability, internationalization, operating system compliance, etc.]

## 4. Supporting Information
[The supporting information makes the SRS easier to use.  It includes:
 - Table of contents
 - Index
 - Appendices
These may include use-case storyboards or user-interface prototypes. When appendices are included, the SRS should explicitly state whether or not the appendices are to be 
considered part of the requirements.]
