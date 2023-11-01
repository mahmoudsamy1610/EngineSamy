node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git branch: 'main', changelog: false, credentialsId: 'SSH', poll: false, url: 'https://github.com/mahmoudsamy1610/Autofox'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -PBStack clean test/)
            }
        }
    }
    stage('Results') {
        allure includeProperties: false, jdk: '', report: 'src/test/resources/testReports', results: [[path: 'allure-results']]
        testNG failureOnFailedTestConfig: true, reportFilenamePattern: 'target/surefire-reports/testng-results.xml', showFailedBuilds: true, unstableSkips: 0
        emailext attachLog: true, body: '$DEFAULT_CONTENT', subject: '$DEFAULT_CONTENT', to: 'mahmoud.samy1610@gmail.com,mahmoud.samy1610+1@gmail.com,'
    }
}
