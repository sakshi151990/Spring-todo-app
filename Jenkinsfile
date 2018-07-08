pipeline {
  agent any
  stages {
    stage('SCM checkout') {
      parallel {
        stage('SCM checkout') {
          steps {
            git(url: 'https://github.com/sakshi151990/Spring-todo-app.git', branch: 'development', poll: true, credentialsId: 'Gituser')
          }
        }
        stage('error') {
          steps {
            tool(name: 'MyMaven', type: 'Maven')
            tool(name: 'MyMaven', type: 'maven')
          }
        }
      }
    }
  }
}