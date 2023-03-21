def call() {
    try {
        pipeline {

            agent {
                label 'workstation'
            }

            stages {
                stage('compile/build') {
                    steps {
                        script {
                            common.compile()
                        }
                    }
                }

                stage('unit tests') {
                    steps {
                        script {
                            common.unittests()
                        }
                    }
                }

                stage('quality control') {
                    steps {
                        sh 'sonar-scanner -Dsonar.host.url=http://172.31.11.39:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                    }
                }

                stage('upload the code to quality control') {
                    steps {
                        echo 'upload'
                    }
                }

            }

        }
    } catch(Exception e) {
        common.email("failed")
    }
}