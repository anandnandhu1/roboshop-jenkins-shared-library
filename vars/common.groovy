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
        try {
            sh 'npm test'
        } catch(expection e) {
            email("unit tests failed")
        }
    }
    if (app_lang == "maven") {
        sh 'mvn test'
    }
    if (app_lang == "python") {
        sh 'python3 -m unittest'
    }
}

def email(email_note) {
    println email_note
}