#!/usr/bin/env groovy
import com.main.Docker

//def call(){
//    echo 'building the jar...'
//    sh 'mvn clean install'
//}


def call(){
    return new Docker(this).buildJar()
}