pipeline {
    agent any

    node('agent1'){
        stages {
            stage('Clean & Build'){
                steps{
                    sh './gradlew clean build'
                }
            }
        }
    }
}