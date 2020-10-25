# FlightManagement

The project is a microservice that has the responsibility of retrieving all flight information through an external service and storing it in a Redis database, so that we can have a cache system to manage all flight information and use it in our other microservices.

# Implementation

The project contains swagger to explain api as : /swagger-ui.html

spring security in-memory is included with user,password and roles as following:

user: akram, password:password, roles USER,ADMIN
user: test, password:test, roles USER

## Maven Profiles
mock-client : to mock the feign client of the external Service call

In order of having real call set Feign client url in the property file
Feign endpont suppose to be like "/v1/flight-information-tail/{tailNumber}"

# Building and Running

## First build the backend:

mvn clean package

## Build containers and run:
docker-compose build

docker-compose up

