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
                sh 'docker compose up --force-recreate -d --build'
                sh 'docker image prune -f'
            }
        }
    }
}