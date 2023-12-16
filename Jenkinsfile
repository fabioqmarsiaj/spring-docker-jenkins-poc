pipeline {
    agent any

    stages {
        stage('Clean & Build'){
            steps{
                sh './gradlew clean build'
            }
        }
    }
}