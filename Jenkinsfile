node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git branch: 'test', credentialsId: 'SSH-iHorizonsLaptop', url: 'https://github.com/mahmoudsamy1610/EngineSamy'
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
                bat(/"%MVN_HOME%\bin\mvn" clean test -P$Profile -Denv=$ProfileEnv /)
            }
        }
    }
    stage('Results') {
        allure jdk: 'JAVA_HOME', report: 'allure-reports', results: [[path: 'allure-results']]
        testNG failureOnFailedTestConfig: true, reportFilenamePattern: 'target/surefire-reports/testng-results.xml', showFailedBuilds: true, unstableSkips: 0
        emailext attachLog: true, body: '$DEFAULT_CONTENT', subject: '$DEFAULT_CONTENT', to: 'mahmoud.samy1610@gmail.com,mahmoud.samy1610+1@gmail.com,'
    }
}
