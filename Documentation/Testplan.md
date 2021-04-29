# BFFL URLShortener – Master Test plan
## Version <1.0>

## Table of Contents
- [Test plan](#test-plan)
    - [1. Introduction](#1-introduction)
        - [1.1 Purpose](#11-purpose)
        - [1.2 Scope](#12-scope)
        - [1.3 Intended Audience](#13-intended-audience)
        - [1.4 Document Terminology and Acronyms](#14-document-terminology-and-acronyms)
        - [1.5  References](#15--references)
    - [2. Evaluation Mission and Test Motivation](#2-evaluation-mission-and-test-motivation)
        - [2.1 Background](#21-background)
        - [2.2 Evaluation Mission](#22-evaluation-mission)
        - [2.3 Test Motivators](#23-test-motivators)
    - [3. Target Test Items](#3-target-test-items)
    - [4. Outline of Planned Tests](#4-outline-of-planned-tests)
        - [4.1 Outline of Test Inclusions](#41-outline-of-test-inclusions)
        - [4.2 Outline of Other Candidates for Potential Inclusion](#42-outline-of-other-candidates-for-potential-inclusion)
        - [4.3 Outline of Test Exclusions](#43-outline-of-test-exclusions)
    - [5. Test Approach](#5-test-approach)
        - [5.1 Testing Techniques and Types](#51-testing-techniques-and-types)
            - [5.1.1 Unit Testing](#511-unit-testing)
            - [5.1.2 User Interface Testing](#512-user-interface-testing)
            - [5.1.3 Integration Testing (API Testing)](#513-integration-testing-api-testing)
            - [5.1.4 Exploratory Testing](#514-exploratory-testing)
    - [6. Entry and Exit Criteria](#6-entry-and-exit-criteria)
        - [6.1 Test Plan](#61-test-plan)
            - [6.1.1 Test Plan Entry Criteria](#611-test-plan-entry-criteria)
            - [6.1.2 Test Plan Exit Criteria](#612-test-plan-exit-criteria)
    - [7. Deliverables](#7-deliverables)
        - [7.1 Test Evaluation Summaries](#71-test-evaluation-summaries)
        - [7.2 Reporting on Test Coverage](#72-reporting-on-test-coverage)
        - [7.3 Perceived Quality Reports](#73-perceived-quality-reports)
        - [7.4 Incident Logs and Change Requests](#74-incident-logs-and-change-requests)
        - [7.5 Smoke Test Suite and Supporting Test Scripts](#75-smoke-test-suite-and-supporting-test-scripts)
    - [8. Testing Workflow](#8-testing-workflow)
    - [9. Environmental Needs](#9-environmental-needs)
        - [9.1 Base System Hardware](#91-base-system-hardware)
        - [9.2 Base Software Elements in the Test Environment](#92-base-software-elements-in-the-test-environment)
        - [9.3 Productivity and Support Tools](#93-productivity-and-support-tools)
    - [10. Responsibilities, Staffing, and Training Needs](#10-responsibilities-staffing-and-training-needs)
        - [10.1 People and Roles](#101-people-and-roles)
        - [10.2 Staffing and Training Needs](#102-staffing-and-training-needs)
    - [11. Iteration Milestones](#11-iteration-milestones)
    - [12. Risks, Dependencies, Assumptions, and Constraints](#12-risks-dependencies-assumptions-and-constraints)
    - [13. Management Process and Procedures](#13-management-process-and-procedures)

## 1. Introduction

### 1.1 Purpose

The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for a given iteration. It describes the approach to testing the software.
This Test Plan for BFFL URLShortener supports the following objectives:

- Identifies the items that should be targeted by the tests.
- Identifies the motivation for and ideas behind the test areas to be covered.
- Outlines the testing approach that will be used.
- Identifies the required resources and provides an estimate of the test efforts.
- Lists the test-deliverables of the project.

### 1.2 Scope

This document describes the procedure and the type of testing in the BFFL project. For the BFFL project, the following types of testing are used:

- Unit tests
- Integration tests
- UI tests
- Explorative tests

Any performance, security and stress testing will be deliberately avoided, as the BFFL project is not at a stage where attention can already be paid to such things.
Of course, security is still ensured by mature technology. For the time being, the focus of the tests should be on functionality.

### 1.3 Intended Audience

This document is mainly addressed to the team-internal units that are responsible for testing.
In addition, this document is intended to provide orientation in the development and testing process for all developers in the team.

### 1.4 Document Terminology and Acronyms

| Abbr | Abbreviation                        |
|------|-------------------------------------|
| API  | Application Programmable Interface  |
| AWS  | Amazon Web Services                 |
| BE   | Backend                             |
| FE   | Frontend                            |
| IAM  | Identity- and Access-Management     |
| n/a  | not applicable                      |
| SAD  | Software Architecture Document      |
| SRS  | Software Requirements Specification |
| UI   | User Interface                      |

### 1.5  References

| Title                                                                   | Date       | Publishing organization   |
| ------------------------------------------------------------------------|:----------:| ------------------------- |
| [Blog](https://bffl612917651.wordpress.com)                             | Apr. 2021  | BFFL                      |
| [GitHub Repository](https://github.com/Krayaty/bffl)                    | Apr. 2021  | BFFL                      |
| [Test Plan](./TestPlan.md)                                              | Apr. 2021  | BFFL                      |
| [SRS](./SRS.md)                                                         | Apr. 2021  | BFFL                      |
| [SAD](./SAD.md)                                                         | Apr. 2021  | BFFL                      |

## 2. Evaluation Mission and Test Motivation

### 2.1 Background

Functionality testing is an important and indispensable part of the product development process. By testing in different ways and with different tools, largely any malfunction of a product can be detected and then fixed. If you do not carry out sufficient testing, the responsible parties can be subject to heavy penalties if users are harmed.
The BFFL project is to create a URLShortener as a web application with Angular in FE (Frontend) and Maven in BE (Backend).
In addition, IAM (Identity- and Access-Management) will be implemented with a Keycloak instance.
For more information see [SRS](./SRS.md), [SAD](./SAD.md) and [Documentation](./)The infrastructure for this is rented from AWS (Amazon Web Services).

### 2.2 Evaluation Mission

In the testing phase, it is important to find all security-related and all functionality-critical bugs and errors.
In addition, a large part (>90%) of the less serious functionality bugs should be found.

### 2.3 Test Motivators

At this point in the development, testing should primarily ensure the functionality of the application and prevent undesired functionality from being retrievable or missing features.

## 3. Target Test Items

- Angular Frontend
- Maven Backend (only Integration-Tests)

## 4. Outline of Planned Tests

### 4.1 Outline of Test Inclusions

*Angular Frontend*:

- UI testing of Components (view, interaction, ...)
- Unit testing
- Integration testing (BE-Calls)

*Maven Backend*:

- Integration testing (DB-Calls)

The test code is not tested and therefore does not count into the test coverage.

### 4.2 Outline of Other Candidates for Potential Inclusion

*Keycloak*:

Since Keycloak is a widely used, mature and well-documented third-party software, there is no need to test the Keycloak instance.

### 4.3 Outline of Test Exclusions

The time frame of the project does not allow to cover the following test areas:

- Stress tests
- Load/performance tests
- Security tests

## 5. Test Approach

### 5.1 Testing Techniques and Types

#### 5.1.1 Unit Testing

Unit testing ensures, that the tested sourcecode works as expected. Therefore small parts of the sourcecode are tested independently.

|                       | Description                                                         |
|-----------------------|---------------------------------------------------------------------|
|Technique Objective    | Ensure that the implemented code works as expected                  |
|Technique              | Implement test methods using Jasmine and Karma.js (Frontend)        |
|Oracles                | Test execution logs results to the command line, in Pipeline and Code coverage tool |
|Required Tools         | Angular (up-to-date, needs to support Jasmine and Karma.js          |
|Success Criteria       | All tests pass. Test coverage > 10%. Pipeline is able to test FE    |
|Special Considerations | -                                                                   |

#### 5.1.2 User Interface Testing

By UI testing the application is tested from the perspective of the user. The goal of UI testing is to ensure that the UI behaves as expected.

|                       | Description                                                          |
|-----------------------|----------------------------------------------------------------------|
|Technique Objective    | Ensure that user interactions with FE and the view work properly     |
|Technique              | Converting Cucumber .feature-files (see [feature-files](./Features/)) into UI tests with Angular |
|Oracles                | Since UI tests are included in the unit tests with Angular, the same applies as in [5.1.1](#511-user-interface-testing) |
|Required Tools         | Since UI tests are included in the unit tests with Angular, the same applies as in [5.1.1](#511-user-interface-testing) |
|Success Criteria       | All UI tests pass. Pipeline is able to test FE                       |
|Special Considerations | -                                                                    |

#### 5.1.3 Integration Testing (API Testing)

Api Testing is part of integration testing. Integration tests test multiple modules of an application together. The main goal of Api testing is to ensure, that the provided Apis of the Backend behave as expected.

|                       | Description                                                          |
|-----------------------|----------------------------------------------------------------------|
|Technique Objective    | Test the provided Apis with (???) and the FEs BE-calls               |
|Technique              | Pending decision of tool                                             |
|Oracles                | Test execution logs results to the command line, in Pipeline and Code coverage tool |
|Required Tools         | JUnit, Cucumber, (???)                                               |
|Success Criteria       | All tests pass. Code coverage > 50%. Pipeline is able to test BE     |
|Special Considerations | -                                                                    |

#### 5.1.4 Exploratory Testing

Exploratory testing here means that a person or a computer is given the task of cracking or breaking the system.

|                       | Description                                                          |
|-----------------------|----------------------------------------------------------------------|
|Technique Objective    | Testing the entire application through hacking attempts              |
|Technique              | In a limited period of time, a person or a computer should try to destroy or hack the system. |
|Oracles                | By examining the patterns of attacks and approaches, adjustments and fixes can be made. |
|Required Tools         | People outside the development team, team members, computers, scripts, ... |
|Success Criteria       | In a limited period of time, the tester does not manage to hack or destroy the application. |
|Special Considerations | -                                                                    |


## 6. Entry and Exit Criteria

### 6.1 Test Plan

#### 6.1.1 Test Plan Entry Criteria

When a code pipeline is run during deployment, the tests described above for FE and BE (except for the exploratory tests) should be executed automatically.

#### 6.1.2 Test Plan Exit Criteria

The tests are the last hurdle before the actual deployment. If the tests fail, no deployment takes place and adjustments have to be made.

## 7. Deliverables

## 7.1 Test Evaluation Summaries

The tests in FE and BE produce evaluation summaries. Thus, each time a pipeline is deployed, these status documents are created.

## 7.2 Reporting on Test Coverage

For reporting our test coverage we use (???).

[Here]() the test coverage can be viewed.

## 7.3 Perceived Quality Reports

The code quality tool for the FE is TS Lint which is provided by Angular.

## 7.4 Incident Logs and Change Requests

The BFFL project uses an agile process model and therefore keeps a [Kanbanboard](https://dhbw-karlsruhe.myjetbrains.com/youtrack/agiles/108-85/current) on which the tasks of a sprint can be seen.
Merge-Requests and the actual code can be found in [GitHub](https://github.com/Krayaty/bffl).

## 7.5 Smoke Test Suite and Supporting Test Scripts

The project BFFL uses automated test execution in a Code Pipeline in AWS. 

## 8. Testing Workflow

1) Local testing in the IDE
2) Commit and Push triggers build and test in the Code Pipeline
3) Before the automated deployment the build and test stages are executed

## 9. Environmental Needs

### 9.1 Base System Hardware

The following table sets forth the system resources for the test effort presented in this Test Plan.

| Resource              | Quantity | Name and Type                |
|-----------------------|:--------:|------------------------------|
| Code Pipeline         |    1     | AWS Codepipeline             |
| local test machine    |    1     | Computers with a web browser |

### 9.2 Base Software Elements in the Test Environment

The following base software elements are required in the test environment for this Test Plan.

| Software Element Name |  Type and Other Notes                        |
|-----------------------|----------------------------------------------|
| IDE                   | IntelliJ and WebStorm                        |
| Angular               | Built in Jasmine and Karma.js                |
| JUnit                 | Unit testing library                         |
| Cucumber              | human readable test definitions              |

### 9.3 Productivity and Support Tools

The following tools will be employed to support the test process for this Test Plan.

| Tool Category or Type | Tool Brand Name                              |
|-----------------------|----------------------------------------------|
| Repository            | [github.com](https://github.com/Krayaty/bffl)|
| Test Coverage Monitor | [(???))]()                                   |
| Pipeline Service      | [AWS Codepipeline](aws codepipeline cdk)     |

## 10. Responsibilities, Staffing, and Training Needs

### 10.1 People and Roles

| Role          | Person Assigned | Specific Responsibilities or Comments |
|---------------|:---------------:|---------------------------------------|
| Test Manager  | Felix           | Provides management oversight.        |
| Test Designer | whole team      | Defines the technical approach to the implementation of the test effort. |
| Test System Administrator | Felix | Ensures test environment and assets are managed and maintained. |

### 10.2 Staffing and Training Needs

n/a

## 11. Iteration Milestones

The test coverage should be at least 20%. In addition, automatic testing of the application should be implemented before deployment.

## 12. Risks, Dependencies, Assumptions, and Constraints

| Risk | Mitigation Strategy | Contingency (Risk is realized) |
|------|---------------------|--------------------------------|
| Too much focus on tests and too little on functions | Test only important and complex functions | write clean code |
| False certainty through false tests | The one who writes the functionality should also write the tests | take your time |
| Different interpretations of a functionality | write tests first | Delimit functionality unambiguously through tests |

## 13. Management Process and Procedures

n/a
