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
                sh "sshpass -p '1Testtest' scp target/membership-api-1.0-SNAPSHOT.jar root@209.38.218.71:/app"
            }
        }
        stage('Start Application') {
            steps {
                sh """
                sshpass -p '1Testtest' ssh 'root@209.38.218.71' '
                cd /app &&
                nohup java -jar membership-api-1.0-SNAPSHOT.jar > membership-api.log 2>&1 &'
                """
            }
        }
    }
}
