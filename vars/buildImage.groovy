#!/usr/bin/env groovy
def call(String image_name){
        echo 'building the image...'
        withCredentials([usernamePassword(credentialsId:'docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER' )]) {
            sh "docker build -t $image_name ."
            sh "echo $PASSWORD | docker login -u $USER --password-stdin"
            sh "docker push $image_name"
                
    }
}
