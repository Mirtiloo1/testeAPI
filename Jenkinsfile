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
                bat 'mvn -B clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
        
        stage('Run Application') {
            steps {
                bat 'taskkill /f /im java.exe || exit 0'
                bat 'cmd /c start /B java -jar target\\testeAPI-1.0-SNAPSHOT.jar --server.port=8081'
            }
        }
    }
}