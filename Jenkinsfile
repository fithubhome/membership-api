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
                withMaven(maven: 'maven3'){
                  sh "nohup java -jar target/memebership-api-1.0-SNAPSHOT.jar &"
                }
            }
        }

         stage('Run JAR') {
                    steps {
                        sh 'java -jar /var/jenkins_home/workspace/membership-api_main/target/memebership-api-1.0-SNAPSHOT.jar'
                    }
                }

//         stage('Start JAR with nohup') {
//             steps {
//                 sh """
//                     sshpass -p '1Testtest' ssh root@209.38.218.71 'cd /var/jenkins_home/workspace/membership-api_main/target && nohup java -jar memebership-api-1.0-SNAPSHOT.jar &'
//                 """
//             }
//         }
    }
}
