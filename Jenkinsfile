pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    stages {
        stage('Install Chrome Driver and Browser') {
            steps {
                sh """
                    sudo apt update
                    curl -O https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
                    sudo apt install -y ./google-chrome-stable_current_amd64.deb
                    rm google-chrome-stable_current_amd64.deb
                    google-chrome --version
                    CHROME_VERSION=$(google-chrome --version | grep -oP '\d+\.\d+\.\d+\.\d+')
                    echo "Chrome version is $CHROME_VERSION"
                    curl -O https://storage.googleapis.com/chrome-for-testing-public/${CHROME_VERSION}/linux64/chromedriver-linux64.zip
                    unzip chromedriver-linux64.zip
                    sudo mv chromedriver-linux64/chromedriver /usr/bin/
                    rm chromedriver-linux64.zip
                    chmod +x /usr/bin/chromedriver
                    which google-chrome
                """
            }
        }
        stage('Build Project') {
            steps {
                sh """
                    mvn clean install -DskipTests
                    echo 'Project built successfully!'
                """
            }
        }
        stage('Run Tests') {
            steps {
                sh """
                    mvn test
                    echo 'Tests executed successfully!'
                """
            }
        }
    }

    post {
        always {
            sh """
                echo 'Cleaning up...'
                sudo apt remove -y google-chrome-stable
                sudo apt autoremove -y
                echo 'Cleanup completed!'
            """
        }
    }
}