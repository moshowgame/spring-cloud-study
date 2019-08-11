pipeline {
  agent any
  stages {
    stage('start2build') {
      steps {
        echo 'start to build'
      }
    }
    stage('maven:build') {
      steps {
        sh '''cd spring-cloud-study-empty
mvn clean package
'''
      }
    }
    stage('maven') {
      steps {
        sh '''/home/moshow/Development/Workspace/stop.sh
/home/moshow/Development/Workspace/start.sh
'''
      }
    }
    stage('endofbuild') {
      steps {
        echo 'build success'
      }
    }
  }
}