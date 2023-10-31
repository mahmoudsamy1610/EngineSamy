pipeline {
    agent any
    

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mahmoudsamy1610/Autofox'

                // Run Maven on a Unix agent. "test change_8"
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -PRunConfig clean test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    allure includeProperties: false, jdk: '', report: 'src/test/resources/testReports', results: [[path: 'allure-results']]

                }
            }
        }
    }
}
