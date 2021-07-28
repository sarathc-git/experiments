# Opinionated implementation of Event Driven Microservices

## Introduction

    This project is an opiniated effort to document best practices in building production quality, developer friendly, microservices with event driven systems.

    Over the past many years, I have been amazed at the power of event driven microservices. At Airtel payments bank we have adopted this architectural pattern to build very high scale infrastructrue, handling over a couple of 10s of Millions of transactions per day. 

    This journey has also been interesting in how the teams adopted this paradigm and progressed on this journey.

    This project is an effort to highlight the various decisions, challenges and learnings in building effective event driven microservices. At this point this project is based on JAVA and spring boot, but the intent is to build this for multiple languages and also bring in polyglot capabilities. 

## Goals

### Developer Experience

    A key metric for a technology leadership is how good the developer experience is. There is much to making developer experience great. 
    A great developer experience is based on Interview Experience, Onboarding Experience, Interal Tool set, Effective Developer enablement, Safety net through a Buddy, Warm acceptance by team.
    Apart from all these Physchological Safety and a Sincere Welcoming culture make for a great Developer Experience.

    Over the past couple of weeks, I have been focusing on one aspect. How do we ensure that a new developer can get into a team, check out code and play around with it. 

    Am working on an opiniated way to build this, with a goal that a developer should be able to check out code, find tests to run, undersatnd metrics that are critical on a dashboard that is ready to view. 

    A Developer A start with a team, gets some onboarding links including the repo to the code base. Is able to check out this code base, execute this on their developer machine (laptop). 
    When this is done, there is a bunch of tests that run, there is a grafana dashboard that provides a complete observability dashboard that visualized key business metrics, system metrics and a complete set of service paths the system serves to customers. 

### REST Best Practices

### Testing Best Practices

### Security practices

### Cloud native tool set for full lifecycle simplicity