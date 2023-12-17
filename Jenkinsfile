pipeline {
    agent any
    stages {
        stage('Clean & Build'){
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Copy secret file to workspace'){
            steps{
                sh 'chmod -R 777 .'
                sh 'cp \$RESOURCE_POC_ENV_FILE /var/lib/jenkins/workspace/resource-poc/'
            }
        }

        stage('Docker Build'){
            steps{
                sh 'docker compose build -t fabioqmarsiaj/spring-docker-jenkins-poc .'
            }
        }

        stage('Docker Run'){
            steps{
                withCredentials(bindings: [file(credentialsId: 'RESOURCE_POC_ENV', variable: 'RESOURCE_POC_ENV_FILE')]){
                    sh 'docker compose --env-file $RESOURCE_POC_ENV_FILE up --force-recreate -d'
                    sh 'docker image prune -f'
                }
            }
        }

        stage('Docker Hub Login'){
            steps{
                sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Push to Docker Hub'){
            steps{
                sh 'docker push fabioqmarsiaj/spring-docker-jenkins-poc'
            }
        }
    }
}