BFFL | Software Architecture Document
======
Version <1.0>
======

- [1. Introduction - Lars](#1-introduction)
  * [1.1 Purpose](#11-purpose)
  * [1.2 Scope](#12-scope)
  * [1.3 Definitions, Acronyms and Abbreviations](#13-definitions--acronyms-and-abbreviations)
  * [1.4 References](#14-references)
  * [1.5 Overview](#15-overview)
- [2. Architectural Representation - Basti](#2-overall-description)
- [3. Architectural Goals and Conststraints - Basti](#3-specific-requirements)
- [4. Use-Case View - Basti](#4-supporting-information)
- [5. Logical View - Fabi](#5-supporting-information)
- [6. Deployment View - Fabi](#6-supporting-information)
- [7. Data View](#7-supporting-information)

 
Software Architecture Document 
## 1.	Introduction Lars
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

[This section describes what software architecture is for the current system, and how it is represented. Of the Use-Case, Logical, Process, Deployment, and Implementation Views, it enumerates the views that are necessary, and for each view, explains what types of model elements it contains.]
## 3.	Architectural Goals and Constraints Basti
[This section describes the software requirements and objectives that have some significant impact on the architecture; for example, safety, security, privacy, use of an off-the-shelf product, portability, distribution, and reuse. It also captures the special constraints that may apply: design and implementation strategy, development tools, team structure, schedule, legacy code, and so on.]
Sicherheit durch Keycloak und eventuell FIDO2
Data Security mit Authentifizierung und build in AWS Hilfsmittel wie ausversehen DB-Löschung nicht erlauben
## 4.	Use-Case View Basti
The static requirement analysis of the BFFL webapp shows what the core requirements of the application are.
 
Figure 1: Static Requirement Analysis
The dynamic requirement analysis of the BFFL webapp concretises the static requirement analysis. It consists out of the documentation of the processes of the core requirements shown in the static requirement analysis. The following figures show three of the most important requirements.
 
Figure 2: Dynamic Requirement Analysis of “show Short-URLs”

 
Figure 3: Dynamic Requirement Analysis of “create a Short-URL”
 
Figure 4: Dynamic Requirement Analysis of “update Short-URLs”
5.	Logical View
The following figure shows the architecture of the BFFL webapp and gives information of central functionalities, attributes and dependencies of all major components.

## 6.	Deployment View
 
Figure 6: Digital Infrastructure Diagram
## 7.	Data View
 ![alt text](https://github.com/Krayaty/bffl/tree/Fabi/Documentation/Pictures/DB Schema.png?raw=true)
Figure 7: DB scheme
