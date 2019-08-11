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
nohup java -jar -server target/spring-cloud-study-empty-0.0.1-SNAPSHOT.jar
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