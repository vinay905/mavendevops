pipeline {
    agent any

    stages {  
        stage('Clone Repository') {
            steps {
                git 'https://github.com/vinay905/mavendevops.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build --no-cache -t my-image:1 -f ./Dockerfile ."
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    bat "docker run my-image:1 mvn test"
                    }
                }
            }
        
    }    
}
