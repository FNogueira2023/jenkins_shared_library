#!/usr/bin/env groovy

def call(){
    echo "building the jar of branch $BRANCH_NAME ..."
    sh 'mvn clean install'
}
