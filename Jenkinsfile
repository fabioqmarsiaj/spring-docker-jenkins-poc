pipeline {
    agent { label 'agent1' }

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