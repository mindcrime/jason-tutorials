#!/bin/bash

clear

echo $1

if [ -z $1 ]
then

    java -Djava.awt.headless=false -cp target/spring_jason4-0.0.1.jar -Dloader.main=org.fogbeam.demo.ListAppsApplication  org.springframework.boot.loader.PropertiesLauncher

else
    
    java -Djava.awt.headless=false -cp target/spring_jason4-0.0.1.jar -Dloader.main=org.fogbeam.demo.$1Application  org.springframework.boot.loader.PropertiesLauncher

fi
