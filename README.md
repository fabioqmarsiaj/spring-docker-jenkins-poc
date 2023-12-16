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

OBS: Your jenkins could be installed using JRE-11, if you configure an agent based on a image from java 21, you can run your java 21 project.

From [Jenkins Official](https://www.jenkins.io/doc/book/using/using-agents/):

`"The Jenkins controller is the original node in the Jenkins installation. The Jenkins controller administers the Jenkins agents and orchestrates their work, including scheduling jobs on agents and monitoring agents. Agents may be connected to the Jenkins controller using either local or cloud computers."`

Also an **_agent_** is either a bare metal machine or a container.


![alt text](src/main/resources/images/portainer.png)