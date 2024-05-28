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
}