#!/usr/bin/env groovy
package com.main

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.echo 'building the image...'
        script.sh "docker build -t $imageName ."
    }

    def buildJar(){
        script.echo 'building the jar...'
        script.sh "mvn clean install"
    }

    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'docker_hub', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASSWORD | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String imageName){
        script.sh "docker push $imageName"
    }
}