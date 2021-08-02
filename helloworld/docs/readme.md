# Spring boot application best practices

## Introduction

    This is a sample project starting from a simple hello world and to be iteratively expanded to deliver multiple capabilities using industry best practices.

## Stages

### HelloWorld Spring boot Application

    Springboot provides a very comfortable starting point to build complex applications with microservices patterns. 
    Springboot also was one of the earliest frameworks to provide this and hence has a strong acceptance and comfort in the Java technology community. 

    There are other frameworks that have evovled and seem very promising. This set of codelabs takes an opinionated path of building microservices to scale with various expectations of operational excellence, architecture simplicity, etc. 

### HelloWorld Application with Controller

    Springboot provides a HTTP handler abstraction called controllers that provide strong capabilities to recieve and respond to clients over HTTP. 

#### Without test cases

    We create a simple HelloWorldController, that responds back with a simple 
    "Hello World" message. 

    The request pattern for this is a GET /{server}:{port}/v0.2/

#### With test cases

### Application Testing with K6

    K6 is a very modern testing framework that focuses on making testing easy for developers and make it developer friendly. 
    It uses a relatively easy javascript based DSL to define various aspects of creating load testing.

    Making perf testing simple, focuses on allowing consitent mechanism for the tests to be run on Local Dev environment, Integrated test environment or a Pre Prod Performance test environment. 

    At this point this project creates a simple script.js in a 
    /test/**/perf directory to create a perf test. 

    Create fake objects with faker.js and use that to create realistic data for testing. 
    
    TODO: As of July, 2021, K6 has a influxdb based integration to push the perf test results into grafana. So either set this up, or build a prometheus integration for K6 and opensource it. 

#### setup k6 to visualize perf tests in grafana

     (Currently only through influxdb, experimental statsd_exporter for prometheus.)

### Application with Prometheus

    DONE: Added micormeter and spring boot actuator to generate the metrics.  
    DONE: Added the "management.endpoints.web.exposure.include=health,info,prometheus" To tell springboot to create the management endpoints and expose them as a http/web exposed urls. 
    we could also use JMX.exposure to enable these metrics to be accessible over JMX. 
    The various actuator urls are available on http://localhost:8080/actuator.
    TODO: Need to see how the actuator urls can be on a port different than the application/api port. 
    TODO: Need to make the actuator urls visible over http & JMX and connect some thing that reads this data from JMX.
    TODO: Need to make actuator apis use authentication (simplehttp, LDAP, OAuth.)
    TODO: Adding custom metrics to the actuator prometheus metrics with examples for Gauge, 
    TODO: Create prometheus metrics for DB, kafka, aerospike, etc. 
    TODO: Extend the default actuator endpoints 
    TODO: How to ensure that in prometheus targets, when we click on the target it works from the host machine also. 

### Settig up observability dashboard

    For every springboot microservice project, create some standard dashboard jsons and commit them to the config directory. When the developer brings up the application with docker compose up, the standard dashboards should show up on grafana with out any work from the developer. 

#### Create a dashboard for aggregates

    In the current state of the dashboards the teams are using, the tactical metrics are available, but it would be good to use a design process to define the dashboards. 

    For example, An aggregates dahsboard that summarises busines metrics, technical metrics are summarized. For example, total hits this month or a day or some thing like that. Total revenue booked, etc. 

    There could be other dashboards for business and technical metrics as part of the folder to be reviewed or looked at as needed. 

#### Create a dashboard from spring / http metrics

#### Create a dashboard from system/resource utilization metrics

#### Create standard dashboards and store them in config

#### Use a diagraming plugin in grafana to create a servicepath

#### Using faker for creating test data
    Tried using faker as part of k6, but this was very cumbersome. 
    There is no direct way because k6 is not based on node and there is an article online from about 2019 which tries to setup it up with a node and yarn based solution.

    But the problem with this is that the tests are no longer directly run from k6 but there is a test driver that runs the k6 tests. Need to evaluate if we want to get to that kind of model. 

    If there are multiple tests, we still might need a test driver for all these tests. So it might eventually be a good idea, but we should evaluate alternatives. 

## Create a GreetingController

    Created a simple greeting Controller tha takes are request for a greeeting. This is simple example that shows how a POST can be setup with an opiniated view of where and how to setup DTOs, etc.

### Store the object in a persistent store

#### What are the best practices to create IDs in a distributed manner.

    Would it make sense to use some thing like snowflak for primary keys and then
    let the database where the object is persisted created a db_specific_id which
    could be more user readable or follow some pattern like sequentially incrementing. 

    Create a repository to store the greeting request, post it on kafka.

### Build some business rules on accepting the greeting request

    If the name is sent earlier, change the name. 
    Setup a throttling if the name is sent more than a frequency. 
    Create a business report of requests received with a distribution of first character of the name.
    Create a business report of requests received with a distribution of the locale. 
    Transfrom the Greeting to enhance a metric by adding a country name based on the locale, so that we can plot a realtime global map. 

### Leverage TestContainers to enable seemless integration testing


### Setup kafka and ensure it is accessible

    As a developer, kafka is a key architectural component. So for a microservice
    the developer will be able to create a kakfa docker instance. The docker compose
    is setup to create this infra seemlessly. 

    A config tester validates that all the docker container (app, promethus, 
    grafana, zookeeper, kafka) are all running. 

    For the microservie, the kafka topics used by the microservices are all configured 
    in the application.properties/yml to ensure simplification of the startup. 

    This also ensures that for different environments, the applciation properties 
    can be consistent and deterministic. This should also stop ops teams creating 
    topics directly in production environments. 

    Also from a toolset perspective, vscode has an amazing kafka plugin, that allows 
    you to connect to the kafka broker and explore all the topics on the kafka cluster.
    With this plugin, it is also very easy to create producers and consumers that
    help push some test objects and consume them. 
    Pushing objects is simply creating a json object and some syntactic sugar. What 
    makes this even better is the fact that it integrates with fakerjs and provides
    ability to produce multiple objects with fake details, there by simplifying 
    developer and test confidence. 

#### Toolset - use kafka client plugin for vscode

### Add lombok to the dependencies and editor (vscode)

### Create a model class and POST and GET apis

    What is the difference between MapStruct and ModelMapper


### Application API documentation with swagger

### Security best practices for rest apis

    https://dzone.com/articles/security-best-practices-for-rest-apis

### Application Deployment on Docker

### Application deployment using buildpacks.io

### Application deployment on Kubernetes

### Application with controller taking an input (name)

### Application with controller validations

### Application with multiple form inputs

### Application with multipart form submission
