pipeline {
    agent { label 'agent1' }
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