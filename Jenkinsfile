pipeline {
    agent any

    stages {
        stage('Install sshpass') {
            steps {
                script {
                    // Check if sshpass is installed, and install it if it is not
                    if (sh(script: 'command -v sshpass', returnStatus: true) != 0) {
                        sh 'sudo apt-get update && sudo apt-get install -y sshpass'
                    }
                }
            }
        }
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
                withMaven(maven: 'maven3'){
                  sh "nohup java -jar target/memebership-api-1.0-SNAPSHOT.jar &"
                }
            }
        }
        stage('Deploy JAR via SCP') {
            steps {
                sh "sshpass -p '1Testtest' scp 'target/memebership-api-1.0-SNAPSHOT.jar' 'root@209.38.218.71:/app'"
            }
        }
        stage('Start JAR with nohup') {
            steps {
                sh "sshpass -p '1Testtest' ssh 'root@209.38.218.71' 'cd /app && nohup java -jar memebership-api-1.0-SNAPSHOT.jar &'"
            }
        }
    }
}
