def call() {
    pipeline {
        agent {
            node {
                label 'workstation'
            }
        }

        parameters {
            string(name: 'INFRA-ENV', defaultvalue: '', description: 'Enter Env like dev or prod')
        }
        stages {
            stage('terrafoem init') {
                steps {
                    sh "terraform init -backend-config=env-${INFRA-ENV}/state.tfvars"
                }
            }
        }

    }
}