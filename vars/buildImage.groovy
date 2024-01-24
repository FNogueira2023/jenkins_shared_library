#!/usr/bin/env groovy
def call(){
        echo 'building the image...'
        withCredentials([usernamePassword(credentialsId:'docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER' )]) {
            sh 'docker build -t fnogueira2023/multi_peru_5:1.0 .'
            sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
            sh 'docker push fnogueira2023/multi_peru_5:1.0 '

    }
}