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
                // 1. Mata o processo Java (Taskkill continua o mais simples)
                bat 'taskkill /f /im java.exe || exit 0'

                // 2. INICIA A API USANDO POWERSHELL PARA GARANTIR BACKGROUND
                powershell "Start-Process java -ArgumentList \"-jar target\\testeAPI-1.0-SNAPSHOT.jar --server.port=8081\" -NoNewWindow"
            }
        }
    }
}