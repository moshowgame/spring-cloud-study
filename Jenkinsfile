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
        sh '''cd spring-cloud-study-empty
mvn clean package
cd target
java -jar spring-cloud-study-empty-0.0.1-SNAPSHOP.jar'''
      }
    }
  }
}