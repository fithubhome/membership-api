pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                withMaven(maven: 'maven3') {
                    sh "mvn clean package"
                }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven: 'maven3') {
                    sh "mvn test"
                }
            }
        }
        stage('Deploy') {
            steps {
                sh "java -jar target/memebership-api-1.0-SNAPSHOT.jar"
            }
        }
    }
    post {
        always {
            echo 'This is a message for always scenario'
        }
        success {
            echo 'This is a message for success scenario'
        }
        failure {
            echo 'This is a message for failure scenario'
        }
    }
}