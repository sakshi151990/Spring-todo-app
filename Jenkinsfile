pipeline {
   agent  {
  label 'slavedocker'
  }
   tools {
    jdk 'java'
    maven 'maven'
   }
   stages {
    stage ('checkOut') {
      steps{
        git branch: 'Jenkinsbranch', credentialsId: 'jenkinsuser', url: 'https://github.com/sakshi151990/Spring-todo-app.git'
      }
    }
    stage ('Build') {
      steps{
        echo "Build"
        sh 'mvn clean compile -f pom.xml'
      }
    }
    stage ('Test') {
      steps {
        echo "Testing"
        sh 'mvn -Dmaven.test.failure.ignore=true test -f pom.xml' 
        }
       post {
        success {
                junit 'target/surefire-reports/**/*.xml' 
        }
       }
    }
    stage ('Package') {
      steps {
        echo "Packaging"
        sh 'mvn install -f pom.xml' 
        }  
    }    
     stage ('Build Image') {
      steps {
        echo "Build Image"
        sh '''docker --version
             docker build -t sampleapp_poc ${WORKSPACE} --build-arg APPWORKSPACE=${WORKSPACE}
             docker images'''
      }
     }
      stage ("Push to DockerHub"){ 
          steps {
              withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
          sh '''
          docker tag sampleapp_POC:latest sakshikansal/sampleapp_POC:latest
          docker push sakshikansal/sampleapp_POC:latest'''
          
               }
          } 

      } 
         
         }
      }
   

