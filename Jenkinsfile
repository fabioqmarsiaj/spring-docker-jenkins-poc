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
                sh 'docker compose build'
            }
        }
    }
}