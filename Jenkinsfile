pipeline {
  agent any
  stages {
    stage('error') {
      steps {
        echo 'build success'
      }
    }
    stage('maven') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}