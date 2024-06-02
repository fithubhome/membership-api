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
                withMaven(maven: 'maven3') {
                    // Deploy the application
                    sh "nohup java -jar /var/jenkins_home/workspace/membership-api_main/target/memebership-api-1.0-SNAPSHOT.jar &"
                }
            }
        }
    }


}
