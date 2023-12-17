pipeline {
    agent any
    stages {
        stage('Clean & Build'){
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Docker Build'){
            steps{
                sh 'docker compose build'
            }
        }

        stage('Docker Run'){
            steps{
                withCredentials(bindings: [file(credentialsId: 'RESOURCE_POC_ENV', variable: 'RESOURCE_POC_ENV_FILE')]){
                    sh 'chmod -R 777 .'
                    sh 'cp \$RESOURCE_POC_ENV_FILE .env'
                    sh 'docker compose --env-file $RESOURCE_POC_ENV_FILE up --force-recreate -d'
                    sh 'docker image prune -f'
                }
            }
        }

        stage('Docker Hub Login'){
            steps{
                withCredentials(bindings: [usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASSWORD')]){
                    sh 'docker login -u="$DOCKERHUB_USER" -p="$DOCKERHUB_PASSWORD"'
                }
            }
        }

        stage('Push to Docker Hub'){
            steps{
                sh 'docker push fabioqmarsiaj/spring-docker-jenkins-poc-app'
            }
        }
    }
}