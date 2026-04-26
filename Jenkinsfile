pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds',
                    url: 'https://github.com/sv8015/automation-project.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Build started...'
            }
        }
    }
}
