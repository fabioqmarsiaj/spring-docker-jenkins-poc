pipeline {
    agent any
    stages {
        stage('Clean & Build'){
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Docker Build & Up'){
            steps{
                withCredentials(bindings: [file(credentialsId: 'resource-poc-env-file', variable: 'resource-poc-env-file')]){
                    sh 'docker compose --env-file $resource-poc-env-file up --force-recreate -d --build'
                    sh 'docker image prune -f'
                }
            }
        }
    }
}