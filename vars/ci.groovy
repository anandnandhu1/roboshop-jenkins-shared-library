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
    } catch(Exception e) {
        common.email("failed")
    }
}