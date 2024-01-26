#!/usr/bin/env groovy
import com.main.Docker

def call(String imageName){
    return new Docker(this).dockerLogin(imageName)
}