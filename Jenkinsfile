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
                script {
                    // Stop previous instance
                    sh "pkill -f 'java -jar target/memebership-api-1.0-SNAPSHOT.jar' || true"

                    // Deploy new instance
                    sh "nohup java -jar target/memebership-api-1.0-SNAPSHOT.jar &"
                }
            }
        }
    }
}
