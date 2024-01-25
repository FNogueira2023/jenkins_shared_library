#!/usr/bin/env groovy
def call(String imageName){
        echo 'building the image...'
        withCredentials([usernamePassword(credentialsId:'docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER' )]) {
            sh "docker build -t $imageName ."
            sh "echo $PASSWORD | docker login -u $USER --password-stdin"
            sh "docker push $imageName"
                
    }
}
