Project - PROJECTNAME | Software Requirements Specification
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
    + [3.1.1 Functional Requirement One](#311-functional-requirement-one)
- [3.2 Usability](#32-usability)
  * [3.2.1 Usability Requirement One](#321-usability-requirement-one)
- [3.3 Reliability](#33-reliability)
  * [3.3.1 Reliability Requirement One](#331-reliability-requirement-one)
- [3.4 Perfomance](#34-perfomance)
  * [3.4.1 Performance Requirement One](#341-performance-requirement-one)
  * [3.5 Supportability](#35-supportability)
    + [3.5.1 Supportability Requirement One](#351-supportability-requirement-one)
  * [3.6 Design Constraints](#36-design-constraints)
    + [3.6.1 Design Constraint One](#361--design-constraint-one-)
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
Shorten URLs, search for URLs and manage the shortened URLs.
[This section of the SRS should contain all the software requirements to a level of detail sufficient to enable designers to design a system to satisfy those requirements,
and testers to test that the system satisfies those requirements.   When using use-case modeling, these requirements are captured in the Use-Cases and the applicable
supplementary specifications.  If use-case modeling is not used, the outline for supplementary specifications may be inserted directly into this section, as shown below.]

### 3.1 Functionality
[This section describes the functional requirements of the system for those requirements which are expressed in the natural language style. For many applications, this may
constitute the bulk of the SRS Package and thought should be given to the organization of this section. This section is typically organized by feature, but alternative
organization methods may also be appropriate, for example, organization by user or organization by subsystem.  Functional requirements may include feature sets, capabilities,
and security.
Where application development tools, such as requirements tools, modeling tools, etc., are employed to capture the functionality, this section document will refer to the
availability of that data, indicating the location and name of the tool that is used to capture the data.]

#### 3.1.1 Functional Requirement One
[The requirement description.]

## 3.2 Usability
[This section should include all of those requirements that affect usability. For example,
 - specify the required training time for a normal users and a power user to become productive at particular operations
 - specify measurable task times for typical tasks or base the new system’s usability requirements on other systems that the users know and like
 - specify requirement to conform to common usability standards, such as IBM’s CUA standards Microsoft’s GUI standards]

### 3.2.1 Usability Requirement One
[The requirement description goes here.]

## 3.3 Reliability
[Requirements for reliability of the system should be specified here. Some suggestions follow:
 - Availability—specify the percentage of time available ( xx.xx%), hours of use, maintenance access, degraded mode operations, etc.
 - Mean Time Between Failures (MTBF) — this is usually specified in hours, but it could also be specified in terms of days, months or years.
 -  Mean Time To Repair (MTTR)—how long is the system allowed to be out of operation after it has failed?
 - Accuracy—specify precision (resolution) and accuracy (by some known standard) that is required in the system’s output.
 - Maximum Bugs or Defect Rate—usually expressed in terms of bugs per thousand of lines of code (bugs/KLOC) or bugs per function-point( bugs/function-point).
 - Bugs or Defect Rate—categorized in terms of minor, significant, and critical bugs: the requirement(s) must define what is meant by a “critical” bug; for example, complete
   loss of data or a complete inability to use certain parts of the system’s functionality.]

### 3.3.1 Reliability Requirement One
[The requirement description.]

## 3.4 Perfomance
[The system’s performance characteristics should be outlined in this section. Include specific response times. Where applicable, reference related Use Cases by name.
 - response time for a transaction (average, maximum)
 - throughput, for example, transactions per second
 - capacity, for example, the number of customers or transactions the system can accommodate
 - degradation modes (what is the acceptable mode of operation when the system has been degraded in some manner)
 - resource utilization, such as memory, disk, communications, etc.

### 3.4.1 Performance Requirement One
[The requirement description goes here.]

### 3.5 Supportability
[This section indicates any requirements that will enhance the supportability or maintainability of the system being built, including coding standards, naming conventions,
class libraries, maintenance access, maintenance utilities.]

#### 3.5.1 Supportability Requirement One
[The requirement description goes here.]

### 3.6 Design Constraints
[This section should indicate any design constraints on the system being built. Design constraints represent design decisions that have been mandated and must be adhered to.  
Examples include software languages, software process requirements, prescribed use of developmental tools, architectural and design constraints, purchased components, class
libraries, etc.]

#### 3.6.1 <Design Constraint One>
[The requirement description goes here.]

### 3.7 On-line User Documentation and Help System Requirements
[Describes the requirements, if any, for on-line user documentation, help systems, help about notices, etc.]

### 3.8 Purchased Components
[This section describes any purchased components to be used with the system, any applicable licensing or usage restrictions, and any associated compatibility and interoperability or
interface standards.]

### 3.9 Interfaces
#### 3.9.1 User Interfaces
The UI should be kept to a minimum. The design is unimportant at first. What is relevant is that there is one log-in and two different websites based on user roles. On the page for users it should be possible to shorten, change and manage URLs. On the page for admins the same should be possible. Additionally a dashboard for data analysis should be displayed.

#### 3.9.2 Hardware Interfaces
Since the web application requires a DBMS and a user administration service, a server must be configured accordingly.

#### 3.9.3 Software Interfaces
Since this application is essentially based on a DBMS, it is particularly important that such a DBMS is used and connected to the rest.
It is also likely that a service for data analysis is needed.
A user administration service is also elementary.

#### 3.9.4 Communications Interfaces
not applicable

### 3.10 Licensing Requirements
For this project only software and hardware that can be used commercially free of charge shall be used. Therefore nothing has to be licensed with costs. Everything that is used is licensed under a license similar to the General Public License.
The content of this project is intellectual property of the above mentioned persons and may not be used or copied without their permission. The idea behind it is to put only commercial free software into the product, so that this product can theoretically be published later. Should it come to that, the product itself will have to be licensed by the user.

### 3.11 Legal, Copyright, and Other Notices
Since only software and hardware should be used which is under a free license, there should be no legal problems in this area. Concerning copyrights and patents there are no problems for the time being, because there is no commercial interest in this project. A release with commercial use is not planned in the near future.

### 3.12 Applicable Standards
During the implementation of the project, the URL standard RFC-1738 should be followed.

## 4. Supporting Information
This project is an assignment of the following students at the DHBW Karlsruhe:
Felix Hirschel,
Lars Hudalla,
Bastian shepherd,
Fabian Schwickert.
This application may not meet any legal requirements and therefore may not be used commercially or otherwise publicly. This project is only a purely pedagogical exercise. The content of this project is intellectual property of the above mentioned persons and may not be used or copied without their permission.
No liability is assumed for any commercial use by third parties.
