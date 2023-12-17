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
                withCredentials(bindings: [file(credentialsId: 'RESOURCE_POC_ENV', variable: 'RESOURCE_POC_ENV_FILE')]){
                    sh 'chmod -R 777 .'
                    sh 'cp \$RESOURCE_POC_ENV_FILE .env'
                    sh 'docker compose --env-file $RESOURCE_POC_ENV_FILE up --force-recreate -d --build'
                    sh 'docker image prune -f'
                }
            }
        }
    }
}