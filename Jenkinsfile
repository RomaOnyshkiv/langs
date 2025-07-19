pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    stages {
        stage('Install Chrome Driver and Browser') {
            steps {
                sh '''
                    apt update
                    curl -O https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
                    apt install -y ./google-chrome-stable_current_amd64.deb
                    rm google-chrome-stable_current_amd64.deb
                    google-chrome --version
                    CHROME_VERSION=$(google-chrome --version | grep -oP "\\d+\\.\\d+\\.\\d+\\.\\d+")
                    echo "Chrome version is $CHROME_VERSION"
                    curl -O https://storage.googleapis.com/chrome-for-testing-public/${CHROME_VERSION}/linux64/chromedriver-linux64.zip
                    unzip chromedriver-linux64.zip
                    mv chromedriver-linux64/chromedriver /usr/bin/
                    rm chromedriver-linux64.zip
                    chmod +x /usr/bin/chromedriver
                    which google-chrome
                '''
            }
        }
        stage('Build Project') {
            steps {
                sh '''
                    mvn clean install -DskipTests
                    echo 'Project built successfully!'
                '''
            }
        }
        stage('Run Tests') {
            steps {
                sh '''
                    mvn test
                    echo 'Tests executed successfully!'
                '''
            }
        }
    }

    post {
        always {
            sh '''
                echo 'Cleaning up...'
                apt remove -y google-chrome-stable
                apt autoremove -y
                echo 'Cleanup completed!'
            '''
        }
    }
}