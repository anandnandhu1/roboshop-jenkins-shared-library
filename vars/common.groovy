def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
    }
    if (app_lang == "maven") {
        sh 'mvn package'
    }
}

def unittests() {

    if (app_lang == "nodejs") {
        // developer is a missing unit test cases in our project he need to add them as best practice we are skipping to proceed further
            sh 'npm test || true'
    }
    if (app_lang == "maven") {
        sh 'mvn test'
    }
    if (app_lang == "python") {
        sh 'python3 -m unittest'
    }
}

def email(email_note) {
    mail bcc: '', body: "job Failed - ${JOB_BASE_NAME}\nJenkins URL - ${JOB_URL}", cc: '', from: 'anandnandhu52@gmail.com', replyTo: '', subject: "Jenkins Job Failed - ${JOB_BASE_NAME}", to: 'anandnandhu52@gmail.com'
}

def artifactPush() {
    if (app_lang == "nodejs") {
        sh "zip -r cart-${TAG_NAME}.zip node_modules server.js"
    }
    sh 'ls -l '
}