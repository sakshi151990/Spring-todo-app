pipeline {
  agent {
    node {
      label 'master'
    }

  }
  stages {
    stage('SCM checkout') {
      parallel {
        stage('SCM checkout') {
          steps {
            git(url: 'https://github.com/sakshi151990/Spring-todo-app.git', branch: 'development', poll: true, credentialsId: 'Gituser')
          }
        }
        stage('') {
          steps {
            tool(name: 'MyMaven', type: 'maven')
          }
        }
      }
    }
  }
}