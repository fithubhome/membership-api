pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Build the project using Maven
                withMaven(maven: 'maven3') {
                    sh "mvn clean package"
                }
            }
        }
        stage('Test') {
            steps {
                // Run tests using Maven
                withMaven(maven: 'maven3') {
                    sh "mvn test"
                }
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the application
                sh "java -jar /var/jenkins_home/workspace/membership-api_main/target/memebership-api-1.0-SNAPSHOT.jar &"
            }
        }
    }

    post {
        always {
            // Clean up after execution
            cleanWs()
        }
    }
}
