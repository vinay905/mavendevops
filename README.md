Overview
Java project using Maven

Prerequisites
List of prerequisites needed to run the project:

Docker installed and configured
Jenkins installed and configured
Maven installed and configured 
Eclipse installed and configured

Setup Instructions
using eclipse ide 
*select new->maven project 
![image](https://github.com/user-attachments/assets/61350b64-438d-4c6a-86cf-73b8a880d533)

*select simple maven project check
*fill details
![image](https://github.com/user-attachments/assets/d10a62ac-a432-428c-9802-69519dce6cf0)

*click finish
and after few moments maven project will be configured 

1. Clone the Repository
git clone https://github.com/vinay905/mavendevops.git using cli or Github Desktop
inside the maven project directory if you do not want to setup maven by yourself

dockerfile
FROM maven:3.5.3-jdk-8-alpine
COPY ./. /


3. Jenkins Pipeline Configuration
Configure the Jenkins pipeline (Jenkinsfile) to build and run the Docker image.

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

4. Build and Run Docker Image
Build and run your Docker image locally to ensure everything works:

docker build --no-cache -t my-image:1 -f ./Dockerfile .
docker run -it --rm my-image:1 /bin/sh


5. Integrate with Jenkins
*Create a Jenkins pipeline job and set the definition to pipeline script from SCM.
![image](https://github.com/user-attachments/assets/1c1c2c96-2a3b-404d-98c7-aa9cb4baf697)     ![image](https://github.com/user-attachments/assets/a59f48b9-a25f-49c3-b282-f8af8cb76870)


*choose scm to Git
*set repo url to: https://github.com/vinay905/mavendevops.git
*choose branch: ./master
*set credentials to: none (as it is public repo)
*in scriptpath keep Jenskinsfile as it is
![image](https://github.com/user-attachments/assets/9b3a6741-cecc-4fbb-94d3-2c47a3ee1b89)


*in general tab of the configure setting select POLL SCM and enter * * * * *
![image](https://github.com/user-attachments/assets/d9614487-d083-46ec-8d18-44e65888dba8)

6. Run Jenkins Pipeline
*Trigger the Jenkins pipeline to build and test your project:
*it will keep triggering the pipeline  

*Last step click Apply and then Save

Navigate to Dashboard and click the job name->build now.
*it will take some time , you can see progress
![image](https://github.com/user-attachments/assets/07ed6e38-afec-4b1a-b05a-1203f4043a23)
![image](https://github.com/user-attachments/assets/11a12351-2d0f-4625-924d-4279f5b3c804)

*at the end you will see success message. Means the jenkins pipeline ran successfully
![image](https://github.com/user-attachments/assets/79fdfd86-ad40-4a93-a1b3-1e8dad998ba7)

Run the configured pipeline job manually to see the result.

Troubleshooting
Common issues and their solutions:

*Ensure Docker permissions are correctly set for Jenkins.
*Check Dockerfile and Jenkins pipeline configuration for errors.
*install jenkins from docker cli from its documentation if error persists
