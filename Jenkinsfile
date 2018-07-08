pipeline {
  agent any
  stages {
    stage('SCM checkout') {
      steps {
        git(url: 'https://github.com/sakshi151990/Spring-todo-app.git', branch: 'development', poll: true, credentialsId: 'Gituser')
      }
    }
  }
}