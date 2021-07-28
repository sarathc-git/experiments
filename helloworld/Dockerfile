FROM maven:3.6.3-jdk-11 AS build
WORKDIR /home/app
COPY src /home/app/src
COPY config /home/app/config

COPY pom.xml /home/app 
RUN pwd
RUN mvn -f /home/app/pom.xml clean package 

# AT this point the helloworld docker image is ready and can be run.

# Create the App package
#
FROM openjdk:11
COPY --from=build /home/app/target/helloworld-0.0.1-SNAPSHOT.jar /usr/local/lib/helloworld.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/helloworld.jar"]

