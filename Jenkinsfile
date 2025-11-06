pipeline {
    agent any

    tools {
        maven 'maven-3'
        jdk 'jdk-11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -B clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Run Application') {
            steps {
                sh 'pkill -f "java.*testeAPI"'
                sh '''
                    echo "Iniciando a API Spring Boot..."
                    # O nohup permite que o processo continue após o Jenkins terminar o job
                    nohup java -jar target/testeAPI-1.0-SNAPSHOT.jar > app.log 2>&1 &
                    echo "API iniciada. Verifique o log em app.log"
                '''
            }
        }
    }
}