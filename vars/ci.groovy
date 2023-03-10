def call() {
    pipeline {

        agent {
            label 'workstation'
        }

        stages {
            stage('compile/build') {
                steps {
                    echo 'compile'
                }
            }

            stage('unit tests') {
                steps {
                    echo 'unit tests'
                }
            }

            stage('quality control') {
                steps {
                    echo 'quality control'
                }
            }

            stage('upload the code to quality control') {
                steps {
                    echo 'upload'
                }
            }

        }

    }
}