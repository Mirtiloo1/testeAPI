pipeline {
    // Roda o pipeline no executor do Jenkins (sua máquina Windows)
    agent any
    
    tools {
        // Garante que o Maven e o Java (JDK) configurados em "Ferramenta de Configuração Global" sejam injetados.
        // Use os nomes EXATOS que você definiu (ex: 'maven-3' e 'jdk-11').
        maven 'maven-3' 
        jdk 'jdk-11' 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Clona o código do Git
            }
        }
        
        stage('Build & Test') {
            steps {
                // CORREÇÃO: Usando 'bat' em vez de 'sh' para rodar o Maven no Windows
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
                // CORREÇÃO: Usando 'taskkill' para matar o processo Java anterior (API)
                // O '|| exit 0' garante que a build não falhe se o processo não estiver rodando.
                bat 'taskkill /f /im java.exe || exit 0' 

                // CORREÇÃO: Inicia o JAR em um processo separado ('start /B') para que o Jenkins não fique esperando.
                // Usando 'cmd /c start' para garantir que o processo se separe do console do Jenkins.
                bat 'cmd /c start /B java -jar target\\testeAPI-1.0-SNAPSHOT.jar'
                
                // OPCIONAL: Esperar um pouco para a aplicação subir
                // bat 'timeout /t 5 /nobreak' 
            }
        }
    }
}