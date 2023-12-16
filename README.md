# spring-docker-jenkins-poc

A POC Project that intends to run a spring project inside a java 21 docker container, exposing a port for the API.

### **Main Objectives:**
* Configure the Jenkins server on your machine;
* Understand the difference between Jenkins Controller & Agents;
* Configure an agent which is a container from ssh-agent:alpine-jdk21 to run our project pipeline;
* Set the Jenkinsfile to:
  * Run on the specify agent (It is important since the project runs on java 21);
  * Gradle Clean & Build;
  * Docker compose build:
    * Pass an .env file, register as a secret file on jenkins server;
  * Docker compose run