pipeline {

    agent any


    stages {
        stage('Checkout') {
            steps {
                // Check out your source code from your version control system (e.g., Git)
                checkout scm
            }
        }
        stage('Git') {
            steps {
                echo 'Getting project from Git'
                git branch: 'Nader',
                    url: 'https://github.com/belhassen1-jpg/DevOpsProject.git'
            }
        }
        stage('ff') {
            steps {
                // Check out your source code from your version control system (e.g., Git)
                echo('ffffffffffff')
            }
        }
        stage('MVN clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('MVN compile') {
            steps {
                sh 'mvn compile'
            }
        }
      //stage('SonarQube Analysis') {
        //    steps {
          //      withSonarQubeEnv('SonarQubeServer') {
            //        script {
              //          sh 'mvn sonar:sonar'
                //    }
                //}
            //}
        //}
        stage('MVN NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
        stage('Building Docker image') {
            steps {
                // Étape du build de l'image docker de l'application spring boot
                script {
                    // Generating image from Dockerfile
                    sh  'docker build -t nader2112/kaddem-2.1.jar .'
                }
            }
        }
  
        stage('Deploying Docker image') {
    steps {
        // Log in to Docker registry using credentials
        withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDENTIALS_USR', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
            sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
            // Push Docker image
           // sh 'docker push nader/kaddem-1.0.jar'
           sh 'docker push nader2112/kaddem-2.1.jar'
 
          
        }
    }
}
    stage('Docker compose') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d --build'
            }
        }
      
    }
}

