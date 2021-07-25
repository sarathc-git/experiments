# Spring boot application best practices

## Introduction

    This is a sample project starting from a simple hello world and to be iteratively expanded to deliver multiple capabilities using industry best practices.

## Stages

### HelloWorld Spring boot Application

### HelloWorld Application with Controller

#### Without test cases

#### With test cases

### Application Testing with K6

#### Setup k6 and run perf tests

#### setup k6 to visualize perf tests in grafana.

     (Currently only through influxdb, experimental statsd_exporter for prometheus.)

#### Using XXXX for creating test data

### Application with Prometheus

    Added micormeter and spring boot actuator to generate the metrics. 
    Added the "management.endpoints.web.exposure.include=health,info,prometheus" To tell springboot to create the management endpoints and expose them as a http/web exposed urls. 
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

#### Create standard dashboards and store them in config

### Application API documentation with swagger

### Application Deployment on Docker

### Application deployment using buildpacks.io

### Application deployment on Kubernetes

### Application with controller taking an input (name)

### Application with controller validations

### Application with multiple form inputs

### Application with multipart form submission
