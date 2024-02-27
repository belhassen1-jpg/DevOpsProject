pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                echo 'Récupération du code depuis ma branche GitHub...';
                git branch: 'aziza', url: 'https://github.com/belhassen1-jpg/DevOpsProject.git'
            }
        }

        stage('MVN Clean & Install') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('MVN Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Mockito Tests') {
            steps {
                sh 'mvn test'  // Ou une autre commande si vous avez des tests spécifiques à exécuter
            }
        }

        stage('SonarQube Analysis') {
            steps {
                 sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

        stage('Nexus Jar') {
            steps {
                    sh 'mvn deploy -DskipTests'
                }
        }

   stage('Docker Build') {
    steps {

           sh 'docker build -t  aziza2/kaddem:1.0.0 .'


    }
   }
   stage('Deploy image') {
    steps {
        script {
            def dockerUsername = 'aziza2'
            def dockerPassword = 'Zayza234000'  // Remplacez par votre mot de passe réel

            sh "echo $dockerPassword | docker login -u $dockerUsername --password-stdin"
            sh 'docker push aziza2/kaddem:1.0.0'
        }
    }
    }
     stage('Docker compose') {
    steps {

           sh 'docker compose up -d'


    }
   }
       stage('Grafana Prometheus') {
    steps {

          sh '''
          docker start prometheus
          docker start grafana
          '''


    }
   }


    }

    post {
        success {
            // This will execute only if the whole pipeline succeeds
            mail to: 'aziza.chouchane@esprit.tn',
                 subject: 'Pipeline Success',
                 body: 'The pipeline executed successfully!'
        }
        // Optionally, you can handle other conditions like failure
        failure {
            mail to: 'aziza.chouchane@esprit.tn',
                 subject: 'Pipeline Failure',
                 body: 'The pipeline failed. Please check the Jenkins logs for more details.'
        }
    }



      }
}