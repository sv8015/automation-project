pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'])
        choice(name: 'HEADLESS', choices: ['true', 'false'])
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                credentialsId: 'github-creds',
                url: 'https://github.com/sv8015/automation-project.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh "mvn clean test -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS}"
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
